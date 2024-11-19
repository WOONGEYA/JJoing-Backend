package com.woongeya.zoing.domain.user.presetation;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.woongeya.zoing.domain.project.presetation.dto.response.ImageResponse;
import com.woongeya.zoing.domain.user.presetation.dto.request.UpdateUserRequest;
import com.woongeya.zoing.domain.user.presetation.dto.response.SearchUserResponse;
import com.woongeya.zoing.domain.user.presetation.dto.response.UserResponse;
import com.woongeya.zoing.domain.user.service.FindCurrentUserService;
import com.woongeya.zoing.domain.user.service.FindOtherUserService;
import com.woongeya.zoing.domain.user.service.SearchUserService;
import com.woongeya.zoing.domain.user.service.UploadProfileImageService;
import com.woongeya.zoing.domain.user.service.UserUpdateService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserUpdateService userUpdateService;
    private final FindCurrentUserService findCurrentUserService;
    private final FindOtherUserService findOtherUserService;
    private final UploadProfileImageService uploadProfileImageService;
    private final SearchUserService searchUserService;

    @PutMapping
    @Operation(summary = "유저 정보 업데이트")
    public void updateUser(@RequestBody UpdateUserRequest request) {
        userUpdateService.execute(request);
    }

    @PostMapping("/image")
    @Operation(summary = "유저 프로필 사진 등록")
    public ImageResponse uploadImage(@RequestPart(value = "image") MultipartFile file) {
        return uploadProfileImageService.execute(file);
    }

    @GetMapping
    @Operation(summary = "현재 로그인된 유저 정보 조회")
    public UserResponse getUserInfo() {
        return findCurrentUserService.execute();
    }

    @GetMapping("/{id}")
    @Operation(summary = "다른 유저 정보 조회")
    public UserResponse getOtherUserInfo(@PathVariable Long id) {
        return findOtherUserService.execute(id);
    }

    @GetMapping("/search")
    @Operation(summary = "유저 검색")
    public List<SearchUserResponse> search(@RequestParam(name = "q") String q) {
        return searchUserService.execute(q);
    }
}
