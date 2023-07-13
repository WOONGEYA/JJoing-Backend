package com.woongeya.zoing.domain.project.service;

import com.woongeya.zoing.domain.project.domain.Image;
import com.woongeya.zoing.domain.project.domain.Member;
import com.woongeya.zoing.domain.project.domain.Project;
import com.woongeya.zoing.domain.project.domain.repository.ImageRepository;
import com.woongeya.zoing.domain.project.domain.repository.MemberRepository;
import com.woongeya.zoing.domain.project.domain.repository.ProjectRepository;
import com.woongeya.zoing.domain.project.domain.type.ProjectState;
import com.woongeya.zoing.domain.project.domain.type.Role;
import com.woongeya.zoing.domain.project.presetation.dto.request.CreateProjectRequestDto;
import com.woongeya.zoing.domain.user.UserFacade;
import com.woongeya.zoing.domain.user.domain.User;
import com.woongeya.zoing.infrastructure.s3.exception.ImageNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CreateProjectService {

    private final ProjectRepository projectRepository;
    private final MemberRepository memberRepository;
    private final ImageRepository imageRepository;
    private final UserFacade userFacade;

    @Transactional
    public void execute(CreateProjectRequestDto request) {
        User user = userFacade.getCurrentUser();

        Project project = projectRepository.save(
                Project.builder()
                        .name(request.getName())
                        .content(request.getContent())
                        .state(ProjectState.FINDING)
                        .position(request.getPosition())
                        .build()
        );

        if (!request.getImgUrls().isEmpty()) {
            List<Image> images = request.getImgUrls().stream()
                    .map(url -> imageRepository.findByImgUrl(url)
                            .orElseThrow(() -> ImageNotFoundException.EXCEPTION))
                    .peek(image -> image.addProject(project))
                    .collect(Collectors.toList());
        }

        memberRepository.save(
                Member.builder()
                        .project(project)
                        .role(Role.WRITER)
                        .userId(user.getId())
                        .build());
        }

}
