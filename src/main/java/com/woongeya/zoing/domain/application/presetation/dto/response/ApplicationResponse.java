package com.woongeya.zoing.domain.application.presetation.dto.response;

import com.woongeya.zoing.domain.application.domain.Application;
import com.woongeya.zoing.domain.user.domain.User;

import lombok.Builder;

@Builder
public record ApplicationResponse (
    Long id,
    String introduce,
    Long userId,
    String userName,
    String userImg,
    String phone,
    String position
) {
    public static ApplicationResponse of(Application application, User user) {
        return ApplicationResponse.builder()
            .id(application.getId())
            .introduce(application.getIntroduce())
            .userId(user.getId())
            .userName(user.getName())
            .userImg(user.getImgUrl())
            .phone(application.getPhone())
            .position(application.getPosition())
            .build();
    }
}
