package com.woongeya.zoing.domain.like.service;

import com.woongeya.zoing.domain.like.domain.repository.LikeRepository;
import com.woongeya.zoing.domain.like.exception.YouDontLikeBeforeException;
import com.woongeya.zoing.domain.project.domain.Project;
import com.woongeya.zoing.domain.project.facade.ProjectFacade;
import com.woongeya.zoing.domain.user.UserFacade;
import com.woongeya.zoing.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteLikeService {

    private final UserFacade userFacade;
    private final ProjectFacade projectFacade;
    private final LikeRepository likeRepository;

    public void execute(Long id) {
        User user = userFacade.getCurrentUser();
        Project project = projectFacade.getProject(id);

        likeRepository.delete(
                likeRepository.findByUserIdAndProjectId(user.getId(), project.getId())
                        .orElseThrow(()-> YouDontLikeBeforeException.EXCEPTION)
        );
    }
}
