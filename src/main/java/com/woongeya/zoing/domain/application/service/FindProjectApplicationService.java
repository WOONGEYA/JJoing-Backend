package com.woongeya.zoing.domain.application.service;

import com.woongeya.zoing.domain.application.domain.Application;
import com.woongeya.zoing.domain.application.domain.repository.ApplicationRepository;
import com.woongeya.zoing.domain.application.presetation.dto.response.ApplicationResponseDto;
import com.woongeya.zoing.domain.project.domain.Member;
import com.woongeya.zoing.domain.project.domain.repository.CustomMemberRepository;
import com.woongeya.zoing.domain.project.exception.IsNotWriterException;
import com.woongeya.zoing.domain.project.exception.MemberNotFoundException;
import com.woongeya.zoing.domain.user.UserFacade;
import com.woongeya.zoing.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FindProjectApplicationService {

    private final ApplicationRepository applicationRepository;
    private final CustomMemberRepository customMemberRepository;
    private final UserFacade userFacade;

    @Transactional(readOnly = true)
    public List<ApplicationResponseDto> execute(Long id) {
        User user = userFacade.getCurrentUser();
        Member member = customMemberRepository.findByUserIdAndProjectId(user.getId(), id)
                .orElseThrow(() -> MemberNotFoundException.EXCEPTION);

        if (!member.isWriter()) {
            throw new IsNotWriterException();
        }

        List<Application> applications = applicationRepository.findByProjectId(id);
        Map<User, Application> applicationMap = applications.stream().collect(
                Collectors.toMap(
                        application -> userFacade.getUserById(application.getUserId()),
                        application -> application
                )
        );

        return applicationMap.entrySet().stream()
                .map(entry -> new ApplicationResponseDto(entry.getValue().getId() ,entry.getValue().getIntroduce(), entry.getKey().getName(), entry.getValue().getPosition()))
                .collect(Collectors.toList());
    }
}
