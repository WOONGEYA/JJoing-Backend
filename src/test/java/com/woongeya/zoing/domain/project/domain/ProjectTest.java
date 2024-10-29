package com.woongeya.zoing.domain.project.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import com.woongeya.zoing.domain.project.domain.type.ProjectState;

public class ProjectTest {

	@Test
	void 프로젝트_인원수가_다_찰_경우_모집이_마감된다() {
		// given
		Project 쪼잉 = Project.builder()
			.name("쪼잉")
			.requiredPeople(4)
			.currentPeople(4)
			.build();

		// when
		쪼잉.isFull();

		// then
		Assertions.assertThat(쪼잉.getState()).isEqualTo(ProjectState.FOUND);
	}
}
