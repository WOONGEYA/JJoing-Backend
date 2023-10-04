package com.woongeya.zoing.domain.project.service;

import com.woongeya.zoing.domain.application.domain.Application;
import com.woongeya.zoing.domain.application.domain.repository.ApplicationRepository;
import com.woongeya.zoing.domain.like.domain.repository.LikeRepository;
import com.woongeya.zoing.domain.project.domain.Project;
import com.woongeya.zoing.domain.project.facade.ProjectFacade;
import com.woongeya.zoing.domain.project.presetation.dto.response.ProjectResponseDto;
import com.woongeya.zoing.domain.user.UserFacade;
import com.woongeya.zoing.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FindMyApplicationProjectService {

    private final UserFacade userFacade;
    private final ProjectFacade projectFacade;
    private final ApplicationRepository applicationRepository;
    private final LikeRepository likeRepository;

    @Transactional(readOnly = true)
    public List<ProjectResponseDto> execute() {
        User user = userFacade.getCurrentUser();
        List<Application> applications = applicationRepository.findByUserId(user.getId());

        return applications.stream()
                .map(application -> projectFacade.getProject(application.getProjectId()))
                .map(project -> {
                    Integer likeCount = likeRepository.countByProjectId(project.getId());
                    return ProjectResponseDto.of(project, likeCount, checkLike(project, user));
                })
                .collect(Collectors.toList());
    }

    private boolean checkLike(Project project, User user){
        return likeRepository.existsByUserIdAndProjectId(user.getId(), project.getId());
    }
}
