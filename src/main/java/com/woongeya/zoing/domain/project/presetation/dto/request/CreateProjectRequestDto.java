package com.woongeya.zoing.domain.project.presetation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateProjectRequestDto {

    @NotNull
    private String name;

    @NotNull
    private String content;
}
