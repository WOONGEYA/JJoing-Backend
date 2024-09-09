package com.woongeya.zoing.domain.user.presetation.dto.response;

import com.woongeya.zoing.domain.user.domain.User;

import lombok.Builder;

@Builder
public record SearchUserResponse (
    Long id,
    String name,
    String nickName,
    String imgUrl,
    String major,
    Integer followCount,
    Integer followerCount,
    Boolean followState
) {

    public static SearchUserResponse of(User user, Integer followCount, Integer followerCount, Boolean state) {
        return SearchUserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .nickName(user.getNickName())
                .imgUrl(user.getImgUrl())
                .major(user.getMajor())
                .followCount(followCount)
                .followerCount(followerCount)
                .followState(state)
                .build();
    }
}
