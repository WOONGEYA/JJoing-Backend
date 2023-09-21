package com.woongeya.zoing.domain.notice.presetation;

import com.woongeya.zoing.domain.notice.presetation.dto.response.NotificationResponse;
import com.woongeya.zoing.domain.notice.service.DeleteNotificationService;
import com.woongeya.zoing.domain.notice.service.FindNotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notification")
public class NotificationController {

    private final FindNotificationService findNotificationService;
    private final DeleteNotificationService deleteNotificationService;

    @GetMapping()
    public ResponseEntity<List<NotificationResponse>> findNotification() {
        return ResponseEntity.ok(findNotificationService.execute());
    }

    @DeleteMapping("/{id}")
    public void deleteNotification(@PathVariable Long id) {
        deleteNotificationService.execute(id);
    }
}
