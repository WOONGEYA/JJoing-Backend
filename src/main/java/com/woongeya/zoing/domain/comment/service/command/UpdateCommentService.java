package com.woongeya.zoing.domain.comment.service.command;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woongeya.zoing.domain.auth.repository.AuthRepository;
import com.woongeya.zoing.domain.comment.domain.Comment;
import com.woongeya.zoing.domain.comment.domain.repository.CommentRepository;
import com.woongeya.zoing.domain.comment.exception.CommentNotFoundException;
import com.woongeya.zoing.domain.comment.presetation.dto.request.CreateCommentRequest;
import com.woongeya.zoing.domain.project.exception.IsNotWriterException;
import com.woongeya.zoing.domain.user.domain.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class UpdateCommentService {

    private final AuthRepository authRepository;
    private final CommentRepository commentRepository;

    public void execute(Long id, CreateCommentRequest request) {
        User user = authRepository.getCurrentUser();
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> CommentNotFoundException.EXCEPTION);

        if(!comment.isWriter(user.getId())) {
            throw new IsNotWriterException();
        }
        comment.update(request);
    }
}
