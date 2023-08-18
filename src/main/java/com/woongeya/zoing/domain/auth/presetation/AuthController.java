package com.woongeya.zoing.domain.auth.presetation;

import com.woongeya.zoing.domain.auth.service.OAuth2GoogleService;
import com.woongeya.zoing.domain.auth.service.RefreshTokenService;
import com.woongeya.zoing.global.jwt.dto.TokenResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class AuthController {

    private final OAuth2GoogleService googleService;
    private final RefreshTokenService refreshTokenService;

    @PostMapping("/google")
    @Operation(summary = "구글 로그인")
    public TokenResponseDto loginOfGoogle(@Validated @RequestParam(name = "code") String code) {
        return googleService.execute(code);
    }

    @PutMapping()
    @Operation(summary = "토큰 재발급")
    public TokenResponseDto refreshToken(@RequestHeader(value = "Refresh-Token") @NotBlank String refreshToken) {
        return refreshTokenService.execute(refreshToken);
    }
}
