package com.woongeya.zoing.domain.auth.presetation;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.woongeya.zoing.domain.auth.presetation.dto.request.RefreshTokenRequest;
import com.woongeya.zoing.domain.auth.presetation.dto.response.TokenResponse;
import com.woongeya.zoing.domain.auth.service.CommandAuthService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class AuthController {

    private final CommandAuthService commandAuthService;

    @PostMapping("/google")
    @Operation(summary = "구글 로그인")
    public TokenResponse loginOfGoogle(@Validated @RequestParam(name = "code") String code) {
        return TokenResponse.from(commandAuthService.login(code));
    }

    @PutMapping()
    @Operation(summary = "토큰 재발급")
    public TokenResponse refreshToken(@RequestBody RefreshTokenRequest refreshToken) {
        return TokenResponse.from(commandAuthService.refresh(refreshToken.refreshToken()));
    }
}
