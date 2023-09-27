package com.woongeya.zoing.domain.project.service;

import com.woongeya.zoing.domain.project.domain.*;
import com.woongeya.zoing.domain.project.domain.repository.CoopRepository;
import com.woongeya.zoing.domain.project.domain.repository.MoodRepository;
import com.woongeya.zoing.domain.project.domain.repository.PositionRepository;
import com.woongeya.zoing.domain.project.domain.repository.SkillRepository;
import com.woongeya.zoing.domain.project.facade.ProjectFacade;
import com.woongeya.zoing.domain.project.presetation.dto.response.ProjectInfoResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FindProjectInfoService {

    private final ProjectFacade projectFacade;
    private final CoopRepository coopRepository;
    private final MoodRepository moodRepository;
    private final SkillRepository skillRepository;
    private final PositionRepository positionRepository;

    @Transactional
    public ProjectInfoResponseDto execute(Long id) {
        Project project = projectFacade.getProject(id);
        List<String> coops = getCoops(project);
        List<String> moods = getMoods(project);
        List<String> positions = getPositions(project);
        List<String> skills = getSkills(project);

        project.increaseViewCnt();

        return new ProjectInfoResponseDto(project, moods, skills, coops, positions);
    }

    private List<String> getSkills(Project project) {
        List<Skill> skills = skillRepository.findByProjectId(project.getId());
        return skills.stream()
                .map(Skill::getName)
                .collect(Collectors.toList());
    }

    private List<String> getPositions(Project project) {
        List<Position> positions = positionRepository.findByProjectId(project.getId());
        return positions.stream()
                .map(Position::getName)
                .collect(Collectors.toList());
    }

    private List<String> getMoods(Project project) {
        List<Mood> moods = moodRepository.findByProjectId(project.getId());
        return moods.stream()
                .map(Mood::getType)
                .collect(Collectors.toList());
    }

    private List<String> getCoops(Project project) {
        List<Coop> coops = coopRepository.findByProjectId(project.getId());
        return coops.stream()
                .map(Coop::getTool)
                .collect(Collectors.toList());
    }
}
