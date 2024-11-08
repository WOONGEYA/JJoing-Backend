package com.woongeya.zoing.domain.comment.service.query;

import com.woongeya.zoing.domain.comment.domain.ReComment;
import com.woongeya.zoing.domain.comment.domain.repository.ReCommentRepository;
import com.woongeya.zoing.domain.comment.presetation.dto.response.ReCommentResponse;
import com.woongeya.zoing.domain.user.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class QueryReCommentListService {

    private final AuthRepository authRepository;
    private final ReCommentRepository reCommentRepository;

    public List<ReCommentResponse> execute(Long id) {
        List<ReComment> reComments = reCommentRepository.findByCommentId(id);

        return reComments.stream()
                .map(reComment -> ReCommentResponse.of(reComment, userFacade.getUserById(reComment.getUserId())))
                .collect(Collectors.toList());
    }
}
