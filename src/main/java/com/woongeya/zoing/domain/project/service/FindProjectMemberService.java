package com.woongeya.zoing.domain.project.service;

import com.woongeya.zoing.domain.project.domain.Member;
import com.woongeya.zoing.domain.project.domain.Project;
import com.woongeya.zoing.domain.project.domain.repository.MemberRepository;
import com.woongeya.zoing.domain.project.facade.ProjectFacade;
import com.woongeya.zoing.domain.project.presetation.dto.response.MemberResponseDto;
import com.woongeya.zoing.domain.user.UserFacade;
import com.woongeya.zoing.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FindProjectMemberService {

    private final ProjectFacade projectFacade;
    private final UserFacade userFacade;
    private final MemberRepository memberRepository;

    public List<MemberResponseDto> execute(Long id) {
        Project project = projectFacade.getProject(id);
        List<Member> members = memberRepository.findByProjectId(project.getId());
        List<User> users = members.stream()
                .map(member -> userFacade.getUserById(member.getId()))
                .collect(Collectors.toList());

        return users.stream()
                .map(MemberResponseDto::of)
                .collect(Collectors.toList());
    }
}
