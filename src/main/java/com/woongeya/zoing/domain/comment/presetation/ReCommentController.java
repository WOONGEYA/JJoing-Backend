package com.woongeya.zoing.domain.comment.presetation;

import com.woongeya.zoing.domain.comment.presetation.dto.request.CreateCommentRequest;
import com.woongeya.zoing.domain.comment.service.command.CreateReCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/recomment")
public class ReCommentController {

    private final CreateReCommentService createReCommentService;

    @PostMapping("/{id}")
    public ResponseEntity<Void> create(@PathVariable Long id, @RequestBody CreateCommentRequest request) {
        createReCommentService.execute(id, request);
        return ResponseEntity.noContent().build();
    }
}
