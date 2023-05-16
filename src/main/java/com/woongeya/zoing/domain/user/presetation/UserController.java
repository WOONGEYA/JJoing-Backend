package com.woongeya.zoing.domain.user.presetation;

import com.woongeya.zoing.domain.user.presetation.dto.request.TokenRequestDto;
import com.woongeya.zoing.domain.user.service.UserLogoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserLogoutService userLogoutService;

    @DeleteMapping("/logout")
    public String userLogout(@RequestBody TokenRequestDto request) {
        System.out.println(request.getRefreshToken());
        return userLogoutService.execute(request.getRefreshToken());
    }
}
