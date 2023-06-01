package com.woongeya.zoing.domain.application.presetation;

import com.woongeya.zoing.domain.application.presetation.dto.request.ApplicationCreateRequest;
import com.woongeya.zoing.domain.application.service.ApplicationCancelService;
import com.woongeya.zoing.domain.application.service.ApplicationCreateService;
import com.woongeya.zoing.domain.application.service.ApplicationRejectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/application")
public class ApplicationController {

    private final ApplicationCreateService applicationCreateService;
    private final ApplicationCancelService applicationCancelService;
    private final ApplicationRejectService applicationRejectService;

    @PostMapping("/{id}")
    public void createApplication(@RequestBody ApplicationCreateRequest request, @PathVariable Long id) {
        applicationCreateService.execute(request, id);
    }

    @PutMapping("/cancel/{id}")
    public void cancelApplication(@PathVariable Long id) {
        applicationCancelService.execute(id);
    }

    @PutMapping("/reject/{id}")
    public void rejectApplication(@PathVariable Long id) { applicationRejectService.execute(id); }
}
