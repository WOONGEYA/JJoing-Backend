package com.woongeya.zoing.domain.project.service;

import com.woongeya.zoing.domain.auth.repository.AuthRepository;
import com.woongeya.zoing.domain.project.domain.*;
import com.woongeya.zoing.domain.project.domain.repository.*;
import com.woongeya.zoing.domain.project.exception.IsNotWriterException;
import com.woongeya.zoing.domain.project.exception.MemberNotFoundException;
import com.woongeya.zoing.domain.project.facade.ProjectFacade;
import com.woongeya.zoing.domain.project.presetation.dto.request.CreateProjectRequest;
import com.woongeya.zoing.domain.user.UserFacade;
import com.woongeya.zoing.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UpdateProjectService {

    private final MemberRepository memberRepository;
    private final ProjectFacade projectFacade;
    private final AuthRepository authRepository;
    private final PositionRepository positionRepository;
    private final MoodRepository moodRepository;
    private final CoopRepository coopRepository;
    private final SkillRepository skillRepository;

    @Transactional
    public void execute(Long id, CreateProjectRequest request) {
        Project project = projectFacade.getProject(id);
        User user = authRepository.getCurrentUser();

        Member member = memberRepository.findByUserIdAndProjectId(user.getId(), project.getId())
                .orElseThrow(() -> MemberNotFoundException.EXCEPTION);

        if (!checkMember(member)) {
            throw new IsNotWriterException();
        }

        positionRepository.deleteByProjectId(project.getId());
        moodRepository.deleteByProjectId(project.getId());
        coopRepository.deleteByProjectId(project.getId());
        skillRepository.deleteByProjectId(project.getId());
        updateMoods(project, request.moods());
        updatePositions(project, request.positions());
        updateCoops(project, request.coops());
        updateSkills(project, request.skills());

        project.update(request);
    }

    private boolean checkMember(Member member) {
        return member.isWriter();
    }

    private void updateMoods(Project project, List<String> moods) {
        moods.stream()
                .map(mood -> moodRepository.save(
                        Mood.builder()
                                .type(mood)
                                .project(project)
                                .build()
                )).collect(Collectors.toList());
    }

    private void updatePositions(Project project, List<String> positions) {
        positions.stream()
                .map(position -> positionRepository.save(
                        Position.builder()
                                .name(position)
                                .project(project)
                                .build()
                )).collect(Collectors.toList());
    }

    private void updateCoops(Project project, List<String> tools) {
        tools.stream()
                .map(tool -> coopRepository.save(
                        Coop.builder()
                                .tool(tool)
                                .project(project)
                                .build()
                )).collect(Collectors.toList());
    }

    private void updateSkills(Project project, List<String> skills) {
        skills.stream()
                .map(skill -> skillRepository.save(
                        Skill.builder()
                                .name(skill)
                                .project(project)
                                .build()
                )).collect(Collectors.toList());
    }
}
