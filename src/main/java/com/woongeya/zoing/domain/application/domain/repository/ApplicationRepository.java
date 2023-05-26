package com.woongeya.zoing.domain.application.domain.repository;

import com.woongeya.zoing.domain.application.domain.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
}
