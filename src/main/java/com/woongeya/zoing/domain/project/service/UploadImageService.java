package com.woongeya.zoing.domain.project.service;

import com.woongeya.zoing.domain.project.domain.Image;
import com.woongeya.zoing.domain.project.domain.repository.ImageRepository;
import com.woongeya.zoing.domain.project.presetation.dto.response.ImageResponseDto;
import com.woongeya.zoing.infrastructure.s3.service.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UploadImageService {

    private final S3Service s3Service;
    private final ImageRepository imageRepository;

    @Transactional
    public ImageResponseDto execute(MultipartFile file) {
        String image = s3Service.uploadImage(file);
        imageRepository.save(
                Image.builder()
                        .imgUrl(image)
                        .build()
        );

        return new ImageResponseDto(image);
    }
}
