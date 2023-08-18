package com.woongeya.zoing.domain.project.domain;


import com.woongeya.zoing.domain.project.domain.type.ProjectState;
import com.woongeya.zoing.domain.project.presetation.dto.request.CreateProjectRequestDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;

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

    @Column(nullable = false)
    private Long viewCount;

    @Column(nullable = false, length = 16)
    @Enumerated(EnumType.STRING)
    private ProjectState state;

    @CreatedDate
    private LocalDate createDate;

    @Column(length = 50)
    private String moodType;

    @Column(length = 200)
    private String skill;

    @Column(length = 200)
    private String communicationTool;

    @Embedded
    private Position position;

    @Builder
    public Project(String name, String content, Long viewCount, ProjectState state, LocalDate createDate, String moodType, String skill, String communicationTool, Position position) {
        this.name = name;
        this.content = content;
        this.viewCount = viewCount;
        this.state = state;
        this.createDate = createDate;
        this.moodType = moodType;
        this.skill = skill;
        this.communicationTool = communicationTool;
        this.position = position;
    }

    public void close() {
        this.state = ProjectState.FOUND;
    }

    public void increaseViewCnt() {
        this.viewCount++;
    }

    @PrePersist
    public void createAt() {
        this.createDate = LocalDate.now();
    }

    public void update(CreateProjectRequestDto request) {
        this.name = request.getName();
        this.position = request.getPosition();
        this.content = request.getContent();
        this.moodType = request.getMoodType();
        this.communicationTool = request.getCommunicationTool();
        this.skill = request.getSkill();
    }
}
