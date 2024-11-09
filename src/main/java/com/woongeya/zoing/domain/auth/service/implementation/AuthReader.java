package com.woongeya.zoing.domain.auth.service.implementation;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woongeya.zoing.domain.auth.repository.AuthRepository;
import com.woongeya.zoing.domain.auth.util.JwtParser;
import com.woongeya.zoing.domain.user.domain.User;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AuthReader {

	private final AuthRepository authRepository;
	private final JwtParser jwtParser;

	public User getCurrentUser() {
		return authRepository.getCurrentUser();
	}

	public User getNullableCurrentUser() {
		return authRepository.getNullableCurrentUser();
	}

	public Long getIdFromJwt(String refresh) {
		return jwtParser.getIdFromJwt(refresh);
	}
}
