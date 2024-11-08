package com.woongeya.zoing.domain.notice.service;

import com.woongeya.zoing.domain.auth.repository.AuthRepository;
import com.woongeya.zoing.domain.notice.domain.Notification;
import com.woongeya.zoing.domain.notice.domain.repository.NotificationRepository;
import com.woongeya.zoing.domain.notice.presetation.dto.response.NotificationResponse;
import com.woongeya.zoing.domain.user.UserFacade;
import com.woongeya.zoing.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FindNotificationService {

    private final NotificationRepository notificationRepository;
    private final AuthRepository authRepository;

    @Transactional()
    public List<NotificationResponse> execute() {
        User user = authRepository.getCurrentUser();
        List<Notification> notifications = notificationRepository.findByToUserId(user.getId());
        notifications.forEach(Notification::checkState);

        return notifications.stream()
                .map(NotificationResponse::from)
                .collect(Collectors.toList());
    }
}
