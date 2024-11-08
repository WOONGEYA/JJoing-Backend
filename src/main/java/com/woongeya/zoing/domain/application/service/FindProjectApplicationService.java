package com.woongeya.zoing.domain.application.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woongeya.zoing.domain.application.domain.Application;
import com.woongeya.zoing.domain.application.domain.repository.ApplicationRepository;
import com.woongeya.zoing.domain.application.presetation.dto.response.ApplicationResponse;
import com.woongeya.zoing.domain.project.domain.Member;
import com.woongeya.zoing.domain.project.domain.repository.MemberRepository;
import com.woongeya.zoing.domain.project.exception.IsNotWriterException;
import com.woongeya.zoing.domain.project.exception.MemberNotFoundException;
import com.woongeya.zoing.domain.user.UserFacade;
import com.woongeya.zoing.domain.user.domain.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FindProjectApplicationService {

    private final ApplicationRepository applicationRepository;
    private final MemberRepository memberRepository;
    private final AuthRepository authRepository;

    @Transactional(readOnly = true)
    public List<ApplicationResponse> execute(Long id) {
        User user = authRepository.getCurrentUser();
        Member member = memberRepository.findByUserIdAndProjectId(user.getId(), id)
                .orElseThrow(() -> MemberNotFoundException.EXCEPTION);

        if (!member.isWriter()) {
            throw new IsNotWriterException();
        }

        List<Application> applications = applicationRepository.findByProjectId(id);
        return applications.stream()
                .map(application -> ApplicationResponse.of(application, userFacade.getUserById(application.getUserId())))
                .collect(Collectors.toList());
    }
}
