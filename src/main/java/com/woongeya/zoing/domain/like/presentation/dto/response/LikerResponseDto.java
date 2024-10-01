package com.woongeya.zoing.domain.like.presentation.dto.response;

public record LikerResponseDto (
    Long id,
    String name
) {
    public static LikerResponseDto of(Long id, String name) {
        return new LikerResponseDto(id, name);
    }
}
