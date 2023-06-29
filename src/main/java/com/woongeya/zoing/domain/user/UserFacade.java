package com.woongeya.zoing.domain.user;

import com.woongeya.zoing.domain.user.domain.User;
import com.woongeya.zoing.domain.user.domain.repository.UserRepository;
import com.woongeya.zoing.domain.user.exception.UserNotFoundException;
import com.woongeya.zoing.global.security.auth.AuthDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserFacade {

    private final UserRepository userRepository;

    public User getCurrentUser() {
        AuthDetails auth = (AuthDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return auth.getUser();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }
}
