package com.woongeya.zoing.domain.user.service;

import com.woongeya.zoing.domain.follow.domain.repository.FollowRepository;
import com.woongeya.zoing.domain.user.domain.User;
import com.woongeya.zoing.domain.user.domain.repository.UserRepository;
import com.woongeya.zoing.domain.user.presetation.dto.response.SearchUserResponse;
import com.woongeya.zoing.global.util.SecurityUtil;
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
    private final FollowRepository followRepository;

    public List<SearchUserResponse> execute(String q) {
        User currentUser = SecurityUtil.getCurrentUserOrNull();
        List<User> users = userRepository.searchUser(q);
        return users.stream()
                .map(user -> SearchUserResponse.of(user, followRepository.countByToUserId(user.getId()), followRepository.countByFromUserId(user.getId()), currentUser != null && followRepository.existsByToUserIdAndFromUserId(user.getId(), currentUser.getId())))
                .collect(Collectors.toList());
    }
}
