package com.woongeya.zoing.domain.auth.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.woongeya.zoing.domain.auth.domain.Token;
import com.woongeya.zoing.domain.auth.infra.feign.GoogleAuthClient;
import com.woongeya.zoing.domain.auth.infra.feign.GoogleInfoClient;
import com.woongeya.zoing.domain.auth.infra.feign.dto.request.GoogleTokenRequest;
import com.woongeya.zoing.domain.auth.infra.feign.dto.response.GoogleInfoResponse;
import com.woongeya.zoing.domain.auth.infra.feign.dto.response.GoogleTokenResponse;
import com.woongeya.zoing.domain.auth.service.implementation.AuthReader;
import com.woongeya.zoing.domain.auth.service.implementation.TokenProvider;
import com.woongeya.zoing.domain.auth.util.BearerTokenExtractor;
import com.woongeya.zoing.domain.user.UserFacade;
import com.woongeya.zoing.domain.user.domain.User;
import com.woongeya.zoing.domain.user.domain.autority.Authority;
import com.woongeya.zoing.domain.user.domain.repository.UserRepository;
import com.woongeya.zoing.domain.user.exception.UserNotFoundException;
import com.woongeya.zoing.global.config.credential.AuthCredentials;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommandAuthService {

	private final AuthReader authReader;
	private final TokenProvider tokenProvider;
	private final UserFacade userFacade;
	private final GoogleAuthClient googleAuthClient;
	private final GoogleInfoClient googleInfoClient;
	private final AuthCredentials authCredentials;
	private final UserRepository userRepository;

	public Token login(String code) {
		GoogleTokenResponse googleToken = googleAuthClient.getGoogleToken(
			GoogleTokenRequest.from(code, authCredentials)
		);
		GoogleInfoResponse userInfo = googleInfoClient.getUserInfo(googleToken.accessToken());
		User user = saveOrUpdate(userInfo);

		return tokenProvider.createNewToken(user);
	}

	public Token refresh(String bearer) {
		String refreshToken = BearerTokenExtractor.extract(bearer);
		Long userId = authReader.getIdFromJwt(refreshToken);
		String accessToken = tokenProvider.createAccessToken(userFacade.getUserById(userId));

		return new Token(accessToken, refreshToken);
	}

	private User saveOrUpdate(GoogleInfoResponse userInfo) {
		Optional<User> user = userRepository.findByEmail(userInfo.email());

		if (user.isPresent()) {
			return user.get().update(userInfo.toEntity());
		}

		return userRepository.save(userInfo.toEntity());
	}
}
