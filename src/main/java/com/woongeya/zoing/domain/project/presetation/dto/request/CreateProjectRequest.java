package com.woongeya.zoing.domain.project.presetation.dto.request;

import java.time.LocalDate;
import java.util.List;

import com.woongeya.zoing.domain.project.domain.Project;
import com.woongeya.zoing.domain.project.domain.type.ProjectState;

import jakarta.validation.constraints.NotNull;

public record CreateProjectRequest(
    @NotNull String name,
    @NotNull String content,
    @NotNull Integer requiredPeople,
    @NotNull LocalDate endDate,
    String imgUrl,
    List<String> skills,
    List<String> coops,
    List<String> moods,
    List<String> positions
) {

	public Project toEntity() {
		return Project.builder()
			.name(name)
			.content(content)
			.requiredPeople(requiredPeople)
			.endDate(endDate)
			.imgUrl(imgUrl)
			.currentPeople(1)
			.state(ProjectState.FINDING)
			.build();
	}
}
