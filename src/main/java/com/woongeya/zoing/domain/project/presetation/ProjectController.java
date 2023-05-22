package com.woongeya.zoing.domain.project.presetation;

import com.woongeya.zoing.domain.project.presetation.dto.request.CreateProjectRequestDto;
import com.woongeya.zoing.domain.project.service.ProjectCloseService;
import com.woongeya.zoing.domain.project.service.ProjectCreateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/project")
public class ProjectController {

    private final ProjectCreateService projectCreateService;
    private final ProjectCloseService projectCloseService;

    @PostMapping("")
    public void createProject(@RequestBody CreateProjectRequestDto request) {
        projectCreateService.execute(request);
    }

    @PutMapping("/close/{id}")
    public void closeProject(@PathVariable Long id) {
        projectCloseService.execute(id);
    }
}
