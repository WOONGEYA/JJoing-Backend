package com.woongeya.zoing.domain.comment.presetation;

import com.woongeya.zoing.domain.comment.presetation.dto.request.CreateCommentRequest;
import com.woongeya.zoing.domain.comment.presetation.dto.response.ReCommentResponse;
import com.woongeya.zoing.domain.comment.service.command.CreateReCommentService;
import com.woongeya.zoing.domain.comment.service.command.DeleteReCommentService;
import com.woongeya.zoing.domain.comment.service.command.UpdateReCommentService;
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
    private final DeleteReCommentService deleteReCommentService;
    private final UpdateReCommentService updateReCommentService;

    @PostMapping("/{id}")
    public ResponseEntity<Void> create(@PathVariable Long id, @RequestBody CreateCommentRequest request) {
        createReCommentService.execute(id, request);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<ReCommentResponse>> findAll(@PathVariable Long id) {
        return ResponseEntity.ok(queryReCommentListService.execute(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        deleteReCommentService.execute(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody CreateCommentRequest request) {
        updateReCommentService.execute(id, request);
        return ResponseEntity.noContent().build();
    }
}
