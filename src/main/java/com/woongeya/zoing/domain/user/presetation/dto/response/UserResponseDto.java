package com.woongeya.zoing.domain.user.presetation.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
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

    @Builder
    public UserResponseDto(Long id, String name, String nickName, String email, String major, String imgUrl, String school, String githubUrl, String statusMessage) {
        this.id = id;
        this.name = name;
        this.nickName = nickName;
        this.email = email;
        this.major = major;
        this.imgUrl = imgUrl;
        this.school = school;
        this.githubUrl = githubUrl;
        this.statusMessage = statusMessage;
    }
}
