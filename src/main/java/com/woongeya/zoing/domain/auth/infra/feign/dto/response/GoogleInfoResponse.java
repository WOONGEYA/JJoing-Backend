package com.woongeya.zoing.domain.auth.infra.feign.dto.response;

import static com.woongeya.zoing.domain.user.domain.autority.Authority.*;

import com.woongeya.zoing.domain.user.domain.User;

public record GoogleInfoResponse (
    String name,
    String email,
    String picture
) {

    public User toEntity() {
        return User.builder()
            .name(name)
            .nickName(name)
            .email(email)
            .imgUrl(picture)
            .authority(USER)
            .build();
    }
}
