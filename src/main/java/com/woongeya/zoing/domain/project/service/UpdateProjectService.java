package com.woongeya.zoing.domain.project.service;

import com.woongeya.zoing.domain.project.domain.Member;
import com.woongeya.zoing.domain.project.domain.Position;
import com.woongeya.zoing.domain.project.domain.Project;
import com.woongeya.zoing.domain.project.domain.repository.CustomMemberRepository;
import com.woongeya.zoing.domain.project.domain.repository.PositionRepository;
import com.woongeya.zoing.domain.project.exception.IsNotWriterException;
import com.woongeya.zoing.domain.project.exception.MemberNotFoundException;
import com.woongeya.zoing.domain.project.facade.ProjectFacade;
import com.woongeya.zoing.domain.project.presetation.dto.request.CreateProjectRequestDto;
import com.woongeya.zoing.domain.user.UserFacade;
import com.woongeya.zoing.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UpdateProjectService {

    private final CustomMemberRepository customMemberRepository;
    private final ProjectFacade projectFacade;
    private final UserFacade userFacade;
    private final PositionRepository positionRepository;

    @Transactional
    public void execute(Long id, CreateProjectRequestDto request) {
        Project project = projectFacade.getProject(id);
        User user = userFacade.getCurrentUser();
        List<Position> positions = positionRepository.findByProjectId(project.getId());

        Member member = customMemberRepository.findByUserIdAndProjectId(user.getId(), project.getId())
                .orElseThrow(() -> MemberNotFoundException.EXCEPTION);

        if (!checkMember(member)) {
            throw new IsNotWriterException();
        }

        positions.forEach(position -> position.update(request));
        project.update(request);
    }

    public boolean checkMember(Member member) {
        return member.isWriter();
    }
}
