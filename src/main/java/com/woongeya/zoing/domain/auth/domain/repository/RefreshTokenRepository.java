package com.woongeya.zoing.domain.auth.domain.repository;

import com.woongeya.zoing.domain.auth.domain.RefreshToken;
import org.springframework.data.repository.CrudRepository;

public interface RefreshTokenRepository extends CrudRepository<RefreshToken, String> {
}
