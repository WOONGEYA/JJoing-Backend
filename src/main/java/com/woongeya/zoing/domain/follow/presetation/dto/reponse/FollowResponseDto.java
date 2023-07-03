package com.woongeya.zoing.domain.follow.presetation.dto.reponse;

import lombok.Getter;

@Getter
public class FollowResponseDto {

    private String name;

    public FollowResponseDto(String name) {
        this.name = name;
    }
}
