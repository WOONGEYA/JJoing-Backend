package com.woongeya.zoing.domain.post.presetation.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class PostResponseList {

    private List<PostResponse> postResponses;

    public static PostResponseList of(List<PostResponse> postResponses) {
        return PostResponseList.builder()
                .postResponses(postResponses)
                .build();
    }
}
