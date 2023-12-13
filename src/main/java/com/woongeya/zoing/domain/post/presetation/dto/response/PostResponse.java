package com.woongeya.zoing.domain.post.presetation.dto.response;

import com.woongeya.zoing.domain.post.domain.Post;
import com.woongeya.zoing.domain.user.domain.User;
import com.woongeya.zoing.domain.user.presetation.dto.response.UserResponseDto;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class PostResponse {

    private Long id;
    private String title;
    private String content;
    private Integer viewCount;
    private Integer commentCount;
    private String postImg;
    private LocalDateTime createTime;
    private Long userId;
    private String userNickName;
    private String userImg;

    public static PostResponse of(Post post, User user) {
        return PostResponse.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .postImg(post.getImgUrl())
                .createTime(post.getCreateTime())
                .viewCount(post.getViewCount())
                .userId(user.getId())
                .userNickName(user.getNickName())
                .userImg(user.getImgUrl())
                .commentCount(post.getCommentCount())
                .build();
    }
}
