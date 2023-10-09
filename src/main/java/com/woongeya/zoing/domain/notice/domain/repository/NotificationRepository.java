package com.woongeya.zoing.domain.notice.domain.repository;

import com.woongeya.zoing.domain.notice.domain.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    Long countByUserId(Long id);
    List<Notification> findByUserId(Long id);
}
