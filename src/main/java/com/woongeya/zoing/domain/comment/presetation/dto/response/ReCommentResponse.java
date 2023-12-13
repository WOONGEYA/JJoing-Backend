package com.woongeya.zoing.domain.comment.presetation.dto.response;

import com.woongeya.zoing.domain.comment.domain.ReComment;
import com.woongeya.zoing.domain.user.domain.User;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class ReCommentResponse {

    private Long id;
    private String content;
    private LocalDateTime createTime;
    private Long userId;
    private String userNickName;
    private String userImg;

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
