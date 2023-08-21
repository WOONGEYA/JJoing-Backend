package com.woongeya.zoing.domain.like.presentation.dto.response;

import lombok.Getter;

@Getter
public class LikerResponseDto {

    private Long id;
    private String name;

    public LikerResponseDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
