package com.woongeya.zoing.domain.post.presetation.dto.response;

import java.time.LocalDateTime;

import com.woongeya.zoing.domain.post.domain.Post;
import com.woongeya.zoing.domain.user.domain.User;

import lombok.Builder;

@Builder
public record PostResponse(
    Long id,
    String title,
    String content,
    Integer viewCount,
    Integer commentCount,
    String postImg,
    LocalDateTime createTime,
    Long userId,
    String userNickName,
    String userImg
) {
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
