package com.woongeya.zoing.domain.follow.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woongeya.zoing.domain.auth.repository.AuthRepository;
import com.woongeya.zoing.domain.follow.domain.Follow;
import com.woongeya.zoing.domain.follow.domain.repository.FollowRepository;
import com.woongeya.zoing.domain.follow.presetation.dto.reponse.FollowResponse;
import com.woongeya.zoing.domain.user.UserFacade;
import com.woongeya.zoing.domain.user.domain.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FindFollowingService {

    private final AuthRepository authRepository;
    private final UserFacade userFacade;
    private final FollowRepository followRepository;

    @Transactional
    public List<FollowResponse> execute(Long id) {
        User currentUser = authRepository.getNullableCurrentUser();
        User user = userFacade.getUserById(id);
        List<Follow> follows = followRepository.findByToUserId(user.getId());

        return follows.stream()
                .map(follow -> {
                    User fromUser = userFacade.getUserById(follow.getFromUserId());
                    return FollowResponse.of(fromUser, currentUser != null && checkFollow(fromUser, currentUser));
                })
                .collect(Collectors.toList());
    }

    private boolean checkFollow(User toUser, User currentUser) {
        return followRepository.existsByToUserIdAndFromUserId(toUser.getId(), currentUser.getId());
    }
}
