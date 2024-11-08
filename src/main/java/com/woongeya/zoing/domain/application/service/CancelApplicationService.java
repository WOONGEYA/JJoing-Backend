package com.woongeya.zoing.domain.application.service;

import com.woongeya.zoing.domain.application.ApplicationFacade;
import com.woongeya.zoing.domain.application.domain.Application;
import com.woongeya.zoing.domain.auth.repository.AuthRepository;
import com.woongeya.zoing.domain.project.exception.IsNotWriterException;
import com.woongeya.zoing.domain.user.UserFacade;
import com.woongeya.zoing.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CancelApplicationService {

    private final AuthRepository authRepository;
    private final ApplicationFacade applicationFacade;

    @Transactional
    public void execute(Long id) {
        Application application = applicationFacade.getApplication(id);
        User user = authRepository.getCurrentUser();

        if(!application.isWriter(user)) {
            throw new IsNotWriterException();
        }

        application.cancel();
    }
}
