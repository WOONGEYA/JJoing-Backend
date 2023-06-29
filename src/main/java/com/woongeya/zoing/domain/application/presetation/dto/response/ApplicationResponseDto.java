package com.woongeya.zoing.domain.application.presetation.dto.response;

import com.woongeya.zoing.domain.application.domain.type.ApplicationJobPosition;
import lombok.Getter;

@Getter
public class ApplicationResponseDto {

    private String introduce;
    private String userName;
    private ApplicationJobPosition position;

    public ApplicationResponseDto(String introduce, String userName, ApplicationJobPosition position) {
        this.introduce = introduce;
        this.userName = userName;
        this.position = position;
    }
}
