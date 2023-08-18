package com.woongeya.zoing.domain.user.presetation.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class UserResponseDto {

    private String name;
    private String email;
    private String imgUrl;
    private String school;
    private String githubUrl;
    private String statusMessage;

    @Builder
    public UserResponseDto(String name, String email, String imgUrl, String school, String githubUrl, String statusMessage) {
        this.name = name;
        this.email = email;
        this.imgUrl = imgUrl;
        this.school = school;
        this.githubUrl = githubUrl;
        this.statusMessage = statusMessage;
    }
}
