package com.woongeya.zoing.domain.project.presetation.dto.response;

import com.woongeya.zoing.domain.project.domain.Project;
import com.woongeya.zoing.domain.project.domain.type.ProjectState;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProjectResponseDto {

    private Long id;
    private String name;
    private String content;
    private Long viewCount;
    private ProjectState state;
    private String moodType;
    private String communicationTool;
    private String skill;

    public static ProjectResponseDto of(Project project) {
        return ProjectResponseDto.builder()
                .id(project.getId())
                .name(project.getName())
                .content(project.getContent())
                .state(project.getState())
                .viewCount(project.getViewCount())
                .moodType(project.getMoodType())
                .communicationTool(project.getCommunicationTool())
                .skill(project.getSkill())
                .build();
    }
}
