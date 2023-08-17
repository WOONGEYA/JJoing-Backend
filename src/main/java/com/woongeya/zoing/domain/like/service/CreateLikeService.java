package com.woongeya.zoing.domain.like.service;

import com.woongeya.zoing.domain.like.domain.Like;
import com.woongeya.zoing.domain.like.domain.repository.LikeRepository;
import com.woongeya.zoing.domain.like.exception.AlreadyLikeException;
import com.woongeya.zoing.domain.like.exception.NonExistentProjectException;
import com.woongeya.zoing.domain.project.domain.Project;
import com.woongeya.zoing.domain.project.domain.repository.ProjectRepository;
import com.woongeya.zoing.domain.project.facade.ProjectFacade;
import com.woongeya.zoing.domain.user.UserFacade;
import com.woongeya.zoing.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateLikeService {

    private final UserFacade userFacade;
    private final ProjectFacade projectFacade;
    private final ProjectRepository projectRepository;
    private final LikeRepository likeRepository;

    public void execute(Long id) {
        User user = userFacade.getCurrentUser();
        Project project = projectFacade.getProject(id);

        projectRepository
                .findById(project.getId())
                .orElseThrow(NonExistentProjectException::new);

        likeRepository
                .findByUserIdAndProjectId(user.getId(), project.getId())
                .orElseThrow(AlreadyLikeException::new);

        likeRepository.save(
                Like.builder()
                        .userId(user.getId())
                        .projectId(project.getId())
                        .build()
        );
    }
}
