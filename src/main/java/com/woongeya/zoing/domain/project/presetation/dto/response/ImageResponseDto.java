package com.woongeya.zoing.domain.project.presetation.dto.response;

import lombok.Getter;

@Getter
public class ImageResponseDto {

    private String imgUrl;

    public ImageResponseDto(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
