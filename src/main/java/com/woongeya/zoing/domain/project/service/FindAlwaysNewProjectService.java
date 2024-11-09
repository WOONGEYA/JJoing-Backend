package com.woongeya.zoing.domain.project.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woongeya.zoing.domain.auth.repository.AuthRepository;
import com.woongeya.zoing.domain.like.domain.repository.LikeRepository;
import com.woongeya.zoing.domain.project.domain.Project;
import com.woongeya.zoing.domain.project.domain.repository.ProjectRepository;
import com.woongeya.zoing.domain.project.presetation.dto.response.ProjectResponse;
import com.woongeya.zoing.domain.user.domain.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FindAlwaysNewProjectService {

    private final AuthRepository authRepository;
    private final ProjectRepository projectRepository;
    private final LikeRepository likeRepository;

    @Transactional(readOnly = true)
    public List<ProjectResponse> execute() {
        User user = authRepository.getNullableCurrentUser();
        List<Project> projects = projectRepository.findAllByOrderByIdDesc();

        return projects.stream()
                .map(project -> {
                    Integer likeCount = likeRepository.countByProjectId(project.getId());
                    return ProjectResponse.of(project, likeCount, user != null && checkLike(project, user));
                })
                .collect(Collectors.toList());
    }

    private boolean checkLike(Project project,User user){
        return likeRepository.existsByUserIdAndProjectId(user.getId(), project.getId());
    }
}
