package com.woongeya.zoing.domain.project.service;

import com.woongeya.zoing.domain.project.ProjectFacade;
import com.woongeya.zoing.domain.project.domain.Project;
import com.woongeya.zoing.domain.project.exception.IsNotWriterException;
import com.woongeya.zoing.domain.user.UserFacade;
import com.woongeya.zoing.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ProjectCloseService {

    private final ProjectFacade projectFacade;
    private final UserFacade userFacade;

    @Transactional
    public void execute(Long id) {

        User user = userFacade.getCurrentUser();

        Project project = projectFacade.getProject(id);

        if (!project.isWriter(user.getId())) {
            throw new IsNotWriterException();
        }
    }
}
