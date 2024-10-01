package com.woongeya.zoing.domain.project.presetation.dto.response;

public record ImageResponseDto (
    String imgUrl
){
    public static ImageResponseDto from(String imgUrl) {
        return new ImageResponseDto(imgUrl);
    }
}
