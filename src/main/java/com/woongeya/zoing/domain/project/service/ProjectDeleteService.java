package com.woongeya.zoing.domain.project.service;

import com.woongeya.zoing.domain.project.ProjectFacade;
import com.woongeya.zoing.domain.project.domain.Project;
import com.woongeya.zoing.domain.project.domain.repository.ProjectRepository;
import com.woongeya.zoing.domain.project.exception.IsNotWriterException;
import com.woongeya.zoing.domain.user.UserFacade;
import com.woongeya.zoing.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProjectDeleteService {

    private final ProjectFacade projectFacade;
    private final ProjectRepository projectRepository;
    private final UserFacade userFacade;

    @Transactional
    public void execute(Long id) {
        User user = userFacade.getCurrentUser();
        Project project = projectFacade.getProject(id);

        if (!project.isWriter(user.getId())) {
            throw new IsNotWriterException();
        }

        projectRepository.delete(project);
    }
}
