package com.woongeya.zoing.domain.user.presetation;

import com.woongeya.zoing.domain.user.presetation.dto.request.UpdateUserRequestDto;
import com.woongeya.zoing.domain.user.presetation.dto.response.UserResponseDto;
import com.woongeya.zoing.domain.user.service.FindCurrentUserService;
import com.woongeya.zoing.domain.user.service.UserUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserUpdateService userUpdateService;
    private final FindCurrentUserService findCurrentUserService;

    @PutMapping
    public void updateUser(@RequestPart("image") MultipartFile image,
                           @RequestPart("data") UpdateUserRequestDto request) {
        userUpdateService.execute(image ,request);
    }

    @GetMapping
    public UserResponseDto getUserInfo() {
        return findCurrentUserService.execute();
    }
}
