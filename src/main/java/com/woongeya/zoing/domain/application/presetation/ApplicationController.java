package com.woongeya.zoing.domain.application.presetation;

import com.woongeya.zoing.domain.application.presetation.dto.request.ApplicationCreateRequest;
import com.woongeya.zoing.domain.application.service.ApplicationCancelService;
import com.woongeya.zoing.domain.application.service.ApplicationCreateService;
import com.woongeya.zoing.domain.application.service.ApplicationRejectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/application")
public class ApplicationController {

    private final ApplicationCreateService applicationCreateService;
    private final ApplicationCancelService applicationCancelService;
    private final ApplicationRejectService applicationRejectService;

    @PostMapping("/{id}")
    public void createApplication(@RequestBody @Valid ApplicationCreateRequest request, @PathVariable Long id) {
        applicationCreateService.execute(request, id);
    }

    @PutMapping("/{id}/cancel")
    public void cancelApplication(@PathVariable Long id) {
        applicationCancelService.execute(id);
    }

    @PutMapping("/{id}/reject")
    public void rejectApplication(@PathVariable Long id) { applicationRejectService.execute(id); }
}
