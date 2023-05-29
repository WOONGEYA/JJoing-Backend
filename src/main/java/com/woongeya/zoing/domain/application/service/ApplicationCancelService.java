package com.woongeya.zoing.domain.application.service;

import com.woongeya.zoing.domain.application.ApplicationFacade;
import com.woongeya.zoing.domain.application.domain.Application;
import com.woongeya.zoing.domain.project.exception.IsNotWriterException;
import com.woongeya.zoing.domain.user.UserFacade;
import com.woongeya.zoing.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ApplicationCancelService {

    private final UserFacade userFacade;
    private final ApplicationFacade applicationFacade;

    @Transactional
    public void execute(Long id) {
        Application application = applicationFacade.getApplication(id);
        User user = userFacade.getCurrentUser();

        if(!application.isWriter(user.getId())) {
            throw new IsNotWriterException();
        }

        application.cancel();
    }
}
