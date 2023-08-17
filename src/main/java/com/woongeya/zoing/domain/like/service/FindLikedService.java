package com.woongeya.zoing.domain.like.service;

import com.woongeya.zoing.domain.like.domain.Like;
import com.woongeya.zoing.domain.like.domain.repository.LikeRepository;
import com.woongeya.zoing.domain.project.domain.Project;
import com.woongeya.zoing.domain.project.facade.ProjectFacade;
import com.woongeya.zoing.domain.project.presetation.dto.response.ProjectResponseDto;
import com.woongeya.zoing.domain.user.UserFacade;
import com.woongeya.zoing.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FindLikedService {

    private final ProjectFacade projectFacade;
    private final UserFacade userFacade;
    private final LikeRepository likeRepository;

    public List<ProjectResponseDto> execute(Long id) {
        User user = userFacade.getUserById(id);
        List<Like> likes = likeRepository.findByUserId(user.getId());

        return likes.stream()
                .map(like -> projectFacade.getProject(like.getProjectId()))
                .map(ProjectResponseDto::of)
                .collect(Collectors.toList());

    }
}
