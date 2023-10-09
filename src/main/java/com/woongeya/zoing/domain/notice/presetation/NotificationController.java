package com.woongeya.zoing.domain.notice.presetation;

import com.woongeya.zoing.domain.notice.presetation.dto.response.NotificationResponse;
import com.woongeya.zoing.domain.notice.service.CountNotificationService;
import com.woongeya.zoing.domain.notice.service.DeleteAllNotificationService;
import com.woongeya.zoing.domain.notice.service.DeleteNotificationService;
import com.woongeya.zoing.domain.notice.service.FindNotificationService;
import io.swagger.v3.oas.annotations.Operation;
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
    private final DeleteAllNotificationService deleteAllNotificationService;
    private final CountNotificationService countNotificationService;

    @GetMapping()
    @Operation(summary = "현재 로그인 된 유저 알림 전체 조회")
    public ResponseEntity<List<NotificationResponse>> findNotification() {
        return ResponseEntity.ok(findNotificationService.execute());
    }

    @GetMapping("/count")
    @Operation(summary = "알람 갯수 조회")
    public Long countNotification() {
        return countNotificationService.execute();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "알람 하나 삭제")
    public void deleteNotification(@PathVariable Long id) {
        deleteNotificationService.execute(id);
    }

    @DeleteMapping()
    @Operation(summary = "알람 전체 삭제")
    public void deleteAll() {
        deleteAllNotificationService.execute();
    }
}
