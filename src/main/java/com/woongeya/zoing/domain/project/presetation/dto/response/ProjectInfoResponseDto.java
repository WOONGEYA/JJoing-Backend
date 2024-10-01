package com.woongeya.zoing.domain.project.presetation.dto.response;

import java.time.LocalDate;
import java.util.List;

import com.woongeya.zoing.domain.project.domain.Project;
import com.woongeya.zoing.domain.project.domain.type.ProjectState;

import lombok.Builder;

@Builder
public record ProjectInfoResponseDto (
    Long id,
    String name,
    String content,
    String imgUrl,
    LocalDate startDate,
    LocalDate endDate,
    Integer requiredPeople,
    Integer currentPeople,
    ProjectState state,
    List<String> moods,
    List<String> skills,
    List<String> coops,
    List<String> positions
) {
    public static ProjectInfoResponseDto of(Project project, List<String> moods, List<String> skills, List<String> coops, List<String> positions) {
        return ProjectInfoResponseDto.builder()
            .id(project.getId())
            .name(project.getName())
            .content(project.getContent())
            .imgUrl(project.getImgUrl())
            .startDate(project.getStartDate())
            .endDate(project.getEndDate())
            .requiredPeople(project.getRequiredPeople())
            .currentPeople(project.getCurrentPeople())
            .state(project.getState())
            .moods(moods)
            .skills(skills)
            .coops(coops)
            .positions(positions)
            .build();
    }
}
