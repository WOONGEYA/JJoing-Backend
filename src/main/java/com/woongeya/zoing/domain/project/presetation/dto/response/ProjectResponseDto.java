package com.woongeya.zoing.domain.project.presetation.dto.response;

import com.woongeya.zoing.domain.project.domain.Project;
import com.woongeya.zoing.domain.project.domain.type.ProjectState;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProjectResponseDto {

    private String name;
    private String content;
    private Long viewCount;
    private ProjectState state;

    public static ProjectResponseDto of(Project project) {
        return ProjectResponseDto.builder()
                .name(project.getName())
                .content(project.getContent())
                .state(project.getState())
                .viewCount(project.getViewCount())
                .build();
    }
}
