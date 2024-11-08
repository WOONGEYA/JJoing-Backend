package com.woongeya.zoing.domain.user.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woongeya.zoing.domain.auth.repository.AuthRepository;
import com.woongeya.zoing.domain.follow.domain.repository.FollowRepository;
import com.woongeya.zoing.domain.user.domain.User;
import com.woongeya.zoing.domain.user.domain.repository.UserRepository;
import com.woongeya.zoing.domain.user.presetation.dto.response.SearchUserResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SearchUserService {

    private final AuthRepository authRepository;
    private final UserRepository userRepository;
    private final FollowRepository followRepository;

    public List<SearchUserResponse> execute(String q) {
        User currentUser = authRepository.getNullableCurrentUser();
        List<User> users = userRepository.searchUser(q);
        return users.stream()
                .map(user -> SearchUserResponse.of(user, followRepository.countByToUserId(user.getId()), followRepository.countByFromUserId(user.getId()), currentUser != null && followRepository.existsByToUserIdAndFromUserId(user.getId(), currentUser.getId())))
                .collect(Collectors.toList());
    }
}
