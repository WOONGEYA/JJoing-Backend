package com.woongeya.zoing.domain.user.presetation.dto.request;

import lombok.Getter;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Getter
public class UpdateUserRequestDto {

    @NotBlank
    private String nickName;

    @NotNull
    private int age;

    @NotBlank
    private String major;

    @NotBlank
    private String githubUrl;

    private String imageUrl;

    private String statusMessage;
}
