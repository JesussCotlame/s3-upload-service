package com.example.s3upload.controller;

import com.example.s3upload.service.S3UploadService;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
@RequestMapping("/s3")
@RequiredArgsConstructor
public class S3Controller {

    private final S3UploadService uploaderService;

    @PostMapping("/upload")
    public ResponseEntity<String> upload(final @RequestParam MultipartFile file) throws IOException {
        final File tempFile = File.createTempFile("upload-", file.getOriginalFilename());
        file.transferTo(tempFile);

        uploaderService.upload(file.getOriginalFilename(), tempFile.toPath());
        return ResponseEntity.ok("Uploaded successfully");
    }
}
