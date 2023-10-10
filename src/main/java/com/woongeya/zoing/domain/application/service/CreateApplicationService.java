package com.woongeya.zoing.domain.application.service;

import com.woongeya.zoing.domain.application.domain.Application;
import com.woongeya.zoing.domain.application.domain.repository.ApplicationRepository;
import com.woongeya.zoing.domain.application.domain.type.ApplicationState;
import com.woongeya.zoing.domain.application.exception.AlreadyApplicationException;
import com.woongeya.zoing.domain.application.presetation.dto.request.ApplicationCreateRequest;
import com.woongeya.zoing.domain.notice.domain.Notification;
import com.woongeya.zoing.domain.notice.domain.repository.NotificationRepository;
import com.woongeya.zoing.domain.notice.domain.type.NotificationState;
import com.woongeya.zoing.domain.project.domain.Member;
import com.woongeya.zoing.domain.project.domain.Project;
import com.woongeya.zoing.domain.project.domain.repository.MemberRepository;
import com.woongeya.zoing.domain.project.domain.type.Role;
import com.woongeya.zoing.domain.project.facade.ProjectFacade;
import com.woongeya.zoing.domain.user.UserFacade;
import com.woongeya.zoing.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateApplicationService {

    private final UserFacade userFacade;
    private final ProjectFacade projectFacade;
    private final ApplicationRepository applicationRepository;
    private final NotificationRepository notificationRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public void execute(ApplicationCreateRequest request, Long id) {

        User user = userFacade.getCurrentUser();
        Project project = projectFacade.getProject(id);
        Member member = memberRepository.findByProjectIdAndRole(project.getId(), Role.WRITER);
        User writer = userFacade.getUserById(member.getUserId());

        applicationRepository.findByUserIdAndProjectId(user.getId(), project.getId())
                .ifPresent(application -> { throw new AlreadyApplicationException(); });

        Long applicationId = applicationRepository.save(
                Application.builder()
                        .userId(user.getId())
                        .projectId(project.getId())
                        .introduce(request.getIntroduce())
                        .phone(request.getPhone())
                        .state(ApplicationState.PENDING)
                        .position(request.getPosition())
                        .build()
        ).getId();

        notificationRepository.save(
                Notification.builder()
                        .title(user.getNickName() + " 님으로부터 " + project.getName() + " 프로젝트 쪼잉 신청이 왔어요.")
                        .content("알림을 눌러 프로필과 한 줄 소개를 확인해 보세요 !")
                        .userId(writer.getId())
                        .projectId(project.getId())
                        .applicationId(applicationId)
                        .state(NotificationState.UNCHECK)
                        .build()
        );
    }
}
