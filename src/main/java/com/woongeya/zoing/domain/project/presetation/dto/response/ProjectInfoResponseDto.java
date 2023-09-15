package com.woongeya.zoing.domain.project.presetation.dto.response;

import lombok.Getter;

import java.util.List;

@Getter
public class ProjectInfoResponseDto {

    private Long Id;
    private String name;
    private String content;
    private List<String> moods;
    private List<String> skills;
    private List<String> coops;

    public ProjectInfoResponseDto(String name, String content, List<String> moods, List<String> skills, List<String> coops) {
        this.name = name;
        this.content = content;
        this.moods = moods;
        this.skills = skills;
        this.coops = coops;
    }
}
