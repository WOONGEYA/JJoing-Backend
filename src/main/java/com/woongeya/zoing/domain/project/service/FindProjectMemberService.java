package com.woongeya.zoing.domain.project.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.woongeya.zoing.domain.project.domain.Member;
import com.woongeya.zoing.domain.project.domain.Project;
import com.woongeya.zoing.domain.project.domain.repository.MemberRepository;
import com.woongeya.zoing.domain.project.facade.ProjectFacade;
import com.woongeya.zoing.domain.project.presetation.dto.response.MemberResponse;
import com.woongeya.zoing.domain.user.UserFacade;
import com.woongeya.zoing.domain.user.domain.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FindProjectMemberService {

    private final ProjectFacade projectFacade;
    private final UserFacade userFacade;
    private final MemberRepository memberRepository;

    public List<MemberResponse> execute(Long id) {
        Project project = projectFacade.getProject(id);
        List<Member> members = memberRepository.findByProjectId(project.getId());
        List<User> users = members.stream()
                .map(member -> userFacade.getUserById(member.getUserId()))
                .collect(Collectors.toList());

        return users.stream()
                .map(MemberResponse::from)
                .collect(Collectors.toList());
    }
}
