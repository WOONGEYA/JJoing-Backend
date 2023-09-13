package com.woongeya.zoing.domain.project.service;

import com.woongeya.zoing.domain.project.domain.Project;
import com.woongeya.zoing.domain.project.facade.ProjectFacade;
import com.woongeya.zoing.domain.project.presetation.dto.response.ProjectResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class FindProjectInfoService {

    private final ProjectFacade projectFacade;

    @Transactional(readOnly = true)
    public ProjectResponseDto execute(Long id) {
        Project project = projectFacade.getProject(id);
        project.increaseViewCnt();

        return ProjectResponseDto.of(project);
    }
}
