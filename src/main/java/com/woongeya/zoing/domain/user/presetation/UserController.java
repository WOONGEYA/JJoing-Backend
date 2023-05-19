package com.woongeya.zoing.domain.user.presetation;

import com.woongeya.zoing.domain.user.presetation.dto.request.TokenRequestDto;
import com.woongeya.zoing.domain.user.presetation.dto.request.UpdateUserRequestDto;
import com.woongeya.zoing.domain.user.service.UserLogoutService;
import com.woongeya.zoing.domain.user.service.UserUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserLogoutService userLogoutService;
    private final UserUpdateService userUpdateService;

    @DeleteMapping("/logout")
    public String userLogout(@RequestBody TokenRequestDto request) {
        return userLogoutService.execute(request.getRefreshToken());
    }

    @PutMapping
    public void updateUser(@RequestBody UpdateUserRequestDto request) {
        userUpdateService.execute(request);
    }
}
