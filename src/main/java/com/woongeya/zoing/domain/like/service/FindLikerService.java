package com.woongeya.zoing.domain.like.service;
import com.woongeya.zoing.domain.like.domain.Like;
import com.woongeya.zoing.domain.like.domain.repository.LikeRepository;
import com.woongeya.zoing.domain.like.presentation.dto.response.LikerResponseDto;
import com.woongeya.zoing.domain.project.domain.Project;
import com.woongeya.zoing.domain.project.facade.ProjectFacade;
import com.woongeya.zoing.domain.user.UserFacade;
import com.woongeya.zoing.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FindLikerService {

    private final UserFacade userFacade;
    private final ProjectFacade projectFacade;
    private final LikeRepository likeRepository;

    public List<LikerResponseDto> execute(Long id) {
        Project project = projectFacade.getProject(id);
        List<Like> likes = likeRepository.findByProjectId(project.getId());

        return likes.stream()
                .map(like -> userFacade.getUserById(like.getUserId()))
                .map(User::getName)
                .map(LikerResponseDto::new)
                .collect(Collectors.toList());

    }
}
