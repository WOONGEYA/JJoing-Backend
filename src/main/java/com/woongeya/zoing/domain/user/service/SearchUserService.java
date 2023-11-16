package com.woongeya.zoing.domain.user.service;

import com.woongeya.zoing.domain.user.domain.User;
import com.woongeya.zoing.domain.user.domain.repository.CustomUserRepository;
import com.woongeya.zoing.domain.user.domain.repository.UserRepository;
import com.woongeya.zoing.domain.user.presetation.dto.response.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SearchUserService {

    private final UserRepository userRepository;

    public List<UserResponseDto> execute(String q) {
        List<User> users = userRepository.searchUser(q);
        return users.stream()
                .map(UserResponseDto::from)
                .collect(Collectors.toList());
    }
}
