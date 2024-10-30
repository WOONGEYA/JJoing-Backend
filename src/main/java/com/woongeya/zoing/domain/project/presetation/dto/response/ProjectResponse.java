package com.woongeya.zoing.domain.project.presetation.dto.response;

import java.time.LocalDate;

import com.woongeya.zoing.domain.project.domain.Project;
import com.woongeya.zoing.domain.project.domain.type.ProjectState;

import lombok.Builder;

@Builder
public record ProjectResponse(
    Long id,
    String name,
    String content,
    String imgUrl,
    LocalDate endTime,
    Integer requiredPeople,
    Integer currentPeople,
    Integer likeCount,
    Long viewCount,
    ProjectState projectState,
    Boolean likeState
) {
    public static ProjectResponse of(Project project, Integer likeCount, Boolean likeState) {
        return ProjectResponse.builder()
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
