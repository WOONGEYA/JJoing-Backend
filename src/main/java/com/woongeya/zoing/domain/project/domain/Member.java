package com.woongeya.zoing.domain.project.domain;

import com.woongeya.zoing.domain.application.domain.Application;
import com.woongeya.zoing.domain.project.domain.type.Role;
import com.woongeya.zoing.domain.project.exception.IsNotWriterException;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private Long userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Builder
    public Member(Long userId, Project project, Role role) {
        this.userId = userId;
        this.project = project;
        this.role = role;
    }

    public boolean isWriter() {
        return Objects.equals(this.role, Role.WRITER);
    }

    public void rejectApplication(Application application) {
        if (role != Role.WRITER) {
            throw new IsNotWriterException();
        }

        application.reject();
    }
}
