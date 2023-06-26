package com.woongeya.zoing.domain.application.service;

import com.woongeya.zoing.domain.application.ApplicationFacade;
import com.woongeya.zoing.domain.application.domain.Application;
import com.woongeya.zoing.domain.project.domain.Member;
import com.woongeya.zoing.domain.project.domain.repository.CustomMemberRepository;
import com.woongeya.zoing.domain.project.exception.MemberNotFoundException;
import com.woongeya.zoing.domain.user.UserFacade;
import com.woongeya.zoing.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RejectApplicationService {

    private final UserFacade userFacade;
    private final ApplicationFacade applicationFacade;
    private final CustomMemberRepository customMemberRepository;

    @Transactional
    public void execute(Long id) {
        User user = userFacade.getCurrentUser();
        Application application = applicationFacade.getApplication(id);
        Member member = customMemberRepository.findByUserIdAndProjectId(user.getId(), application.getProjectId())
                .orElseThrow(() -> MemberNotFoundException.EXCEPTION);

        member.rejectApplication(application);
    }
}
