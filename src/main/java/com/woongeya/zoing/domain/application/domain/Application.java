package com.woongeya.zoing.domain.application.domain;

import com.woongeya.zoing.domain.application.domain.type.ApplicationJobPosition;
import com.woongeya.zoing.domain.application.domain.type.ApplicationState;
import com.woongeya.zoing.domain.user.domain.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 128)
    private String introduce;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ApplicationState state;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ApplicationJobPosition position;

    private Long userId;

    private Long projectId;

    private Long projectWriterId;

    @Builder
    public Application(String introduce, ApplicationState state, ApplicationJobPosition position, Long userId, Long projectId, Long projectWriterId) {
        this.introduce = introduce;
        this.state = state;
        this.position = position;
        this.userId = userId;
        this.projectId = projectId;
        this.projectWriterId = projectWriterId;
    }

    public boolean isWriter(User user) {
        return Objects.equals(user, user.getId());
    }

    public void cancel() {
        this.state = ApplicationState.CANCEL;
    }

    public void reject() { this.state = ApplicationState.REJECT; }

    public boolean isProjectWriter(User user) {
        return Objects.equals(projectWriterId, user.getId());
    }
}
