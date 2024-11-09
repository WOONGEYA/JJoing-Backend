package com.woongeya.zoing.domain.auth.service.implementation;

import org.springframework.stereotype.Service;

import com.woongeya.zoing.domain.auth.repository.AuthRepository;
import com.woongeya.zoing.domain.user.domain.User;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthUpdater {

	private final AuthRepository authRepository;

	public void updateCurrentUser(User user) {
		authRepository.updateCurrentUser(user);
	}
}
