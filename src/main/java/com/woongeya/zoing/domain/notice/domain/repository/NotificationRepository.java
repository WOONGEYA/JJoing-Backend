package com.woongeya.zoing.domain.notice.domain.repository;

import com.woongeya.zoing.domain.notice.domain.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}