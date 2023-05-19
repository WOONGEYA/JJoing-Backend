package com.woongeya.zoing.domain.user.presetation.dto.request;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
public class UpdateUserRequestDto {

    @NotBlank
    private String name;

    @NotBlank
    private String nickname;

    @NotBlank
    private String school;

    @NotNull
    private int age;

    @NotBlank
    private String major;
}
