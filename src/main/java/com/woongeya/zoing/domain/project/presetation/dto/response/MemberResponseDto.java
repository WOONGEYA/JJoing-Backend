package com.woongeya.zoing.domain.project.presetation.dto.response;

import com.woongeya.zoing.domain.project.domain.Member;
import com.woongeya.zoing.domain.user.domain.User;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberResponseDto {

    private Long userId;
    private String name;
    private String imgUrl;

    public static MemberResponseDto of(User user) {
        return MemberResponseDto.builder()
                .userId(user.getId())
                .name(user.getName())
                .imgUrl(user.getImgUrl())
                .build();
    }
}
