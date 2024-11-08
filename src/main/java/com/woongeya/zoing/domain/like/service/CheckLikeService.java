package com.woongeya.zoing.domain.like.service;

import com.woongeya.zoing.domain.auth.repository.AuthRepository;
import com.woongeya.zoing.domain.like.domain.repository.LikeRepository;
import com.woongeya.zoing.domain.project.domain.Project;
import com.woongeya.zoing.domain.project.facade.ProjectFacade;
import com.woongeya.zoing.domain.user.UserFacade;
import com.woongeya.zoing.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CheckLikeService {

    private final AuthRepository authRepository;
    private final ProjectFacade projectFacade;
    private final LikeRepository likeRepository;

    public boolean execute(Long id) {
        User user = authRepository.getCurrentUser();
        Project project = projectFacade.getProject(id);

        return likeRepository.findByUserIdAndProjectId(user.getId(), project.getId())
                .isPresent();
    }
}
