package com.woongeya.zoing.global.feign.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GoogleTokenResponseDto {

    @JsonProperty("access_token")
    private String accessToken;
}
