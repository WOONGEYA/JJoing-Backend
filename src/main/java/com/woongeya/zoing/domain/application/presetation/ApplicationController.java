package com.woongeya.zoing.domain.application.presetation;

import com.woongeya.zoing.domain.application.presetation.dto.request.ApplicationCreateRequest;
import com.woongeya.zoing.domain.application.service.CancelApplicationService;
import com.woongeya.zoing.domain.application.service.CreateApplicationService;
import com.woongeya.zoing.domain.application.service.RejectApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/application")
public class ApplicationController {

    private final CreateApplicationService createApplicationService;
    private final CancelApplicationService cancelApplicationService;
    private final RejectApplicationService rejectApplicationService;

    @PostMapping("/{id}")
    public void createApplication(@RequestBody @Valid ApplicationCreateRequest request, @PathVariable Long id) {
        createApplicationService.execute(request, id);
    }

    @PutMapping("/{id}/cancel")
    public void cancelApplication(@PathVariable Long id) {
        cancelApplicationService.execute(id);
    }

    @PutMapping("/{id}/reject")
    public void rejectApplication(@PathVariable Long id) { rejectApplicationService.execute(id); }
}
