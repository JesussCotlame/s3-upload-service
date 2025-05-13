package com.example.s3upload.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "aws.s3")
public record S3Properties(
    String bucketName,
    String region,
    String accessKey,
    String secretKey,
    String localEndpoint,
    String realEndpoint
) {}