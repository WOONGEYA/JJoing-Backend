package com.woongeya.zoing.domain.user.presetation.dto.request;

public record UpdateUserRequestDto (
    String nickName,
    Integer age,
    String major,
    String githubUrl,
    String imageUrl,
    String statusMessage
) {
}
