package com.woongeya.zoing.domain.notice.service;

import com.woongeya.zoing.domain.auth.repository.AuthRepository;
import com.woongeya.zoing.domain.notice.domain.repository.NotificationRepository;
import com.woongeya.zoing.domain.notice.domain.type.NotificationState;
import com.woongeya.zoing.domain.user.UserFacade;
import com.woongeya.zoing.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CountNotificationService {

    private final NotificationRepository notificationRepository;
    private final AuthRepository authRepository;

    public Long execute() {
        User user = authRepository.getCurrentUser();
        return notificationRepository.countByToUserIdAndState(user.getId(), NotificationState.UNCHECK);
    }
}
