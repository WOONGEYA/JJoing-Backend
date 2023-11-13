package com.woongeya.zoing.domain.comment.presetation;

import com.woongeya.zoing.domain.comment.presetation.dto.request.CreateCommentRequest;
import com.woongeya.zoing.domain.comment.presetation.dto.response.ReCommentResponse;
import com.woongeya.zoing.domain.comment.service.command.CreateReCommentService;
import com.woongeya.zoing.domain.comment.service.query.QueryReCommentListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/recomment")
public class ReCommentController {

    private final CreateReCommentService createReCommentService;
    private final QueryReCommentListService queryReCommentListService;

    @PostMapping("/{id}")
    public ResponseEntity<Void> create(@PathVariable Long id, @RequestBody CreateCommentRequest request) {
        createReCommentService.execute(id, request);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<ReCommentResponse>> findAll(@PathVariable Long id) {
        return ResponseEntity.ok(queryReCommentListService.execute(id));
    }
}
