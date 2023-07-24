package com.woongeya.zoing.domain.application.presetation;

import com.woongeya.zoing.domain.application.presetation.dto.request.ApplicationCreateRequest;
import com.woongeya.zoing.domain.application.presetation.dto.response.ApplicationResponseDto;
import com.woongeya.zoing.domain.application.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/application")
public class ApplicationController {

    private final CreateApplicationService createApplicationService;
    private final CancelApplicationService cancelApplicationService;
    private final RejectApplicationService rejectApplicationService;
    private final AcceptApplicationService acceptApplicationService;
    private final FindProjectApplicationService findProjectApplicationService;

    @PostMapping("/{id}")
    public void createApplication(@RequestBody @Valid ApplicationCreateRequest request, @PathVariable Long id) {
        createApplicationService.execute(request, id);
    }

    @PutMapping("{id}/accept")
    public void acceptApplication(@PathVariable Long id) {
        acceptApplicationService.execute(id);
    }

    @PutMapping("/{id}/cancel")
    public void cancelApplication(@PathVariable Long id) {
        cancelApplicationService.execute(id);
    }

    @PutMapping("/{id}/reject")
    public void rejectApplication(@PathVariable Long id) {
        rejectApplicationService.execute(id);
    }

    @GetMapping("/project/{id}")
    public ResponseEntity<List<ApplicationResponseDto>> findProjectApplication(@PathVariable Long id) {
        return ResponseEntity.ok(findProjectApplicationService.execute(id));
    }
}
