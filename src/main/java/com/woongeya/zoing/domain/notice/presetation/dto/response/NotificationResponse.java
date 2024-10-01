package com.woongeya.zoing.domain.notice.presetation.dto.response;

import com.woongeya.zoing.domain.notice.domain.Notification;

import lombok.Builder;

@Builder
public record NotificationResponse (
     Long id,
     String title,
     String content,
     Long applicationId,
     Long projectId,
     Long toUserId,
     Long fromUserId
) {
    public static NotificationResponse from(Notification notification) {
        return NotificationResponse.builder()
                .id(notification.getId())
                .title(notification.getTitle())
                .content(notification.getContent())
                .applicationId(notification.getApplicationId())
                .projectId(notification.getProjectId())
                .toUserId(notification.getToUserId())
                .fromUserId(notification.getFromUserId())
                .build();
    }
}
