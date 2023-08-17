package com.woongeya.zoing.domain.like.service;

import com.woongeya.zoing.domain.like.domain.repository.LikeRepository;
import com.woongeya.zoing.domain.project.domain.Project;
import com.woongeya.zoing.domain.project.facade.ProjectFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CountLikerService {

    private final ProjectFacade projectFacade;
    private final LikeRepository likeRepository;

    public Long execute(Long id) {
        Project project = projectFacade.getProject(id);

        return likeRepository.countByProjectId(project.getId());
    }
}
