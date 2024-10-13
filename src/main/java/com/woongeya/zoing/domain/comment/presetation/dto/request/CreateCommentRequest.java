package com.woongeya.zoing.domain.comment.presetation.dto.request;

import com.woongeya.zoing.domain.comment.domain.Comment;
import com.woongeya.zoing.domain.user.domain.User;

import jakarta.validation.constraints.NotNull;

public record CreateCommentRequest (
    @NotNull
    String content
) {

    public Comment toEntity(Long postId, User user) {
        return new Comment(content, postId, user.getId());
    }
}
