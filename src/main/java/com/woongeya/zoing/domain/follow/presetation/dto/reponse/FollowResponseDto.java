package com.woongeya.zoing.domain.follow.presetation.dto.reponse;

import lombok.Getter;

@Getter
public class FollowResponseDto {

    private Long id;
    private String name;

    public FollowResponseDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
