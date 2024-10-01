package com.woongeya.zoing.domain.project.presetation.dto.response;

import com.woongeya.zoing.domain.user.domain.User;

public record MemberResponseDto (
    Long userId,
    String name,
    String imgUrl
){
    public static MemberResponseDto from(User user) {
        return new MemberResponseDto(user.getId(), user.getName(), user.getImgUrl());
    }
}
