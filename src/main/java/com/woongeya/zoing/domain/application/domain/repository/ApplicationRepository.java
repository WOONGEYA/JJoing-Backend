package com.woongeya.zoing.domain.application.domain.repository;

import com.woongeya.zoing.domain.application.domain.Application;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

    List<Application> findByUserId(Long id);
}
