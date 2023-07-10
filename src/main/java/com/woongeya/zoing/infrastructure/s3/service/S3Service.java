package com.woongeya.zoing.infrastructure.s3.service;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.woongeya.zoing.infrastructure.s3.config.S3Properties;
import com.woongeya.zoing.infrastructure.s3.exception.ImageFailedSaveException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class S3Service {

    private final S3Properties s3Properties;
    private final AmazonS3Client amazonS3Client;

    public String uploadImage(MultipartFile image) {
        String file = createFile(image.getOriginalFilename());

        try {
            PutObjectRequest request = new PutObjectRequest(
                    s3Properties.getBucket(), file, image.getInputStream(), getMetadata(image)
            );
            // 저장
            amazonS3Client.putObject(request);
        }  catch (IOException e) {
            throw new ImageFailedSaveException();
        }

        return amazonS3Client.getUrl(s3Properties.getBucket(), file).toString();
    }

    private String createFile(String image) {
        return UUID.randomUUID() + "-" + image;
    }

    private ObjectMetadata getMetadata(MultipartFile file) {
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(file.getSize());
        metadata.setContentType(file.getContentType());
        return metadata;
    }
}
