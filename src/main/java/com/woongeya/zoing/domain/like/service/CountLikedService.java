package com.woongeya.zoing.domain.like.service;

import com.woongeya.zoing.domain.like.domain.repository.LikeRepository;
import com.woongeya.zoing.domain.user.UserFacade;
import com.woongeya.zoing.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CountLikedService {

    private final UserFacade userFacade;
    private final LikeRepository likeRepository;

    public Long execute(Long id) {
        User user = userFacade.getUserById(id);

        return likeRepository.countByUserId(user.getId());
    }
}
