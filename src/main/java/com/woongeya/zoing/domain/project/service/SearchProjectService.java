package com.woongeya.zoing.domain.project.service;

import com.woongeya.zoing.domain.project.domain.repository.ProjectRepository;
import com.woongeya.zoing.domain.project.presetation.dto.response.ProjectResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SearchProjectService {

    private ProjectRepository projectRepository;

    public List<ProjectResponseDto> execute(String q) {
        return projectRepository.searchProject(q).stream()
                .map(ProjectResponseDto::of)
                .collect(Collectors.toList());
    }
}
