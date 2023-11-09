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
    private Boolean followState;

    public static FollowResponseDto of(User user, Boolean followState) {
        return FollowResponseDto.builder()
                .id(user.getId())
                .name(user.getName())
                .imgUrl(user.getImgUrl())
                .school(user.getSchool())
                .major(user.getMajor())
                .followState(followState)
                .build();
    }
}
