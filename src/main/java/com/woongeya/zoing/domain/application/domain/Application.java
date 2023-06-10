package com.woongeya.zoing.domain.application.domain;

import com.woongeya.zoing.domain.application.domain.type.ApplicationJobPosition;
import com.woongeya.zoing.domain.application.domain.type.ApplicationState;
import com.woongeya.zoing.domain.project.domain.Project;
import com.woongeya.zoing.domain.user.domain.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.Objects;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.FetchType.LAZY;

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

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "project_id")
    private Project project;

    @Builder
    public Application(String introduce, ApplicationState state, ApplicationJobPosition position, User user, Project project) {
        this.introduce = introduce;
        this.state = state;
        this.position = position;
        this.user = user;
        this.project = project;
    }

    public boolean isWriter(Long id) {
        return Objects.equals(user.getId(), id);
    }

    public void cancel() {
        this.state = ApplicationState.CANCEL;
    }

    public void reject() { this.state = ApplicationState.REJECT; }

    public boolean isProjectWriter(User user) {
        return Objects.equals(this.user, user); }
}
