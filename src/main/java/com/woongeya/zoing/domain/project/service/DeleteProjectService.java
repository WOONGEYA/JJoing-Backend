package com.woongeya.zoing.domain.project.service;

import com.woongeya.zoing.domain.project.domain.repository.CustomMemberRepository;
import com.woongeya.zoing.domain.project.exception.MemberNotFoundException;
import com.woongeya.zoing.domain.project.facade.ProjectFacade;
import com.woongeya.zoing.domain.project.domain.Member;
import com.woongeya.zoing.domain.project.domain.Project;
import com.woongeya.zoing.domain.project.domain.repository.MemberRepository;
import com.woongeya.zoing.domain.project.domain.repository.ProjectRepository;
import com.woongeya.zoing.domain.project.exception.IsNotWriterException;
import com.woongeya.zoing.domain.user.UserFacade;
import com.woongeya.zoing.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DeleteProjectService {

    private final ProjectRepository projectRepository;
    private final MemberRepository memberRepository;
    private final CustomMemberRepository customMemberRepository;
    private final ProjectFacade projectFacade;
    private final UserFacade userFacade;

    @Transactional
    public void execute(Long id) {
        User user = userFacade.getCurrentUser();
        Project project = projectFacade.getProject(id);
        Member member = customMemberRepository.findByUserIdAndProjectId(user.getId(), project.getId())
                .orElseThrow(() -> MemberNotFoundException.EXCEPTION);

        if (!member.isWriter()) {
            throw new IsNotWriterException();
        }

        memberRepository.delete(member);
        projectRepository.delete(project);
    }
}
