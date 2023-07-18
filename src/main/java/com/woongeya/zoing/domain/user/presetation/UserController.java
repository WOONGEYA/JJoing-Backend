package com.woongeya.zoing.domain.user.presetation;

import com.woongeya.zoing.domain.project.presetation.dto.response.ImageResponseDto;
import com.woongeya.zoing.domain.user.presetation.dto.request.UpdateUserRequestDto;
import com.woongeya.zoing.domain.user.presetation.dto.response.UserResponseDto;
import com.woongeya.zoing.domain.user.service.FindCurrentUserService;
import com.woongeya.zoing.domain.user.service.UploadProfileImageService;
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
    private final UploadProfileImageService uploadProfileImageService;

    @PutMapping
    public void updateUser(@RequestBody UpdateUserRequestDto request) {
        userUpdateService.execute(request);
    }

    @PostMapping("/image")
    public ImageResponseDto uploadImage(@RequestPart(value = "image") MultipartFile file) {
        return uploadProfileImageService.execute(file);
    }

    @GetMapping
    public UserResponseDto getUserInfo() {
        return findCurrentUserService.execute();
    }
}
