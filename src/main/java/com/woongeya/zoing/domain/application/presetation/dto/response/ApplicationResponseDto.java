package com.woongeya.zoing.domain.application.presetation.dto.response;

import com.woongeya.zoing.domain.application.domain.type.ApplicationJobPosition;
import lombok.Getter;

@Getter
public class ApplicationResponseDto {

    private Long id;
    private String introduce;
    private String userName;
    private ApplicationJobPosition position;

    public ApplicationResponseDto(Long id, String introduce, String userName, ApplicationJobPosition position) {
        this.id = id;
        this.introduce = introduce;
        this.userName = userName;
        this.position = position;
    }
}
