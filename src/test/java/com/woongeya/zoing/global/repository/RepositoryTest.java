package com.woongeya.zoing.global.repository;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import com.woongeya.zoing.global.config.JpaConfig;
import com.woongeya.zoing.global.config.QueryDslTestConfig;

@DataJpaTest
@Import({JpaConfig.class, QueryDslTestConfig.class})
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public abstract class RepositoryTest {
}
