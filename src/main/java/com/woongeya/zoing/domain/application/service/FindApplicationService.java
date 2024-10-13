package com.woongeya.zoing.domain.application.service;

import com.woongeya.zoing.domain.application.ApplicationFacade;
import com.woongeya.zoing.domain.application.domain.Application;
import com.woongeya.zoing.domain.application.presetation.dto.response.ApplicationResponse;
import com.woongeya.zoing.domain.user.UserFacade;
import com.woongeya.zoing.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindApplicationService {

    private final ApplicationFacade applicationFacade;
    private final UserFacade userFacade;

    public ApplicationResponse execute(Long id) {
        Application application = applicationFacade.getApplication(id);
        User user = userFacade.getUserById(application.getUserId());

        return ApplicationResponse.of(application, user);
    }
}
