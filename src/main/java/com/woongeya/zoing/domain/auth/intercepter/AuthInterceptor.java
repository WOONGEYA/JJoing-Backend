package com.woongeya.zoing.domain.auth.intercepter;

import static org.springframework.http.HttpHeaders.*;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import com.woongeya.zoing.domain.auth.annotation.AdminOnly;
import com.woongeya.zoing.domain.auth.annotation.LoginOrNot;
import com.woongeya.zoing.domain.auth.annotation.LoginRequired;
import com.woongeya.zoing.domain.auth.exception.TokenNotExistException;
import com.woongeya.zoing.domain.auth.exception.UserIsNotAdminException;
import com.woongeya.zoing.domain.auth.repository.AuthRepository;
import com.woongeya.zoing.domain.auth.util.BearerTokenExtractor;
import com.woongeya.zoing.domain.auth.util.JwtParser;
import com.woongeya.zoing.domain.user.UserFacade;
import com.woongeya.zoing.domain.user.domain.User;
import com.woongeya.zoing.domain.user.domain.autority.Authority;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class AuthInterceptor implements HandlerInterceptor {

	private final JwtParser jwtParser;
	private final AuthRepository authRepository;
	private final UserFacade userFacade;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		if (handler instanceof HandlerMethod hm) {
			if (hm.hasMethodAnnotation(LoginOrNot.class)) {
				String bearer = request.getHeader(AUTHORIZATION);

				if (bearer == null) {
					authRepository.updateCurrentUser(null);
				} else {
					String jwt = BearerTokenExtractor.extract(bearer);
					Long userId = jwtParser.getIdFromJwt(jwt);
					User user = userFacade.getUserById(userId);
					authRepository.updateCurrentUser(user);
				}
			}

			if (hm.hasMethodAnnotation(LoginRequired.class)) {
				if (authRepository.getCurrentUser() == null) {
					throw new TokenNotExistException();
				}
			}
			if (hm.hasMethodAnnotation(AdminOnly.class)) {
				User currentUser = authRepository.getCurrentUser();
				shouldUserAdmin(currentUser);
			}
		}

		return true;
	}

	private static void shouldUserAdmin(User currentUser) {
		if (currentUser.getAuthority() != Authority.ADMIN) {
			throw new UserIsNotAdminException();
		}
	}
}
