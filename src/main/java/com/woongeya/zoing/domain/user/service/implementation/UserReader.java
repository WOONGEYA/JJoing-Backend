package com.woongeya.zoing.domain.user.service.implementation;

import org.springframework.stereotype.Service;

import com.woongeya.zoing.domain.user.domain.User;
import com.woongeya.zoing.domain.user.domain.repository.UserRepository;
import com.woongeya.zoing.domain.user.exception.UserNotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserReader {

	private final UserRepository userRepository;

	public User readUser(Long userId) {
		return userRepository.findById(userId)
			.orElseThrow(() -> new UserNotFoundException(userId));
	}
}
