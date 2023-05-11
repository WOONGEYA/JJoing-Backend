package com.woongeya.zoing.domain.auth.presetation;

import com.woongeya.zoing.domain.auth.service.OAuth2GoogleService;
import com.woongeya.zoing.global.jwt.dto.TokenResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login/oauth2")
@RequiredArgsConstructor
public class AuthController {

    private final OAuth2GoogleService googleService;

    @GetMapping("/code/google")
    public TokenResponseDto loginOfGoogle(@Validated @RequestParam(name = "code") String code) {
        return googleService.getJwtToken(code);
    }
}
