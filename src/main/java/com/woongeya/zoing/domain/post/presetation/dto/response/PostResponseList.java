package com.woongeya.zoing.domain.post.presetation.dto.response;

import java.util.List;

public record PostResponseList(
    List<PostResponse> postResponses
) {
    public static PostResponseList of(List<PostResponse> postResponses) {
        return new PostResponseList(postResponses);
    }
}
