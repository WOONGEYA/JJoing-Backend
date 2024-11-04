package com.woongeya.zoing.domain.like.presentation.dto.response;

public record LikerResponse(
    Long id,
    String name
) {
    public static LikerResponse of(Long id, String name) {
        return new LikerResponse(id, name);
    }
}
