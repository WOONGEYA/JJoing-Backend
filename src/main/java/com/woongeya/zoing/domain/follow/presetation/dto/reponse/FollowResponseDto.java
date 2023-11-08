package com.woongeya.zoing.domain.follow.presetation.dto.reponse;

import com.woongeya.zoing.domain.user.domain.User;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FollowResponseDto {

    private Long id;
    private String name;
    private String imgUrl;
    private String school;
    private String major;

    public static FollowResponseDto of(User user) {
        return FollowResponseDto.builder()
                .id(user.getId())
                .name(user.getName())
                .imgUrl(user.getImgUrl())
                .school(user.getSchool())
                .major(user.getMajor())
                .build();
    }
}
