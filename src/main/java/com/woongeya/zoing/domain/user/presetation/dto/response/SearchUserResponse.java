package com.woongeya.zoing.domain.user.presetation.dto.response;

import com.woongeya.zoing.domain.user.domain.User;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SearchUserResponse {
    private Long id;
    private String name;
    private String nickName;
    private String imgUrl;
    private String school;
    private String major;
    private Integer followCount;
    private Integer followerCount;
    private Boolean followState;

    public static SearchUserResponse of(User user, Integer followCount, Integer followerCount, Boolean state) {
        return SearchUserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .nickName(user.getNickName())
                .imgUrl(user.getImgUrl())
                .school(user.getSchool())
                .major(user.getMajor())
                .followCount(followCount)
                .followerCount(followerCount)
                .followState(state)
                .build();
    }
}
