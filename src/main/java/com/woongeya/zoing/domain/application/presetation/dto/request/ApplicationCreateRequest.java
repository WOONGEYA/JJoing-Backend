package com.woongeya.zoing.domain.application.presetation.dto.request;

import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class ApplicationCreateRequest {

    private String introduce;

    @NotNull
    private String position;
}
