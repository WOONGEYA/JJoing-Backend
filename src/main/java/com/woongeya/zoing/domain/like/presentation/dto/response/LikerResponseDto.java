package com.woongeya.zoing.domain.like.presentation.dto.response;

import lombok.Getter;

@Getter
public class LikerResponseDto {

    private String name;

    public LikerResponseDto(String name) {
        this.name = name;
    }
}
