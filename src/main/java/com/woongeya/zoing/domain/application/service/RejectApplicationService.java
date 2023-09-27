package com.woongeya.zoing.domain.application.service;

import com.woongeya.zoing.domain.application.ApplicationFacade;
import com.woongeya.zoing.domain.application.domain.Application;
import com.woongeya.zoing.domain.application.domain.repository.ApplicationRepository;
import com.woongeya.zoing.domain.notice.domain.Notification;
import com.woongeya.zoing.domain.notice.domain.repository.NotificationRepository;
import com.woongeya.zoing.domain.project.domain.Member;
import com.woongeya.zoing.domain.project.domain.Project;
import com.woongeya.zoing.domain.project.domain.repository.CustomMemberRepository;
import com.woongeya.zoing.domain.project.domain.repository.ProjectRepository;
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

    private final UserFacade userFacade;
    private final ApplicationFacade applicationFacade;
    private final ProjectFacade projectFacade;
    private final CustomMemberRepository customMemberRepository;
    private final NotificationRepository notificationRepository;
    private final ApplicationRepository applicationRepository;

    @Transactional
    public void execute(Long id) {
        User user = userFacade.getCurrentUser();
        Application application = applicationFacade.getApplication(id);
        Member member = customMemberRepository.findByUserIdAndProjectId(user.getId(), application.getProjectId())
                .orElseThrow(() -> MemberNotFoundException.EXCEPTION);
        Project project = projectFacade.getProject(application.getId());

        member.rejectApplication(application);
        notificationRepository.save(
                Notification.builder()
                        .title(project.getName() + "의 쪼잉이 거절되었어요.")
                        .content("아쉽지만 다른 프로젝트 찾아보기")
                        .userId(application.getUserId())
                        .build()
        );

        applicationRepository.delete(application);
    }
}
