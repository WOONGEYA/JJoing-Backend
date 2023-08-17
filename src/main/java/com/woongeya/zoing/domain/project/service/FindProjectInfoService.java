package com.woongeya.zoing.domain.project.service;

import com.woongeya.zoing.domain.project.domain.Project;
import com.woongeya.zoing.domain.project.facade.ProjectFacade;
import com.woongeya.zoing.domain.project.presetation.dto.response.ProjectResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindProjectInfoService {

    private final ProjectFacade projectFacade;

    public ProjectResponseDto execute(Long id) {
        Project project = projectFacade.getProject(id);
        project.increaseViewCnt();

        return ProjectResponseDto.of(project);
    }
}