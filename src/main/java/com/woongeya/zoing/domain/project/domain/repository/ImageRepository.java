package com.woongeya.zoing.domain.project.domain.repository;

import com.woongeya.zoing.domain.project.domain.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
