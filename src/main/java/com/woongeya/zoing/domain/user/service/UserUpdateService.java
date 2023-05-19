package com.woongeya.zoing.domain.user.service;

import com.woongeya.zoing.domain.user.UserFacade;
import com.woongeya.zoing.domain.user.domain.User;
import com.woongeya.zoing.domain.user.presetation.dto.request.UpdateUserRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.woongeya.zoing.domain.user.domain.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserUpdateService {

    private final UserFacade userFacade;
    private final UserRepository userRepository;

    @Transactional
    public void execute(UpdateUserRequestDto request) {
        User user = userFacade.getCurrentUser();
        user.updateInfo(request);

        userRepository.save(user);
    }
}
