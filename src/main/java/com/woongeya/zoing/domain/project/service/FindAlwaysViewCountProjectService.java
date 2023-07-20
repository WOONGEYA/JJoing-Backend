package com.woongeya.zoing.domain.project.service;

import com.woongeya.zoing.domain.project.domain.Project;
import com.woongeya.zoing.domain.project.domain.repository.ProjectRepository;
import com.woongeya.zoing.domain.project.presetation.dto.response.ProjectResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FindAlwaysViewCountProjectService {

    private final ProjectRepository projectRepository;

    public List<ProjectResponseDto> execute() {
        List<Project> projects = projectRepository.findAllByOrderByViewCountDesc();

        return projects.stream()
                .map(ProjectResponseDto::of)
                .collect(Collectors.toList());
    }
}
