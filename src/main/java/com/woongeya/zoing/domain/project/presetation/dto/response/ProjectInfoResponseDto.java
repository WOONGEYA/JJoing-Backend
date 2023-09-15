package com.woongeya.zoing.domain.project.presetation.dto.response;

import com.woongeya.zoing.domain.project.domain.Project;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
public class ProjectInfoResponseDto {

    private Long id;
    private String name;
    private String content;
    private String imgUrl;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer requiredPeople;
    private Integer currentPeople;
    private List<String> moods;
    private List<String> skills;
    private List<String> coops;
    private List<String> positions;

    public ProjectInfoResponseDto(Project project, List<String> moods, List<String> skills, List<String> coops, List<String> positions) {
        this.id = project.getId();
        this.name = project.getName();
        this.content = project.getContent();
        this.imgUrl = project.getImgUrl();
        this.startDate = project.getStartDate();
        this.endDate = project.getEndDate();
        this.requiredPeople = project.getRequiredPeople();
        this.currentPeople = project.getCurrentPeople();
        this.moods = moods;
        this.skills = skills;
        this.coops = coops;
        this.positions = positions;
    }
}
