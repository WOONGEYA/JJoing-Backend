package com.woongeya.zoing.domain.notice.domain.repository;

import com.woongeya.zoing.domain.notice.domain.Notification;
import com.woongeya.zoing.domain.notice.domain.type.NotificationState;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    Long countByToUserIdAndState(Long toUserId, NotificationState state);
    List<Notification> findByToUserId(Long toUserId);
}
