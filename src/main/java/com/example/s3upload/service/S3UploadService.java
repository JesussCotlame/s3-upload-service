package com.example.s3upload.service;

import com.example.s3upload.properties.S3Properties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.nio.file.Path;

@Service
@RequiredArgsConstructor
public class S3UploadService {

    private final S3Client s3Client;
    private final S3Properties s3Properties;

    public void upload(final String key, final Path filePath) {
        final PutObjectRequest request = PutObjectRequest.builder()
            .bucket(s3Properties.bucketName())
            .key(key)
            .build();

        s3Client.putObject(request, RequestBody.fromFile(filePath));
    }
}
