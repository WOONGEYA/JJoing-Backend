package com.woongeya.zoing.domain.user.service;

import com.woongeya.zoing.domain.project.presetation.dto.response.ImageResponse;
import com.woongeya.zoing.infrastructure.s3.service.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class UploadProfileImageService {

    private final S3Service s3Service;

    @Transactional
    public ImageResponse execute(MultipartFile file) {
        String imgUrl = s3Service.uploadImage(file);

        return ImageResponse.from(imgUrl);
    }
}
