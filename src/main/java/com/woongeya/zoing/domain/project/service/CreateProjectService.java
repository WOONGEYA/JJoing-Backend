package com.woongeya.zoing.domain.project.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woongeya.zoing.domain.project.domain.Coop;
import com.woongeya.zoing.domain.project.domain.Member;
import com.woongeya.zoing.domain.project.domain.Mood;
import com.woongeya.zoing.domain.project.domain.Position;
import com.woongeya.zoing.domain.project.domain.Project;
import com.woongeya.zoing.domain.project.domain.Skill;
import com.woongeya.zoing.domain.project.domain.repository.CoopRepository;
import com.woongeya.zoing.domain.project.domain.repository.MemberRepository;
import com.woongeya.zoing.domain.project.domain.repository.MoodRepository;
import com.woongeya.zoing.domain.project.domain.repository.PositionRepository;
import com.woongeya.zoing.domain.project.domain.repository.ProjectRepository;
import com.woongeya.zoing.domain.project.domain.repository.SkillRepository;
import com.woongeya.zoing.domain.project.domain.type.Role;
import com.woongeya.zoing.domain.project.presetation.dto.request.CreateProjectRequestDto;
import com.woongeya.zoing.domain.user.UserFacade;
import com.woongeya.zoing.domain.user.domain.User;

import lombok.RequiredArgsConstructor;

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
        Project project = projectRepository.save(request.toEntity());

        saveMoods(project, request.moods());
        savePositions(project, request.positions());
        saveCoops(project, request.coops());
        saveSkills(project, request.skills());
        saveMember(project, user);
    }

    private void saveMember(Project project, User user) {
        memberRepository.save(
            Member.builder()
                .project(project)
                .role(Role.WRITER)
                .userId(user.getId())
                .build()
        );
    }

    private void saveMoods(Project project, List<String> moods) {
        moods.forEach(mood -> moodRepository.save(
                Mood.builder()
                        .type(mood)
                        .project(project)
                        .build()
        ));
    }

    private void savePositions(Project project, List<String> positions) {
        positions.forEach(position -> positionRepository.save(
                Position.builder()
                        .name(position)
                        .project(project)
                        .build()
        ));
    }

    private void saveCoops(Project project, List<String> tools) {
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
