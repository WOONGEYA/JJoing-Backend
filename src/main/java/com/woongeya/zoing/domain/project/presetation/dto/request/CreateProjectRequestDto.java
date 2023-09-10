package com.woongeya.zoing.domain.project.presetation.dto.request;

import com.woongeya.zoing.domain.project.domain.Position;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
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

    private List<String> positionName;

    private List<String> imgUrls;
}
