package com.woongeya.zoing.domain.user.service;

import com.woongeya.zoing.domain.project.presetation.dto.response.ImageResponseDto;
import com.woongeya.zoing.domain.user.UserFacade;
import com.woongeya.zoing.domain.user.domain.User;
import com.woongeya.zoing.infrastructure.s3.service.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class UploadProfileImageService {

    private final S3Service s3Service;
    private final UserFacade userFacade;

    @Transactional
    public ImageResponseDto execute(MultipartFile file) {
        User user = userFacade.getCurrentUser();
        String imgUrl = s3Service.uploadImage(file);
        user.updateImage(imgUrl);

        return new ImageResponseDto(imgUrl);
    }
}
