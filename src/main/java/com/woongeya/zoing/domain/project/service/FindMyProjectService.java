package com.woongeya.zoing.domain.project.service;

import com.woongeya.zoing.domain.like.domain.repository.LikeRepository;
import com.woongeya.zoing.domain.project.domain.Member;
import com.woongeya.zoing.domain.project.domain.Project;
import com.woongeya.zoing.domain.project.domain.repository.MemberRepository;
import com.woongeya.zoing.domain.project.domain.type.ProjectState;
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
    private final LikeRepository likeRepository;

    @Transactional(readOnly = true)
    public List<ProjectResponseDto> execute() {
        User user = userFacade.getCurrentUser();
        List<Member> members = memberRepository.findByUserId(user.getId());

        return members.stream()
                .map(Member::getProject)
                .filter(project -> project.getState().equals(ProjectState.FINDING))
                .map(project -> {
                    Integer likeCount = likeRepository.countByProjectId(project.getId());
                    return ProjectResponseDto.of(project, likeCount, checkLike(project, user));
                })
                .collect(Collectors.toList());
    }

    private boolean checkLike(Project project, User user){
        return likeRepository.existsByUserIdAndProjectId(user.getId(), project.getId());
    }
}
