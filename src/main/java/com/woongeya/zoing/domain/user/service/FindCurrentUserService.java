package com.woongeya.zoing.domain.user.service;

import com.woongeya.zoing.domain.user.UserFacade;
import com.woongeya.zoing.domain.user.domain.User;
import com.woongeya.zoing.domain.user.presetation.dto.response.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindCurrentUserService {

    private final UserFacade userFacade;

    public UserResponseDto execute() {
        User user = userFacade.getCurrentUser();

        return UserResponseDto.builder()
                .id(user.getId())
                .name(user.getName())
                .nickName(user.getNickName())
                .imgUrl(user.getImgUrl())
                .email(user.getEmail())
                .major(user.getMajor())
                .school(user.getSchool())
                .githubUrl(user.getGithubUrl())
                .statusMessage(user.getStatusMessage())
                .build();
    }
}
