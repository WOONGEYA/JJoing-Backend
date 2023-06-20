package com.woongeya.zoing.domain.application.service;

import com.woongeya.zoing.domain.application.domain.Application;
import com.woongeya.zoing.domain.application.domain.repository.ApplicationRepository;
import com.woongeya.zoing.domain.application.domain.type.ApplicationState;
import com.woongeya.zoing.domain.project.ProjectFacade;
import com.woongeya.zoing.domain.project.domain.Project;
import com.woongeya.zoing.domain.application.presetation.dto.request.ApplicationCreateRequest;
import com.woongeya.zoing.domain.user.UserFacade;
import com.woongeya.zoing.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateApplicationService {

    private final UserFacade userFacade;
    private final ProjectFacade projectFacade;
    private final ApplicationRepository applicationRepository;

    @Transactional
    public void execute(ApplicationCreateRequest request, Long id) {

        User user = userFacade.getCurrentUser();
        Project project = projectFacade.getProject(id);

        applicationRepository.save(Application.builder()
                .userId(user.getId())
                .projectId(project.getId())
                .projectWriterId(project.getWriterId())
                .introduce(request.getIntroduce())
                .state(ApplicationState.PENDING)
                .position(request.getPosition())
                .build());
    }
}
