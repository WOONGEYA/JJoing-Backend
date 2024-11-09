package com.woongeya.zoing.domain.follow.service;

import com.woongeya.zoing.domain.auth.repository.AuthRepository;
import com.woongeya.zoing.domain.follow.domain.repository.FollowRepository;
import com.woongeya.zoing.domain.follow.exception.FollowNotFoundException;
import com.woongeya.zoing.domain.user.UserFacade;
import com.woongeya.zoing.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DeleteFollowService {

    private final AuthRepository authRepository;
    private final UserFacade userFacade;
    private final FollowRepository followRepository;

    @Transactional
    public void execute(Long id) {
        User fromUser = authRepository.getCurrentUser();
        User toUser = userFacade.getUserById(id);

        followRepository.delete(
                followRepository.findByFromUserIdAndToUserId(fromUser.getId(), toUser.getId())
                        .orElseThrow(FollowNotFoundException::new)
        );
    }
}
