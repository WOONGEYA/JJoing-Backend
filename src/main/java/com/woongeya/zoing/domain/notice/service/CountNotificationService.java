package com.woongeya.zoing.domain.notice.service;

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
    private final UserFacade userFacade;

    public Long execute() {
        User user = userFacade.getCurrentUser();
        return notificationRepository.countByToUserIdAndState(user.getId(), NotificationState.UNCHECK);
    }
}
