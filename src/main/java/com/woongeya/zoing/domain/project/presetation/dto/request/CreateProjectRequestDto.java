package com.woongeya.zoing.domain.project.presetation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateProjectRequestDto {

    @NotNull
    private String name;

    @NotNull
    private String content;

    private String moodType;

    private String skill;

    private String communicationTool;

    private LocalDate endDate;

    private List<String> positionName;

    private List<String> imgUrls;
}
