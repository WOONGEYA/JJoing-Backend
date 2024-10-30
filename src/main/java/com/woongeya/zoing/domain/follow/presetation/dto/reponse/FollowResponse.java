package com.woongeya.zoing.domain.follow.presetation.dto.reponse;

import com.woongeya.zoing.domain.user.domain.User;

import lombok.Builder;

@Builder
public record FollowResponse(
    Long id,
    String name,
    String imgUrl,
    String major,
    Boolean followState
) {

    public static FollowResponse of(User user, Boolean followState) {
        return FollowResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .imgUrl(user.getImgUrl())
                .major(user.getMajor())
                .followState(followState)
                .build();
    }
}
