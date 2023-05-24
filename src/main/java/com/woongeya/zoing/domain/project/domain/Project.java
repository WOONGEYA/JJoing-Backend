package com.woongeya.zoing.domain.project.domain;


import com.woongeya.zoing.domain.project.domain.type.State;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    private State state;

    @Column(length = 32)
    private String writer;

    @CreatedDate
    private LocalDate createDate;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Member> members = new ArrayList<>();

    @Builder

    public Project(String name, String content, State state, String writer, List<Member> members) {
        this.name = name;
        this.content = content;
        this.state = state;
        this.writer = writer;
        this.members = members;
    }

    public void changeState() {
        this.state = State.FOUND;
    }
}
