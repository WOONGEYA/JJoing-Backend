package com.woongeya.zoing.domain.application.service;

import com.woongeya.zoing.domain.application.ApplicationFacade;
import com.woongeya.zoing.domain.application.domain.Application;
import com.woongeya.zoing.domain.application.domain.repository.ApplicationRepository;
import com.woongeya.zoing.domain.auth.repository.AuthRepository;
import com.woongeya.zoing.domain.notice.domain.Notification;
import com.woongeya.zoing.domain.notice.domain.repository.NotificationRepository;
import com.woongeya.zoing.domain.notice.domain.type.NotificationState;
import com.woongeya.zoing.domain.project.domain.Member;
import com.woongeya.zoing.domain.project.domain.Project;
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
    private final AuthRepository authRepository;
    private final ProjectFacade projectFacade;
    private final MemberRepository memberRepository;
    private final NotificationRepository notificationRepository;
    private final ApplicationRepository applicationRepository;

    @Transactional
    public void execute(Long id) {
        User writer = authRepository.getCurrentUser();
        Application application = applicationFacade.getApplication(id);
        Project project = projectFacade.getProject(application.getProjectId());
        Member member = memberRepository.findByUserIdAndProjectId(writer.getId(), project.getId())
                .orElseThrow(MemberNotFoundException::new);

        member.acceptApplication(application);
        memberRepository.save(
                Member.builder()
                        .userId(application.getUserId())
                        .project(project)
                        .role(Role.MEMBER)
                        .build()
        );
        project.increaseCurrentPeople();
        project.isFull();

        notificationRepository.save(
                Notification.builder()
                        .title(writer.getNickName() + " 님이 " + project.getName() + " 프로젝트 쪼잉을 수락하셨어요.")
                        .content("이제부터 " + project.getName() + " 프로젝트의 일원이 되셨어요!")
                        .toUserId(application.getUserId())
                        .fromUserId(writer.getId())
                        .projectId(project.getId())
                        .applicationId(application.getId())
                        .state(NotificationState.UNCHECK)
                        .build()
        );
    }
}
