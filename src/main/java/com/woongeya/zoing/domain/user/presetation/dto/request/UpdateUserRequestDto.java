package com.woongeya.zoing.domain.user.presetation.dto.request;

import lombok.Getter;
import org.hibernate.validator.constraints.URL;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
public class UpdateUserRequestDto {

    @NotBlank
    private String nickName;

    @NotNull
    private int age;

    @NotBlank
    private String major;

    @NotBlank
    private String githubUrl;

    private String imageUrl;

    private String statusMessage;
}
