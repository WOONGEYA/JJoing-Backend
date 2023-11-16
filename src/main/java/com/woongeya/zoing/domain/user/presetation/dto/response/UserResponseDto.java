package com.woongeya.zoing.domain.user.presetation.dto.response;

import com.woongeya.zoing.domain.user.domain.User;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserResponseDto {

    private Long id;
    private String name;
    private String nickName;
    private String email;
    private String major;
    private String imgUrl;
    private String school;
    private String githubUrl;
    private String statusMessage;

    public static UserResponseDto from(User user) {
        return UserResponseDto.builder()
                .id(user.getId())
                .name(user.getName())
                .nickName(user.getNickName())
                .email(user.getEmail())
                .major(user.getMajor())
                .imgUrl(user.getImgUrl())
                .school(user.getSchool())
                .githubUrl(user.getGithubUrl())
                .statusMessage(user.getStatusMessage())
                .build();
    }
}
