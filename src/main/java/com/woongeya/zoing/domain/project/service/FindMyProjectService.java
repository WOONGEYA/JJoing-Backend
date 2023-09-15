package com.woongeya.zoing.domain.project.service;

import com.woongeya.zoing.domain.project.domain.Member;
import com.woongeya.zoing.domain.project.domain.repository.MemberRepository;
import com.woongeya.zoing.domain.project.presetation.dto.response.ProjectResponseDto;
import com.woongeya.zoing.domain.user.UserFacade;
import com.woongeya.zoing.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FindMyProjectService {

    private final UserFacade userFacade;
    private final MemberRepository memberRepository;

    @Transactional(readOnly = true)
    public List<ProjectResponseDto> execute() {
        User user = userFacade.getCurrentUser();
        List<Member> members = memberRepository.findByUserId(user.getId());

        return members.stream()
                .map(Member::getProject)
                .map(ProjectResponseDto::of)
                .collect(Collectors.toList());
    }
}
