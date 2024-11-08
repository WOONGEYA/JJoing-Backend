package com.woongeya.zoing.domain.like.service;

import com.woongeya.zoing.domain.auth.repository.AuthRepository;
import com.woongeya.zoing.domain.like.domain.repository.LikeRepository;
import com.woongeya.zoing.domain.like.exception.YouDontLikeBeforeException;
import com.woongeya.zoing.domain.project.domain.Project;
import com.woongeya.zoing.domain.project.facade.ProjectFacade;
import com.woongeya.zoing.domain.user.UserFacade;
import com.woongeya.zoing.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DeleteLikeService {

    private final AuthRepository authRepository;
    private final ProjectFacade projectFacade;
    private final LikeRepository likeRepository;

    @Transactional
    public void execute(Long id) {
        User user = authRepository.getCurrentUser();
        Project project = projectFacade.getProject(id);

        likeRepository.delete(
                likeRepository.findByUserIdAndProjectId(user.getId(), project.getId())
                        .orElseThrow(()-> YouDontLikeBeforeException.EXCEPTION)
        );
    }
}
