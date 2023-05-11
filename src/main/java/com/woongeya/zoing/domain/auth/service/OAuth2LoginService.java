package com.woongeya.zoing.domain.auth.service;

import com.woongeya.zoing.domain.user.domain.User;
import com.woongeya.zoing.domain.user.domain.repository.UserRepository;
import com.woongeya.zoing.global.oauth.OAuthAttributes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OAuth2LoginService {

    private final UserRepository userRepository;

    protected User saveOrUpdate(OAuthAttributes oAuthAttributes) {
        Optional<User> user = userRepository.findByEmail(oAuthAttributes.getEmail());

        if (user.isEmpty()) {
            return userRepository.save(oAuthAttributes.toEntity());
        }

        return user.get().update(oAuthAttributes);
    }
}
