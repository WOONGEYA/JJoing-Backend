package com.woongeya.zoing.domain.follow.presetation.dto.reponse;

import com.woongeya.zoing.domain.user.domain.User;
import lombok.Getter;

@Getter
public class FollowResponseDto {

    private Long id;
    private String name;

    public FollowResponseDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
    }
}
