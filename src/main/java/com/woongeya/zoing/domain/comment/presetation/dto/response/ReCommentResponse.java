package com.woongeya.zoing.domain.comment.presetation.dto.response;

import com.woongeya.zoing.domain.comment.domain.ReComment;
import com.woongeya.zoing.domain.user.domain.User;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
public record ReCommentResponse (
    Long id,
    String content,
    LocalDateTime createTime,
    Long userId,
    String userNickName,
    String userImg
) {
    public static ReCommentResponse of(ReComment reComment, User user) {
        return ReCommentResponse.builder()
                .id(reComment.getId())
                .content(reComment.getContent())
                .createTime(reComment.getCreateTime())
                .userId(user.getId())
                .userNickName(user.getNickName())
                .userImg(user.getImgUrl())
                .build();
    }
}
