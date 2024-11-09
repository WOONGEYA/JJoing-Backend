package com.woongeya.zoing.domain.auth.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woongeya.zoing.domain.auth.domain.Token;
import com.woongeya.zoing.domain.auth.service.implementation.TokenProvider;
import com.woongeya.zoing.domain.user.domain.User;
import com.woongeya.zoing.domain.user.domain.autority.Authority;
import com.woongeya.zoing.domain.user.domain.repository.UserRepository;
import com.woongeya.zoing.global.config.credential.AuthCredentials;
import com.woongeya.zoing.global.feign.GoogleAuthClient;
import com.woongeya.zoing.global.feign.GoogleInfoClient;
import com.woongeya.zoing.global.feign.dto.request.GoogleTokenRequest;
import com.woongeya.zoing.global.feign.dto.response.GoogleInfoResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class OAuth2GoogleService {

    private final AuthCredentials authCredentials;
    private final GoogleAuthClient googleAuthClient;
    private final GoogleInfoClient googleInfoClient;
    private final TokenProvider jwtProvider;
    private final UserRepository userRepository;

    public Token execute(String code) {
        String googleToken = googleAuthClient.getGoogleToken(
                createRequest(code)
        ).getAccessToken();
        GoogleInfoResponse userInfo = googleInfoClient.getUserInfo(googleToken);
        User user = saveOrUpdate(userInfo);

        return jwtProvider.createNewToken(user);
    }

    public GoogleTokenRequest createRequest(String code) {
        return GoogleTokenRequest.builder()
                .code(code)
                .clientId(authCredentials.clientId())
                .clientSecret(authCredentials.clientSecret())
                .redirectUri(authCredentials.redirectUri())
                .build();
    }

    private User saveOrUpdate(GoogleInfoResponse response) {
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
