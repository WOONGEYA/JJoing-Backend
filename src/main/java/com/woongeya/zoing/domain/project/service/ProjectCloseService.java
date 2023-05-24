package com.woongeya.zoing.domain.project.service;

import com.woongeya.zoing.domain.project.domain.Project;
import com.woongeya.zoing.domain.project.domain.repository.ProjectRepository;
import com.woongeya.zoing.domain.project.exception.ProjectNotFoundException;
import com.woongeya.zoing.domain.user.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ProjectCloseService {

    private final ProjectRepository projectRepository;
    private final UserFacade userFacade;

    @Transactional
    public void execute(Long id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> ProjectNotFoundException.EXCEPTION);

        project.changeState();
    }
}
