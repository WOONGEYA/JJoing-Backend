package com.woongeya.zoing.domain.user.presetation.dto.response;

import com.woongeya.zoing.domain.user.domain.User;

import lombok.Builder;

@Builder
public record UserResponse(
    Long id,
    String name,
    String nickName,
    String email,
    String major,
    String imgUrl,
    String githubUrl,
    String statusMessage
) {
    public static UserResponse from(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .nickName(user.getNickName())
                .email(user.getEmail())
                .major(user.getMajor())
                .imgUrl(user.getImgUrl())
                .githubUrl(user.getGithubUrl())
                .statusMessage(user.getStatusMessage())
                .build();
    }
}
