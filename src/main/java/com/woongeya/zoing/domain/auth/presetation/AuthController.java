package com.woongeya.zoing.domain.auth.presetation;

import com.woongeya.zoing.domain.auth.service.OAuth2GoogleLinkService;
import com.woongeya.zoing.domain.auth.service.OAuth2GoogleService;
import com.woongeya.zoing.domain.auth.service.RefreshTokenService;
import com.woongeya.zoing.global.jwt.dto.TokenResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class AuthController {

    private final OAuth2GoogleService googleService;
    private final OAuth2GoogleLinkService oAuth2GoogleLinkService;
    private final RefreshTokenService refreshTokenService;

    @GetMapping("/google")
    public String getGoogleAuthLink() {
        return oAuth2GoogleLinkService.execute();
    }

    @PostMapping("/google")
    public TokenResponseDto loginOfGoogle(@Validated @RequestParam(name = "code") String code) {
        return googleService.execute(code);
    }

    @PutMapping("")
    public TokenResponseDto refreshToken(@RequestHeader(value = "Refresh-Token") @NotBlank String refreshToken) {
        return refreshTokenService.execute(refreshToken);
    }
}
