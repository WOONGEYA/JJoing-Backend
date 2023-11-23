package com.woongeya.zoing.domain.comment.presetation.dto.response;

import com.woongeya.zoing.domain.comment.domain.Comment;
import com.woongeya.zoing.domain.user.domain.User;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class CommentResponse {

    private Long id;
    private String content;
    private LocalDateTime createTime;
    private Long userId;
    private String userNickName;
    private String userImg;
    private Integer reCommentCount;

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
