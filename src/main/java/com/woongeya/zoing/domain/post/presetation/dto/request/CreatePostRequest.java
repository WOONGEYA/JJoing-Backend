package com.woongeya.zoing.domain.post.presetation.dto.request;

import com.woongeya.zoing.domain.post.domain.Post;
import com.woongeya.zoing.domain.user.domain.User;

import jakarta.validation.constraints.NotNull;

public record CreatePostRequest(
    @NotNull
    String title,
    @NotNull
    String content,
    String imgUrl
) {
    public Post toEntity(User user) {
        return Post.builder()
                .title(title)
                .content(content)
                .imgUrl(imgUrl)
                .viewCount(0)
                .writer(user.getId())
                .build();
    }
}
