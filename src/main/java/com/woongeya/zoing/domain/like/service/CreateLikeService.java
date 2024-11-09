package com.woongeya.zoing.domain.like.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woongeya.zoing.domain.auth.repository.AuthRepository;
import com.woongeya.zoing.domain.like.domain.Like;
import com.woongeya.zoing.domain.like.domain.repository.LikeRepository;
import com.woongeya.zoing.domain.like.exception.AlreadyLikeException;
import com.woongeya.zoing.domain.project.domain.Project;
import com.woongeya.zoing.domain.project.facade.ProjectFacade;
import com.woongeya.zoing.domain.user.domain.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CreateLikeService {

    private final AuthRepository authRepository;
    private final ProjectFacade projectFacade;
    private final LikeRepository likeRepository;

    @Transactional
    public void execute(Long id) {
        User user = authRepository.getCurrentUser();
        Project project = projectFacade.getProject(id);

        likeRepository
                .findByUserIdAndProjectId(user.getId(), project.getId())
                .ifPresent(like -> { throw new AlreadyLikeException(like.getId()); });

        likeRepository.save(
                Like.builder()
                        .userId(user.getId())
                        .projectId(project.getId())
                        .build()
        );
    }
}
