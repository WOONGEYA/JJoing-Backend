package com.woongeya.zoing.domain.comment.presetation.dto.response;

import java.time.LocalDateTime;

import com.woongeya.zoing.domain.comment.domain.Comment;
import com.woongeya.zoing.domain.user.domain.User;

import lombok.Builder;

@Builder
public record CommentResponse (
    Long id,
    String content,
    LocalDateTime createTime,
    Long userId,
    String userNickName,
    String userImg,
    Integer reCommentCount
) {
    public static CommentResponse of(Comment comment, User user) {
        return CommentResponse.builder()
                .id(comment.getId())
                .content(comment.getContent())
                .createTime(comment.getCreateTime())
                .reCommentCount(comment.getReCommentCount())
                .userId(user.getId())
                .userNickName(user.getNickName())
                .userImg(user.getImgUrl())
                .build();
    }
}
