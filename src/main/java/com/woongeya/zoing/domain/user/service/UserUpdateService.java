package com.woongeya.zoing.domain.user.service;

import com.woongeya.zoing.domain.user.UserFacade;
import com.woongeya.zoing.domain.user.domain.User;
import com.woongeya.zoing.domain.user.presetation.dto.request.UpdateUserRequestDto;
import com.woongeya.zoing.infrastructure.s3.service.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.woongeya.zoing.domain.user.domain.repository.UserRepository;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class UserUpdateService {

    private final UserFacade userFacade;
    private final UserRepository userRepository;
    private final S3Service s3Service;

    @Transactional
    public void execute(MultipartFile image, UpdateUserRequestDto request) {
        User user = userFacade.getCurrentUser();
        String imgUrl = s3Service.uploadImage(image);
        user.updateInfo(request, imgUrl);

        userRepository.save(user);
    }
}
