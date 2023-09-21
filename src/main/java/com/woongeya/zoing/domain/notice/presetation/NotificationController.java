package com.woongeya.zoing.domain.notice.presetation;

import com.woongeya.zoing.domain.notice.presetation.dto.response.NotificationResponse;
import com.woongeya.zoing.domain.notice.service.FindNotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notification")
public class NotificationController {

    private final FindNotificationService findNotificationService;

    @GetMapping()
    public ResponseEntity<List<NotificationResponse>> findNotification() {
        return ResponseEntity.ok(findNotificationService.execute());
    }
}
