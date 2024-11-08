package com.woongeya.zoing.domain.application.service;

import com.woongeya.zoing.domain.application.ApplicationFacade;
import com.woongeya.zoing.domain.application.domain.Application;
import com.woongeya.zoing.domain.application.domain.repository.ApplicationRepository;
import com.woongeya.zoing.domain.notice.domain.Notification;
import com.woongeya.zoing.domain.notice.domain.repository.NotificationRepository;
import com.woongeya.zoing.domain.notice.domain.type.NotificationState;
import com.woongeya.zoing.domain.project.domain.Member;
import com.woongeya.zoing.domain.project.domain.Project;
import com.woongeya.zoing.domain.project.domain.repository.MemberRepository;
import com.woongeya.zoing.domain.project.exception.MemberNotFoundException;
import com.woongeya.zoing.domain.project.facade.ProjectFacade;
import com.woongeya.zoing.domain.user.UserFacade;
import com.woongeya.zoing.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RejectApplicationService {

    private final AuthRepository authRepository;
    private final ApplicationFacade applicationFacade;
    private final ProjectFacade projectFacade;
    private final MemberRepository memberRepository;
    private final NotificationRepository notificationRepository;
    private final ApplicationRepository applicationRepository;

    @Transactional
    public void execute(Long id) {
        User user = authRepository.getCurrentUser();
        Application application = applicationFacade.getApplication(id);
        Member member = memberRepository.findByUserIdAndProjectId(user.getId(), application.getProjectId())
                .orElseThrow(() -> MemberNotFoundException.EXCEPTION);
        Project project = projectFacade.getProject(application.getId());

        member.rejectApplication(application);
        notificationRepository.save(
                Notification.builder()
                        .title(project.getName() + "의 쪼잉이 거절되었어요.")
                        .content("아쉽지만 다른 프로젝트 찾아보기")
                        .toUserId(application.getUserId())
                        .fromUserId(user.getId())
                        .projectId(application.getProjectId())
                        .state(NotificationState.UNCHECK)
                        .build()
        );

        notificationRepository.deleteByApplicationId(id);
        applicationRepository.delete(application);
    }
}
