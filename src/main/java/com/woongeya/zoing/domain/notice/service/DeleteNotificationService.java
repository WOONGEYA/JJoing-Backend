package com.woongeya.zoing.domain.notice.service;

import com.woongeya.zoing.domain.notice.domain.Notification;
import com.woongeya.zoing.domain.notice.domain.repository.NotificationRepository;
import com.woongeya.zoing.domain.notice.exception.NotificationNotFoundException;
import com.woongeya.zoing.domain.user.UserFacade;
import com.woongeya.zoing.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteNotificationService {

    private final UserFacade userFacade;
    private final NotificationRepository notificationRepository;

    public void execute(Long id) {
        User user = userFacade.getCurrentUser();
        Notification notification = notificationRepository.findById(id)
                .orElseThrow(() -> NotificationNotFoundException.EXCEPTION);

        notificationRepository.delete(notification);
    }
}
