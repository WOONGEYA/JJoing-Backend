package com.woongeya.zoing.domain.notice.service;

import com.woongeya.zoing.domain.auth.repository.AuthRepository;
import com.woongeya.zoing.domain.notice.domain.Notification;
import com.woongeya.zoing.domain.notice.domain.repository.NotificationRepository;
import com.woongeya.zoing.domain.user.UserFacade;
import com.woongeya.zoing.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeleteAllNotificationService {

    private final AuthRepository authRepository;
    private final NotificationRepository notificationRepository;

    public void execute() {
        User user = authRepository.getCurrentUser();
        List<Notification> notifications = notificationRepository.findByToUserId(user.getId());

        notificationRepository.deleteAll(notifications);
    }
}
