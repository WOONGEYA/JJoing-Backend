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

    @Column(nullable = false)
    private Integer requiredPeople;

    @Column(nullable = false)
    private Integer currentPeople;

    @CreatedDate
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;

    @Column(length = 200)
    private String skill;

    @Column(length = 200)
    private String communicationTool;

    @Builder
    public Project(String name, String content, Long viewCount, ProjectState state, Integer requiredPeople, Integer currentPeople, LocalDate startDate, LocalDate endDate, String skill, String communicationTool) {
        this.name = name;
        this.content = content;
        this.viewCount = viewCount;
        this.state = state;
        this.requiredPeople = requiredPeople;
        this.currentPeople = currentPeople;
        this.startDate = startDate;
        this.endDate = endDate;
        this.skill = skill;
        this.communicationTool = communicationTool;
    }

    public void close() {
        this.state = ProjectState.FOUND;
    }

    public void increaseViewCnt() {
        this.viewCount++;
    }

    public void increaseCurrentPeople() {
        this.currentPeople++;
    }
    public void decreaseCurrentPeople() {
        this.currentPeople--;
    }

    @PrePersist
    public void createAt() {
        this.startDate = LocalDate.now();
    }

    public void update(CreateProjectRequestDto request) {
        this.name = request.getName();
        this.content = request.getContent();
        this.endDate = request.getEndDate();
        this.communicationTool = request.getCommunicationTool();
        this.skill = request.getSkill();
    }
}
