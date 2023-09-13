package com.woongeya.zoing.domain.project.service;

import com.woongeya.zoing.domain.project.domain.Member;
import com.woongeya.zoing.domain.project.domain.Position;
import com.woongeya.zoing.domain.project.domain.Project;
import com.woongeya.zoing.domain.project.domain.repository.ImageRepository;
import com.woongeya.zoing.domain.project.domain.repository.MemberRepository;
import com.woongeya.zoing.domain.project.domain.repository.PositionRepository;
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

@Service
@RequiredArgsConstructor
public class CreateProjectService {

    private final ProjectRepository projectRepository;
    private final PositionRepository positionRepository;
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
                        .endDate(request.getEndDate())
                        .requiredPeople(request.getRequiredPeople())
                        .currentPeople(0)
                        .viewCount(0L)
                        .state(ProjectState.FINDING)
                        .communicationTool(request.getCommunicationTool())
                        .moodType(request.getMoodType())
                        .skill(request.getSkill())
                        .build()
        );

        request.getPositionName().stream()
                .map(name -> positionRepository.save(
                        Position.builder()
                                .name(name)
                                .project(project)
                                .build()));

        if (!request.getImgUrls().isEmpty()) {
            request.getImgUrls().stream()
                    .map(url -> imageRepository.findByImgUrl(url)
                            .orElseThrow(() -> ImageNotFoundException.EXCEPTION))
                    .peek(image -> image.addProject(project));
        }

        memberRepository.save(
                Member.builder()
                        .project(project)
                        .role(Role.WRITER)
                        .userId(user.getId())
                        .build()
        );
    }
}
