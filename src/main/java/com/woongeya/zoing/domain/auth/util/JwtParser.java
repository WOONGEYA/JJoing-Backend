package com.woongeya.zoing.domain.auth.util;

import org.springframework.stereotype.Component;

import com.woongeya.zoing.domain.auth.exception.TokenExpiredException;
import com.woongeya.zoing.domain.auth.exception.TokenInvalidException;
import com.woongeya.zoing.global.config.credential.JwtCredentials;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtParser {

	private static final String ID = "id";
	private final JwtCredentials jwtCredentials;

	public Long getIdFromJwt(String jwt) {
		try {
			return Long.parseLong(Jwts.parserBuilder()
				.setSigningKey(jwtCredentials.secretKey())
				.build()
				.parseClaimsJws(jwt)
				.getBody()
				.get(ID)
				.toString());
		} catch (ExpiredJwtException e) {
			throw new TokenExpiredException();
		} catch (JwtException e) {
			throw new TokenInvalidException();
		}
	}
}
