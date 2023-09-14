package com.woongeya.zoing.domain.project.service;

import com.woongeya.zoing.domain.project.domain.*;
import com.woongeya.zoing.domain.project.domain.repository.*;
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

@Service
@RequiredArgsConstructor
public class CreateProjectService {

    private final ProjectRepository projectRepository;
    private final PositionRepository positionRepository;
    private final MemberRepository memberRepository;
    private final ImageRepository imageRepository;
    private final MoodRepository moodRepository;
    private final CoopRepository coopRepository;
    private final SkillRepository skillRepository;
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
                        .build()
        );

        saveMoods(project, request.getMoods());
        savePositions(project, request.getPositions());
        saveCoops(project, request.getCoops());
        saveSkills(project, request.getSkills());

        Image image = imageRepository.findByImgUrl(request.getImgUrl())
                .orElseThrow(() -> ImageNotFoundException.EXCEPTION);
        image.addProject(project);

        memberRepository.save(
                Member.builder()
                        .project(project)
                        .role(Role.WRITER)
                        .userId(user.getId())
                        .build()
        );
    }

    private void saveMoods(Project project, List<String> moods) {
        moods.stream()
                .map(mood -> moodRepository.save(
                        Mood.builder()
                                .type(mood)
                                .project(project)
                                .build()
                ));
    }

    private void savePositions(Project project, List<String> positions) {
        positions.stream()
                .map(position -> positionRepository.save(
                        Position.builder()
                                .name(position)
                                .project(project)
                                .build()));
    }

    private void saveCoops(Project project, List<String> tools) {
        tools.stream()
                .map(tool -> coopRepository.save(
                        Coop.builder()
                                .tool(tool)
                                .project(project)
                                .build()
                ));
    }

    private void saveSkills(Project project, List<String> skills) {
        skills.stream()
                .map(skill -> skillRepository.save(
                        Skill.builder()
                                .name(skill)
                                .project(project)
                                .build()
                ));
    }
}
