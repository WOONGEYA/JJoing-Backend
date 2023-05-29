package com.woongeya.zoing.domain.application;

import com.woongeya.zoing.domain.application.domain.Application;
import com.woongeya.zoing.domain.application.domain.repository.ApplicationRepository;
import com.woongeya.zoing.domain.application.exception.ApplicationNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ApplicationFacade {

    private final ApplicationRepository applicationRepository;

    public Application getApplication(Long id) {
        return applicationRepository.findById(id).orElseThrow(() -> ApplicationNotFoundException.EXCEPTION);
    }
}
