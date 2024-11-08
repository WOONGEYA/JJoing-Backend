package com.woongeya.zoing.domain.auth.repository;

import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.RequestScope;

import com.woongeya.zoing.domain.auth.exception.UserNotLoginException;
import com.woongeya.zoing.domain.user.domain.User;

@Repository
@RequestScope
public class AuthRepository {
	private User currentUser;

	public User getCurrentUser() {
		if (currentUser == null) {
			throw new UserNotLoginException();
		}
		return currentUser;
	}

	public User getNullableCurrentUser() {
		return currentUser;
	}

	public void updateCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}
}
