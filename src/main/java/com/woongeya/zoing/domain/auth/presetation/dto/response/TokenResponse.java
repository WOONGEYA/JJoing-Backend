package com.woongeya.zoing.domain.auth.presetation.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TokenResponse {

    private String token;
    private String validate;
}
