package com.woongeya.zoing.domain.project.domain;

import com.woongeya.zoing.domain.project.domain.type.Role;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    @ManyToOne(fetch = FetchType.LAZY)
    private Project project;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Builder
    public Member(Long userId, Project project, Role role) {
        this.userId = userId;
        this.project = project;
        this.role = role;
    }
}
