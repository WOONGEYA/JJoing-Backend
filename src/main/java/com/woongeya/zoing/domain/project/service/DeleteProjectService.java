package com.woongeya.zoing.domain.project.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woongeya.zoing.domain.application.domain.repository.ApplicationRepository;
import com.woongeya.zoing.domain.auth.repository.AuthRepository;
import com.woongeya.zoing.domain.like.domain.repository.LikeRepository;
import com.woongeya.zoing.domain.project.domain.Member;
import com.woongeya.zoing.domain.project.domain.Project;
import com.woongeya.zoing.domain.project.domain.repository.CoopRepository;
import com.woongeya.zoing.domain.project.domain.repository.MemberRepository;
import com.woongeya.zoing.domain.project.domain.repository.MoodRepository;
import com.woongeya.zoing.domain.project.domain.repository.PositionRepository;
import com.woongeya.zoing.domain.project.domain.repository.ProjectRepository;
import com.woongeya.zoing.domain.project.domain.repository.SkillRepository;
import com.woongeya.zoing.domain.project.exception.IsNotWriterException;
import com.woongeya.zoing.domain.project.exception.MemberNotFoundException;
import com.woongeya.zoing.domain.project.facade.ProjectFacade;
import com.woongeya.zoing.domain.user.domain.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeleteProjectService {

    private final ProjectRepository projectRepository;
    private final ApplicationRepository applicationRepository;
    private final MemberRepository memberRepository;
    private final CoopRepository coopRepository;
    private final PositionRepository positionRepository;
    private final LikeRepository likeRepository;
    private final SkillRepository skillRepository;
    private final MoodRepository moodRepository;
    private final ProjectFacade projectFacade;
    private final AuthRepository authRepository;

    @Transactional
    public void execute(Long id) {
        User user = authRepository.getCurrentUser();
        Project project = projectFacade.getProject(id);
        Member member = memberRepository.findByUserIdAndProjectId(user.getId(), project.getId())
                .orElseThrow(MemberNotFoundException::new);

        if (!member.isWriter()) {
            throw new IsNotWriterException();
        }

        deleteAll(project);
    }

    private void deleteAll(Project project) {
        applicationRepository.deleteByProjectId(project.getId());
        memberRepository.deleteByProjectId(project.getId());
        moodRepository.deleteByProjectId(project.getId());
        skillRepository.deleteByProjectId(project.getId());
        coopRepository.deleteByProjectId(project.getId());
        positionRepository.deleteByProjectId(project.getId());
        likeRepository.deleteByProjectId(project.getId());
        projectRepository.delete(project);
    }


}
