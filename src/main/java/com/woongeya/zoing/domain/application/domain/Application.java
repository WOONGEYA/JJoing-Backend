package com.woongeya.zoing.domain.application.domain;

import com.woongeya.zoing.domain.project.domain.Project;
import com.woongeya.zoing.domain.user.domain.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "project_id")
    private Project project;

    @Builder
    public Application(String introduce, User user, Project project) {
        this.introduce = introduce;
        this.user = user;
        this.project = project;
    }
}
