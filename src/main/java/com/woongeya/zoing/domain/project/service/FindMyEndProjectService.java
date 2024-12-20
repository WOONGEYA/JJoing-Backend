package com.woongeya.zoing.domain.project.service;

import com.woongeya.zoing.domain.auth.repository.AuthRepository;
import com.woongeya.zoing.domain.like.domain.repository.LikeRepository;
import com.woongeya.zoing.domain.project.domain.Project;
import com.woongeya.zoing.domain.project.domain.repository.ProjectRepository;
import com.woongeya.zoing.domain.project.presetation.dto.response.ProjectResponse;
import com.woongeya.zoing.domain.user.UserFacade;
import com.woongeya.zoing.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FindMyEndProjectService {

    private final AuthRepository authRepository;
    private final ProjectRepository projectRepository;
    private final LikeRepository likeRepository;

    public List<ProjectResponse> execute() {
        User user = authRepository.getCurrentUser();
        List<Project> projects = projectRepository.findMyEndProject(user.getId());

        return projects.stream()
                .map(project -> {
                    Integer likeCount = likeRepository.countByProjectId(project.getId());
                    return ProjectResponse.of(project, likeCount, checkLike(project, user));
                })
                .collect(Collectors.toList());
    }

    private boolean checkLike(Project project, User user){
        return likeRepository.existsByUserIdAndProjectId(user.getId(), project.getId());
    }
}
