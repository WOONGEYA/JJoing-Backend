package com.woongeya.zoing.domain.application.domain.repository;

import com.woongeya.zoing.domain.application.domain.Application;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

    List<Application> findByUserId(Long id);
    List<Application> findByProjectId(Long id);
    Optional<Application> findByUserIdAndProjectId(Long userId, Long projectId);
    void deleteByProjectId(Long id);
}
