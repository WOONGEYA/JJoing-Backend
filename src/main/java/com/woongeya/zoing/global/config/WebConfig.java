package com.woongeya.zoing.global.config;

import static org.springframework.http.HttpHeaders.*;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.woongeya.zoing.domain.auth.intercepter.AuthInterceptor;
import com.woongeya.zoing.domain.auth.repository.AuthRepository;
import com.woongeya.zoing.domain.auth.util.JwtParser;
import com.woongeya.zoing.domain.user.UserFacade;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {
	private static final String ALLOW_ALL_PATH = "/**";
	private static final String ALLOWED_METHODS = "*";
	private static final String MAIN_SERVER_DOMAIN = "https://jjoing.com";
	private static final String FRONTEND_LOCALHOST = "http://localhost:3000";
	private static final String HTTPS_FRONTEND_LOCALHOST = "https://localhost:3000";

	private final JwtParser jwtParser;
	private final AuthRepository authRepository;
	private final UserFacade userFacade;

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping(ALLOW_ALL_PATH)
			.allowedMethods(ALLOWED_METHODS)
			.allowedOrigins(
				MAIN_SERVER_DOMAIN,
				FRONTEND_LOCALHOST,
				HTTPS_FRONTEND_LOCALHOST
			)
			.allowCredentials(true)
			.exposedHeaders(LOCATION, SET_COOKIE);
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new AuthInterceptor(jwtParser, authRepository, userFacade));
	}
}
