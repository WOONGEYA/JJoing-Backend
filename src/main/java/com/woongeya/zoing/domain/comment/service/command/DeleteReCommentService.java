package com.woongeya.zoing.domain.comment.service.command;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woongeya.zoing.domain.auth.repository.AuthRepository;
import com.woongeya.zoing.domain.comment.domain.Comment;
import com.woongeya.zoing.domain.comment.domain.ReComment;
import com.woongeya.zoing.domain.comment.domain.repository.CommentRepository;
import com.woongeya.zoing.domain.comment.domain.repository.ReCommentRepository;
import com.woongeya.zoing.domain.comment.exception.CommentNotFoundException;
import com.woongeya.zoing.domain.comment.exception.ReCommentNotFoundException;
import com.woongeya.zoing.domain.project.exception.IsNotWriterException;
import com.woongeya.zoing.domain.user.domain.User;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class DeleteReCommentService {

    private final AuthRepository authRepository;
    private final CommentRepository commentRepository;
    private final ReCommentRepository reCommentRepository;

    public void execute(Long id) {
        User user = authRepository.getCurrentUser();
        ReComment reComment = reCommentRepository.findById(id)
                .orElseThrow(() -> ReCommentNotFoundException.EXCEPTION);

        if(!reComment.isWriter(user.getId())) {
            throw new IsNotWriterException();
        }

        Comment comment = commentRepository.findById(reComment.getCommentId())
                .orElseThrow(() -> CommentNotFoundException.EXCEPTION);
        reCommentRepository.delete(reComment);
        comment.decreaseReCommentCount();
    }
}
