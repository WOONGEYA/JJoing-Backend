package com.woongeya.zoing.domain.project.domain;


import com.woongeya.zoing.domain.project.domain.type.ProjectState;
import com.woongeya.zoing.domain.project.presetation.dto.request.CreateProjectRequestDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.*;
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

    private String imgUrl;

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

    @Builder
    public Project(String name, String content, String imgUrl, Long viewCount, ProjectState state, Integer requiredPeople, Integer currentPeople, LocalDate startDate, LocalDate endDate) {
        this.name = name;
        this.content = content;
        this.imgUrl = imgUrl;
        this.viewCount = viewCount;
        this.state = state;
        this.requiredPeople = requiredPeople;
        this.currentPeople = currentPeople;
        this.startDate = startDate;
        this.endDate = endDate;
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
        this.imgUrl = request.getImgUrl();
        this.requiredPeople = request.getRequiredPeople();
        this.content = request.getContent();
        this.endDate = request.getEndDate();
    }

    public void isFull() {
        if (Objects.equals(this.currentPeople, this.requiredPeople)) {
            this.state = ProjectState.FOUND;
        }
    }
}
