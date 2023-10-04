package com.woongeya.zoing.domain.project.presetation.dto.response;

import com.woongeya.zoing.domain.like.domain.Like;
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
    private Integer likeCount;
    private Long viewCount;
    private ProjectState projectState;
    private Boolean likeState;

    public static ProjectResponseDto of(Project project, Integer likeCount, Boolean likeState) {
        return ProjectResponseDto.builder()
                .id(project.getId())
                .name(project.getName())
                .content(project.getContent())
                .imgUrl(project.getImgUrl())
                .endTime(project.getEndDate())
                .likeCount(likeCount)
                .projectState(project.getState())
                .viewCount(project.getViewCount())
                .requiredPeople(project.getRequiredPeople())
                .currentPeople(project.getCurrentPeople())
                .likeState(likeState)
                .build();
    }
}
