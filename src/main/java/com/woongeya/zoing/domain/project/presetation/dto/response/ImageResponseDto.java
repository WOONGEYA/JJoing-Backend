package com.woongeya.zoing.domain.project.presetation.dto.response;

import com.woongeya.zoing.domain.project.domain.Image;
import lombok.Getter;

@Getter
public class ImageResponseDto {

    private String imgUrl;

    public ImageResponseDto(Image image) {
        this.imgUrl = image.getImgUrl();
    }
}
