package com.woongeya.zoing.domain.application.domain;

import static com.woongeya.zoing.domain.application.domain.type.ApplicationState.*;

import java.util.Objects;

import com.woongeya.zoing.domain.application.domain.type.ApplicationState;
import com.woongeya.zoing.domain.user.domain.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    @Column(nullable = false)
    private String position;

    @Column(nullable = false)
    private String phone;

    private Long userId;

    private Long projectId;

    @Builder
    public Application(String introduce, ApplicationState state, String position, String phone, Long userId, Long projectId) {
        this.introduce = introduce;
        this.state = state;
        this.position = position;
        this.phone = phone;
        this.userId = userId;
        this.projectId = projectId;
    }

    public boolean isWriter(User user) {
        return Objects.equals(userId, user.getId());
    }

    public void cancel() {
        this.state = CANCEL;
    }

    public void reject() {
        this.state = REJECT;
    }

    public void accept() {
        this.state = ACCEPT;
    }
}
