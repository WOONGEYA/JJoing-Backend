package com.woongeya.zoing.domain.comment.presetation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateCommentRequest {

    @NotNull
    private String content;
}
