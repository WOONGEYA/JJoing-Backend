package com.woongeya.zoing.global.feign.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GoogleInfoResponseDto {

    private String name;
    private String email;
    private String picture;
}
