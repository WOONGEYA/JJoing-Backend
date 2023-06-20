package com.woongeya.zoing.domain.application.presetation.dto.request;

import com.woongeya.zoing.domain.application.domain.type.ApplicationJobPosition;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
public class ApplicationCreateRequest {

    private String introduce;

    @NotNull
    private ApplicationJobPosition position;
}
