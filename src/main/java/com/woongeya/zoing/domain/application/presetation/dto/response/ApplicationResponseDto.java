package com.woongeya.zoing.domain.application.presetation.dto.response;

import lombok.Getter;

@Getter
public class ApplicationResponseDto {

    private Long id;
    private String introduce;
    private String userName;
    private String position;

    public ApplicationResponseDto(Long id, String introduce, String userName, String position) {
        this.id = id;
        this.introduce = introduce;
        this.userName = userName;
        this.position = position;
    }
}
