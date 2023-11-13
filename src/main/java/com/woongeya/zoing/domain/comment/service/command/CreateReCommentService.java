package com.woongeya.zoing.domain.comment.service.command;

import com.woongeya.zoing.domain.comment.domain.Comment;
import com.woongeya.zoing.domain.comment.domain.ReComment;
import com.woongeya.zoing.domain.comment.domain.repository.CommentRepository;
import com.woongeya.zoing.domain.comment.domain.repository.ReCommentRepository;
import com.woongeya.zoing.domain.comment.exception.CommentNotFoundException;
import com.woongeya.zoing.domain.comment.presetation.dto.request.CreateCommentRequest;
import com.woongeya.zoing.domain.user.UserFacade;
import com.woongeya.zoing.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CreateReCommentService {

    private final UserFacade userFacade;
    private final CommentRepository commentRepository;
    private final ReCommentRepository reCommentRepository;

    public void execute(Long id, CreateCommentRequest request) {
        User user = userFacade.getCurrentUser();
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> CommentNotFoundException.EXCEPTION);
        reCommentRepository.save(
                new ReComment(request.getContent(), id, user.getId())
        );
        comment.increaseReCommentCount();
    }
}
