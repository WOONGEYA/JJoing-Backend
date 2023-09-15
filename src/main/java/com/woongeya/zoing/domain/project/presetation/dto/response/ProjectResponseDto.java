package com.woongeya.zoing.domain.project.presetation.dto.response;

import com.woongeya.zoing.domain.project.domain.Project;
import com.woongeya.zoing.domain.project.domain.type.ProjectState;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class ProjectResponseDto {

    private Long id;
    private String name;
    private String content;
    private String imgUrl;
    private LocalDate endTime;
    private Integer requiredPeople;
    private Integer currentPeople;
    private Long viewCount;
    private ProjectState state;

    public static ProjectResponseDto of(Project project) {
        return ProjectResponseDto.builder()
                .id(project.getId())
                .name(project.getName())
                .content(project.getContent())
                .imgUrl(project.getImgUrl())
                .endTime(project.getEndDate())
                .state(project.getState())
                .viewCount(project.getViewCount())
                .requiredPeople(project.getRequiredPeople())
                .currentPeople(project.getCurrentPeople())
                .build();
    }
}
