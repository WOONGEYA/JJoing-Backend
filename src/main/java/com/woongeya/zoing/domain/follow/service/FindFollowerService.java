package com.woongeya.zoing.domain.follow.service;

import com.woongeya.zoing.domain.follow.domain.Follow;
import com.woongeya.zoing.domain.follow.domain.repository.FollowRepository;
import com.woongeya.zoing.domain.follow.presetation.dto.reponse.FollowResponseDto;
import com.woongeya.zoing.domain.user.UserFacade;
import com.woongeya.zoing.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FindFollowerService {

    private final UserFacade userFacade;
    private final FollowRepository followRepository;

    public List<FollowResponseDto> execute(Long id) {
        User user = userFacade.getUserById(id);
        List<Follow> follows = followRepository.findByFromUserId(user.getId());

        return follows.stream()
                .map(follow -> userFacade.getUserById(follow.getToUserId()).getName())
                .map(name -> new FollowResponseDto(id, name))
                .collect(Collectors.toList());
    }
}
