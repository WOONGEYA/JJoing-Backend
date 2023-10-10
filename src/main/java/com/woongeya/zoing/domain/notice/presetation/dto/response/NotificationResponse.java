package com.woongeya.zoing.domain.notice.presetation.dto.response;

import com.woongeya.zoing.domain.notice.domain.Notification;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class NotificationResponse {

    private Long id;
    private String title;
    private String content;
    private Long applicationId;
    private Long projectId;
    private Long userId;

    public static NotificationResponse of(Notification notification) {
        return NotificationResponse.builder()
                .id(notification.getId())
                .title(notification.getTitle())
                .content(notification.getContent())
                .applicationId(notification.getApplicationId())
                .projectId(notification.getProjectId())
                .userId(notification.getUserId())
                .build();
    }
}
