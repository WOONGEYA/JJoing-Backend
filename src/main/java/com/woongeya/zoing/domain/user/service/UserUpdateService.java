package com.woongeya.zoing.domain.user.service;

import com.woongeya.zoing.domain.auth.repository.AuthRepository;
import com.woongeya.zoing.domain.user.UserFacade;
import com.woongeya.zoing.domain.user.domain.User;
import com.woongeya.zoing.domain.user.domain.repository.UserRepository;
import com.woongeya.zoing.domain.user.presetation.dto.request.UpdateUserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserUpdateService {

    private final AuthRepository authRepository;
    private final UserRepository userRepository;

    @Transactional
    public void execute(UpdateUserRequest request) {
        User user = authRepository.getCurrentUser();
        user.updateInfo(request);

        userRepository.save(user);
    }
}
