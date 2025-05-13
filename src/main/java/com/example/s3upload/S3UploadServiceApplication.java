package com.example.s3upload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class S3UploadServiceApplication {

  public static void main(final String[] args) {
    SpringApplication.run(S3UploadServiceApplication.class, args);
  }
}