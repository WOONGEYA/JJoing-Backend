package com.woongeya.zoing.domain.project.presetation.dto.response;

public record ImageResponse(
    String imgUrl
){
    public static ImageResponse from(String imgUrl) {
        return new ImageResponse(imgUrl);
    }
}
