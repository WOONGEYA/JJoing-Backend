package com.woongeya.zoing.domain.follow.service;

import com.woongeya.zoing.domain.follow.domain.repository.FollowRepository;
import com.woongeya.zoing.domain.follow.exception.FollowNotFoundException;
import com.woongeya.zoing.domain.user.UserFacade;
import com.woongeya.zoing.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteFollowService {

    private final UserFacade userFacade;
    private final FollowRepository followRepository;

    public void execute(Long id) {
        User fromUser = userFacade.getCurrentUser();
        User toUser = userFacade.getUserById(id);

        followRepository.delete(
                followRepository.findByFromUserIdAndToUserId(fromUser.getId(), toUser.getId())
                        .orElseThrow(() -> FollowNotFoundException.EXCEPTION)
        );
    }
}
