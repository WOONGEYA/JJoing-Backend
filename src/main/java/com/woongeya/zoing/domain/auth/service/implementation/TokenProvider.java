package com.woongeya.zoing.domain.auth.service.implementation;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.woongeya.zoing.domain.auth.domain.Token;
import com.woongeya.zoing.domain.user.domain.User;
import com.woongeya.zoing.global.config.credential.JwtCredentials;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TokenProvider {

	private final JwtCredentials jwtCredentials;

	public Token createNewToken(User user) {
		return new Token(
			createAccessToken(user),
			createRefreshToken(user)
		);
	}

	public String createAccessToken(User user) {
		return createToken(user, jwtCredentials.accessTokenExpirationTime());
	}

	private String createRefreshToken(User user) {
		return createToken(user, jwtCredentials.refreshTokenExpirationTime());
	}

	private String createToken(User user, long expireLength) {
		Date expiration = new Date(System.currentTimeMillis() + expireLength);
		return Jwts.builder()
			.claim("id", user.getId())
			.setExpiration(expiration)
			.signWith(jwtCredentials.secretKey(), SignatureAlgorithm.HS256)
			.compact();
	}
}
