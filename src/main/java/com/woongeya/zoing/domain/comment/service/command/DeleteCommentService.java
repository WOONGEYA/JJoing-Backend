package com.woongeya.zoing.domain.comment.service.command;

import com.woongeya.zoing.domain.comment.domain.Comment;
import com.woongeya.zoing.domain.comment.domain.repository.CommentRepository;
import com.woongeya.zoing.domain.comment.exception.CommentNotFoundException;
import com.woongeya.zoing.domain.post.domain.Post;
import com.woongeya.zoing.domain.post.domain.repository.PostRepository;
import com.woongeya.zoing.domain.post.exception.PostNotFoundException;
import com.woongeya.zoing.domain.project.exception.IsNotWriterException;
import com.woongeya.zoing.domain.user.UserFacade;
import com.woongeya.zoing.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@RequiredArgsConstructor
public class DeleteCommentService {

    private final UserFacade userFacade;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    public void execute(Long id) {
        User user = userFacade.getCurrentUser();
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> CommentNotFoundException.EXCEPTION);

        if(!comment.isWriter(user.getId())) {
            throw new IsNotWriterException();
        }

        Post post = postRepository.findById(comment.getPostId())
                .orElseThrow(() -> PostNotFoundException.EXCEPTION);
        commentRepository.delete(comment);
        post.decreaseCommentCount();
    }
}
