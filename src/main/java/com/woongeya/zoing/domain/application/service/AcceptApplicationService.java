package com.woongeya.zoing.domain.application.service;

import com.woongeya.zoing.domain.application.ApplicationFacade;
import com.woongeya.zoing.domain.application.domain.Application;
import com.woongeya.zoing.domain.project.domain.Member;
import com.woongeya.zoing.domain.project.domain.Project;
import com.woongeya.zoing.domain.project.domain.repository.CustomMemberRepository;
import com.woongeya.zoing.domain.project.domain.repository.MemberRepository;
import com.woongeya.zoing.domain.project.domain.type.Role;
import com.woongeya.zoing.domain.project.exception.MemberNotFoundException;
import com.woongeya.zoing.domain.project.facade.ProjectFacade;
import com.woongeya.zoing.domain.user.UserFacade;
import com.woongeya.zoing.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AcceptApplicationService {

    private final ApplicationFacade applicationFacade;
    private final UserFacade userFacade;
    private final ProjectFacade projectFacade;
    private final CustomMemberRepository customMemberRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public void execute(Long id) {
        User user = userFacade.getCurrentUser();
        Application application = applicationFacade.getApplication(id);
        Project project = projectFacade.getProject(application.getId());
        Member member = customMemberRepository.findByUserIdAndProjectId(user.getId(), project.getId())
                .orElseThrow(() -> MemberNotFoundException.EXCEPTION);

        member.acceptApplication(application);
        memberRepository.save(
                Member.builder()
                        .userId(application.getUserId())
                        .project(project)
                        .role(Role.MEMBER)
                        .build()
        );
        project.increaseCurrentPeople();
    }
}
