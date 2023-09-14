package com.woongeya.zoing.domain.project.presetation.dto.response;

import com.woongeya.zoing.domain.project.domain.Project;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class ProjectInfoResponseDto {

    private Long Id;
    private String name;
    private String content;
    private List<String> memberName;
    private List<String> memberImg;
    private List<String> moods;
    private List<String> skills;
    private List<String> coops;
}
