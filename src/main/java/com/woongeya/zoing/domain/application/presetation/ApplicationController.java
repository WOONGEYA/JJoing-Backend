package com.woongeya.zoing.domain.application.presetation;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.woongeya.zoing.domain.application.presetation.dto.request.ApplicationCreateRequest;
import com.woongeya.zoing.domain.application.presetation.dto.response.ApplicationResponse;
import com.woongeya.zoing.domain.application.service.AcceptApplicationService;
import com.woongeya.zoing.domain.application.service.CancelApplicationService;
import com.woongeya.zoing.domain.application.service.CreateApplicationService;
import com.woongeya.zoing.domain.application.service.FindApplicationService;
import com.woongeya.zoing.domain.application.service.FindProjectApplicationService;
import com.woongeya.zoing.domain.application.service.RejectApplicationService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/application")
public class ApplicationController {

    private final CreateApplicationService createApplicationService;
    private final CancelApplicationService cancelApplicationService;
    private final RejectApplicationService rejectApplicationService;
    private final AcceptApplicationService acceptApplicationService;
    private final FindProjectApplicationService findProjectApplicationService;
    private final FindApplicationService findApplicationService;

    @PostMapping("/{id}")
    @Operation(summary = "신청 생성")
    public void createApplication(@RequestBody @Valid ApplicationCreateRequest request, @PathVariable Long id) {
        createApplicationService.execute(request, id);
    }

    @PutMapping("/{id}/accept")
    @Operation(summary = "신청 수락")
    public void acceptApplication(@PathVariable Long id) {
        acceptApplicationService.execute(id);
    }

    @PutMapping("/{id}/cancel")
    @Operation(summary = "신청 취소")
    public void cancelApplication(@PathVariable Long id) {
        cancelApplicationService.execute(id);
    }

    @PutMapping("/{id}/reject")
    @Operation(summary = "신청 거절")
    public void rejectApplication(@PathVariable Long id) {
        rejectApplicationService.execute(id);
    }

    @GetMapping("/project/{id}")
    @Operation(summary = "프로젝트에 신청한 모든 유저 조회")
    public ResponseEntity<List<ApplicationResponse>> findProjectApplication(@PathVariable Long id) {
        return ResponseEntity.ok(findProjectApplicationService.execute(id));
    }

    @GetMapping("/{id}")
    @Operation(summary = "신청 하나 조회")
    public ResponseEntity<ApplicationResponse> findOneApplication(@PathVariable Long id) {
        return ResponseEntity.ok(findApplicationService.execute(id));
    }
}
