package com.woongeya.zoing.domain.auth.service;

import com.woongeya.zoing.domain.user.domain.User;
import com.woongeya.zoing.domain.user.domain.autority.Authority;
import com.woongeya.zoing.domain.user.domain.repository.UserRepository;
import com.woongeya.zoing.domain.user.exception.NotMeisterMemberException;
import com.woongeya.zoing.global.feign.GoogleAuthClient;
import com.woongeya.zoing.global.feign.GoogleInfoClient;
import com.woongeya.zoing.global.feign.dto.request.GoogleTokenRequestDto;
import com.woongeya.zoing.global.feign.dto.response.GoogleInfoResponseDto;
import com.woongeya.zoing.global.jwt.dto.TokenResponseDto;
import com.woongeya.zoing.global.jwt.util.JwtProvider;
import com.woongeya.zoing.global.config.propertise.AuthProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class OAuth2GoogleService {

    private final AuthProperties authProperties;
    private final GoogleAuthClient googleAuthClient;
    private final GoogleInfoClient googleInfoClient;
    private final JwtProvider jwtProvider;
    private final UserRepository userRepository;

    public TokenResponseDto execute(String code) {
        String googleToken = googleAuthClient.getGoogleToken(
                createRequest(code)
        ).getAccessToken();
        GoogleInfoResponseDto userInfo = googleInfoClient.getUserInfo(googleToken);
        User user = saveOrUpdate(userInfo);

        return jwtProvider.generateToken(user.getEmail(), user.getAuthority().toString());
    }

    public GoogleTokenRequestDto createRequest(String code) {
        return GoogleTokenRequestDto.builder()
                .code(code)
                .clientId(authProperties.getClientId())
                .clientSecret(authProperties.getClientSecret())
                .redirectUri(authProperties.getRedirectUri())
                .build();
    }

    private User saveOrUpdate(GoogleInfoResponseDto response) {
        Optional<User> user = userRepository.findByEmail(response.getEmail());

        if (user.isEmpty()) {
            return userRepository.save(User.builder()
                    .email(response.getEmail())
                    .name(response.getName())
                    .nickName(response.getName())
                    .authority(Authority.USER)
                    .imgUrl(response.getPicture())
                    .build());
        }

        return user.get().update(response);
    }
}
