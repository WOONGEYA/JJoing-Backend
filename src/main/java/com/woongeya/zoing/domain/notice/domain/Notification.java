package com.woongeya.zoing.domain.notice.domain;

import com.woongeya.zoing.domain.notice.domain.type.NotificationState;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    private Long userId;

    private Long projectId;

    private Long applicationId;

    @Enumerated(EnumType.STRING)
    private NotificationState state;

    @Builder
    public Notification(String title, String content, Long userId, Long projectId, Long applicationId, NotificationState state) {
        this.title = title;
        this.content = content;
        this.userId = userId;
        this.projectId = projectId;
        this.applicationId = applicationId;
        this.state = state;
    }

    public void checkState() {
        this.state = NotificationState.CHECK;
    }
}
