package com.woongeya.zoing.domain.follow.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woongeya.zoing.domain.follow.domain.repository.FollowRepository;
import com.woongeya.zoing.domain.user.UserFacade;
import com.woongeya.zoing.domain.user.domain.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CountFollowingService {

    private final UserFacade userFacade;
    private final FollowRepository followRepository;

    @Transactional(readOnly = true)
    public Integer execute(Long id) {
        User user = userFacade.getUserById(id);

        return followRepository.countByToUserId(user.getId());
    }
}
