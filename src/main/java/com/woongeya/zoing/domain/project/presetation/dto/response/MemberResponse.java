package com.woongeya.zoing.domain.project.presetation.dto.response;

import com.woongeya.zoing.domain.user.domain.User;

public record MemberResponse(
    Long userId,
    String name,
    String imgUrl
){
    public static MemberResponse from(User user) {
        return new MemberResponse(user.getId(), user.getName(), user.getImgUrl());
    }
}
