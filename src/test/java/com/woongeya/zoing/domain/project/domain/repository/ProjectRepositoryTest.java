package com.woongeya.zoing.domain.project.domain.repository;

import static com.woongeya.zoing.domain.project.domain.fixture.ProjectFixture.*;
import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.woongeya.zoing.domain.project.domain.Project;
import com.woongeya.zoing.global.repository.RepositoryTest;

public class ProjectRepositoryTest extends RepositoryTest {

	@Autowired
	private ProjectRepository projectRepository;

	@Test
	void 모든_프로젝트를_조회할_수_있다() {
		// given
		Project 저장된_프로젝트1 = 프로젝트_저장(프로젝트());
		Project 저장된_프로젝트2 = 프로젝트_저장(프로젝트());

		// when
		List<Project> 조회된_프로젝트들 = projectRepository.findAll();

		// then
		assertThat(조회된_프로젝트들).contains(저장된_프로젝트1, 저장된_프로젝트2);
	}

	@Test
	void 아이디로_프로젝트를_조회할_수_있다() {
		// given
		Project 저장된_프로젝트 = 프로젝트_저장(프로젝트());
		Long 아이디 = 저장된_프로젝트.getId();

		// when
		Project 조회된_프로젝트 = projectRepository.findById(아이디).get();

		// then
		assertThat(조회된_프로젝트).isEqualTo(저장된_프로젝트);
	}

	@Test
	void 프로젝트를_삭제할_수_있다() {
		// given
		Project 저장된_프로젝트 = 프로젝트_저장(프로젝트());
		Long 아이디 = 저장된_프로젝트.getId();

		// when
		projectRepository.delete(저장된_프로젝트);

		// then
		assertThatThrownBy(() -> projectRepository.findById(아이디).get())
			.isInstanceOf(NoSuchElementException.class);
	}

	private Project 프로젝트_저장(Project project) {
		return projectRepository.save(project);
	}
}
