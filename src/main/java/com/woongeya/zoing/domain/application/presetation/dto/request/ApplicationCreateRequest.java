package com.woongeya.zoing.domain.application.presetation.dto.request;

import com.woongeya.zoing.domain.application.domain.type.ApplicationJobPosition;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class ApplicationCreateRequest {

    private String introduce;

    @NotBlank
    private ApplicationJobPosition position;
}
