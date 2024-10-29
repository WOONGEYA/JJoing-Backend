package com.woongeya.zoing.domain.project.domain.fixture;

import java.time.LocalDate;

import com.woongeya.zoing.domain.project.domain.Project;
import com.woongeya.zoing.domain.project.domain.type.ProjectState;

public class ProjectFixture {

	public static Project 프로젝트() {
		return Project.builder()
			.name("쪼잉")
			.content("쪼잉으로 오세용")
			.imgUrl("iamge")
			.viewCount(0L)
			.state(ProjectState.FINDING)
			.requiredPeople(4)
			.currentPeople(1)
			.endDate(LocalDate.now())
			.build();
	}
}
