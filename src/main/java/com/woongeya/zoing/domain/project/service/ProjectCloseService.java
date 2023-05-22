package com.woongeya.zoing.domain.project.service;

import com.woongeya.zoing.domain.project.domain.Project;
import com.woongeya.zoing.domain.project.domain.repository.ProjectRepository;
import com.woongeya.zoing.domain.project.exception.ProjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProjectCloseService {

    private final ProjectRepository projectRepository;

    public void execute(Long id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> ProjectNotFoundException.EXCEPTION);

        project.changeState();
    }
}
