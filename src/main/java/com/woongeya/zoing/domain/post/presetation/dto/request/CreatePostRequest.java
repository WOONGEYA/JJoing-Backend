package com.woongeya.zoing.domain.post.presetation.dto.request;

import com.woongeya.zoing.domain.post.domain.Post;
import com.woongeya.zoing.domain.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreatePostRequest {

    @NotNull
    private String title;

    @NotNull
    private String content;

    private String imgUrl;

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
