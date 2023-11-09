package com.woongeya.zoing.domain.post.service.command;

import com.woongeya.zoing.domain.post.domain.repository.PostRepository;
import com.woongeya.zoing.domain.post.exception.PostNotFoundException;
import com.woongeya.zoing.domain.user.UserFacade;
import com.woongeya.zoing.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class DeletePostService {

    private final UserFacade userFacade;
    private final PostRepository postRepository;

    public void execute(Long id) {
        User user = userFacade.getCurrentUser();
        postRepository.deleteById(id);
    }
}
