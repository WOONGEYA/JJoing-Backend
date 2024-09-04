package com.woongeya.zoing.domain.application.presetation.dto.response;

import com.woongeya.zoing.domain.application.domain.Application;
import com.woongeya.zoing.domain.user.domain.User;
import lombok.Getter;

@Getter
public class ApplicationResponseDto {

    private Long id;
    private String introduce;
    private Long userId;
    private String userName;
    private String userImg;
    private String phone;
    private String position;

    public ApplicationResponseDto(Application application, User user) {
        this.id = application.getId();
        this.introduce = application.getIntroduce();
        this.userName = user.getName();
        this.userImg = user.getImgUrl();
        this.userId = user.getId();
        this.phone = application.getPhone();
        this.position = application.getPosition();
    }
}
