package com.woongeya.zoing.domain.project.facade;

import com.woongeya.zoing.domain.project.domain.Project;
import com.woongeya.zoing.domain.project.domain.repository.ProjectRepository;
import com.woongeya.zoing.domain.project.exception.ProjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProjectFacade {

    private final ProjectRepository projectRepository;

    public Project getProject(Long id) {
        return projectRepository.findById(id).orElseThrow(() -> ProjectNotFoundException.EXCEPTION);
    }
}
