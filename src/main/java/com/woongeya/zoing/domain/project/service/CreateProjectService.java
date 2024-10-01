package com.woongeya.zoing.domain.project.service;

import com.woongeya.zoing.domain.project.domain.*;
import com.woongeya.zoing.domain.project.domain.repository.*;
import com.woongeya.zoing.domain.project.domain.type.ProjectState;
import com.woongeya.zoing.domain.project.domain.type.Role;
import com.woongeya.zoing.domain.project.presetation.dto.request.CreateProjectRequestDto;
import com.woongeya.zoing.domain.user.UserFacade;
import com.woongeya.zoing.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CreateProjectService {

    private final ProjectRepository projectRepository;
    private final PositionRepository positionRepository;
    private final MemberRepository memberRepository;
    private final MoodRepository moodRepository;
    private final CoopRepository coopRepository;
    private final SkillRepository skillRepository;
    private final UserFacade userFacade;

    @Transactional
    public void execute(CreateProjectRequestDto request) {
        User user = userFacade.getCurrentUser();

        Project project = projectRepository.save(
                Project.builder()
                        .name(request.name())
                        .content(request.content())
                        .imgUrl(request.imgUrl())
                        .endDate(request.endDate())
                        .requiredPeople(request.requiredPeople())
                        .currentPeople(1)
                        .viewCount(0L)
                        .state(ProjectState.FINDING)
                        .build()
        );

        saveMoods(project, request.moods());
        savePositions(project, request.positions());
        saveCoops(project, request.coops());
        saveSkills(project, request.skills());

        memberRepository.save(
                Member.builder()
                        .project(project)
                        .role(Role.WRITER)
                        .userId(user.getId())
                        .build()
        );
    }

    public void saveMoods(Project project, List<String> moods) {
        System.out.println(moods);
        System.out.println(project.getName());

        moods.forEach(mood -> moodRepository.save(
                Mood.builder()
                        .type(mood)
                        .project(project)
                        .build()
        ));
    }

    public void savePositions(Project project, List<String> positions) {
        positions.forEach(position -> positionRepository.save(
                Position.builder()
                        .name(position)
                        .project(project)
                        .build()
        ));
    }

    public void saveCoops(Project project, List<String> tools) {
        tools.forEach(tool -> coopRepository.save(
                Coop.builder()
                        .tool(tool)
                        .project(project)
                        .build()
        ));
    }

    private void saveSkills(Project project, List<String> skills) {
        skills.forEach(skill -> skillRepository.save(
                Skill.builder()
                        .name(skill)
                        .project(project)
                        .build()
        ));
    }
}
