package com.woongeya.zoing.domain.user.presetation;

import com.woongeya.zoing.domain.project.presetation.dto.response.ImageResponseDto;
import com.woongeya.zoing.domain.user.presetation.dto.request.UpdateUserRequestDto;
import com.woongeya.zoing.domain.user.presetation.dto.response.UserResponseDto;
import com.woongeya.zoing.domain.user.service.FindCurrentUserService;
import com.woongeya.zoing.domain.user.service.FindOtherUserService;
import com.woongeya.zoing.domain.user.service.UploadProfileImageService;
import com.woongeya.zoing.domain.user.service.UserUpdateService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserUpdateService userUpdateService;
    private final FindCurrentUserService findCurrentUserService;
    private final FindOtherUserService findOtherUserService;
    private final UploadProfileImageService uploadProfileImageService;

    @PutMapping
    @Operation(summary = "유저 정보 업데이트")
    public void updateUser(@RequestBody UpdateUserRequestDto request) {
        userUpdateService.execute(request);
    }

    @PostMapping("/image")
    @Operation(summary = "유저 프로필 사진 등록")
    public ImageResponseDto uploadImage(@RequestPart(value = "image") MultipartFile file) {
        return uploadProfileImageService.execute(file);
    }

    @GetMapping
    @Operation(summary = "현재 로그인된 유저 정보 조회")
    public UserResponseDto getUserInfo() {
        return findCurrentUserService.execute();
    }

    @GetMapping
    @Operation(summary = "다른 유저 정보 조회")
    public UserResponseDto getOtherUserInfo(@PathVariable Long id) { return findOtherUserService.execute(id); }
}
