package com.woongeya.zoing.domain.follow.service;

import com.woongeya.zoing.domain.follow.domain.repository.FollowRepository;
import com.woongeya.zoing.domain.user.UserFacade;
import com.woongeya.zoing.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CountFollowerService {

    private final UserFacade userFacade;
    private final FollowRepository followRepository;

    public Long execute(Long id) {
        User user = userFacade.getUserById(id);

        return followRepository.countByFromUserId(user.getId());
    }
}
