package com.woongeya.zoing.domain.project.service;

import com.woongeya.zoing.domain.application.ApplicationFacade;
import com.woongeya.zoing.domain.application.domain.Application;
import com.woongeya.zoing.domain.project.domain.Member;
import com.woongeya.zoing.domain.project.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CheckMemberService {

    private final MemberRepository memberRepository;
    private final ApplicationFacade applicationFacade;

    public Boolean execute(Long id) {
        Application application = applicationFacade.getApplication(id);
        Optional<Member> member = memberRepository.findByUserIdAndProjectId(application.getUserId(), application.getProjectId());

        return member.isPresent();
    }
}
