package com.woongeya.zoing.domain.post.presetation.dto.request;

import com.woongeya.zoing.domain.post.domain.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreatePostRequest {

    @NotNull
    private String title;

    @NotNull
    private String content;

    private String imgUrl;

    public Post toEntity() {
        return Post.builder()
                .title(title)
                .content(content)
                .imgUrl(imgUrl)
                .build();
    }
}
