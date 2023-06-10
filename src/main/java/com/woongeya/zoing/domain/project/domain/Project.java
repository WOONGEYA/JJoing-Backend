package com.woongeya.zoing.domain.project.domain;


import com.woongeya.zoing.domain.project.domain.type.ProjectState;
import com.woongeya.zoing.domain.user.domain.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private Long id;

    @Column(length = 32)
    private String name;

    @Column(length = 1024)
    private String content;

    @Column(nullable = false, length = 16)
    @Enumerated(EnumType.STRING)
    private ProjectState state;

    @CreatedDate
    private LocalDate createDate;

    @ManyToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User writer;

    @Builder
    public Project(String name, String content, ProjectState state, LocalDate createDate, User writer) {
        this.name = name;
        this.content = content;
        this.state = state;
        this.createDate = createDate;
        this.writer = writer;
    }

    public void changeState() {
        this.state = ProjectState.FOUND;
    }

    public boolean isWriter(Long userId) {
        return Objects.equals(this.writer.getId(), userId);
    }

    @PrePersist
    public void createAt() {
        this.createDate = LocalDate.now();
    }
}
