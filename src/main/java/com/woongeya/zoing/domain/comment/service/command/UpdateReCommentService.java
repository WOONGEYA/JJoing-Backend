package com.woongeya.zoing.domain.comment.service.command;

import com.woongeya.zoing.domain.comment.domain.ReComment;
import com.woongeya.zoing.domain.comment.domain.repository.ReCommentRepository;
import com.woongeya.zoing.domain.comment.exception.ReCommentNotFoundException;
import com.woongeya.zoing.domain.comment.presetation.dto.request.CreateCommentRequest;
import com.woongeya.zoing.domain.project.exception.IsNotWriterException;
import com.woongeya.zoing.domain.user.UserFacade;
import com.woongeya.zoing.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UpdateReCommentService {

    private final UserFacade userFacade;
    private final ReCommentRepository reCommentRepository;

    public void execute(Long id, CreateCommentRequest request) {
        User user = userFacade.getCurrentUser();
        ReComment reComment = reCommentRepository.findById(id)
                .orElseThrow(() -> ReCommentNotFoundException.EXCEPTION);

        if(!reComment.isWriter(user.getId())) {
            throw new IsNotWriterException();
        }

        reComment.update(request);
    }
}
