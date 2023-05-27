package com.woongeya.zoing.domain.application.presetation;

import com.woongeya.zoing.domain.application.presetation.dto.request.ApplicationCreateRequest;
import com.woongeya.zoing.domain.application.service.ApplicationCreateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/application")
public class ApplicationController {

    private final ApplicationCreateService applicationCreateService;

    @PostMapping("/{id}")
    public void createApplication(@RequestBody ApplicationCreateRequest request, @PathVariable Long id) {
        applicationCreateService.execute(request, id);
    }
}
