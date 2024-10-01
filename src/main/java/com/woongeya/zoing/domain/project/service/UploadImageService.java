package com.woongeya.zoing.domain.project.service;

import com.woongeya.zoing.domain.project.presetation.dto.response.ImageResponseDto;
import com.woongeya.zoing.infrastructure.s3.service.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class UploadImageService {

    private final S3Service s3Service;

    @Transactional
    public ImageResponseDto execute(MultipartFile file) {
        String image = s3Service.uploadImage(file);

        return ImageResponseDto.from(image);
    }
}
