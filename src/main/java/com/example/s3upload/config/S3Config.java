package com.example.s3upload.config;

import com.example.s3upload.properties.AwsProperties;
import com.example.s3upload.properties.S3Properties;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

import java.net.URI;

@Configuration
@RequiredArgsConstructor
public class S3Config {

    private final AwsProperties awsProps;
    private final S3Properties s3Props;

    @Bean
    public S3Client s3Client() {
        final String endpoint = awsProps.useLocalstack()
            ? s3Props.localEndpoint()
            : s3Props.realEndpoint();

        final var client = S3Client.builder()
            .endpointOverride(URI.create(endpoint))
            .region(Region.of(s3Props.region()))
            .credentialsProvider(StaticCredentialsProvider.create(
                AwsBasicCredentials.create(s3Props.accessKey(), s3Props.secretKey())));

        // Force path style access for localstack
        if (awsProps.useLocalstack()){
            client.forcePathStyle(true);
        }

        return client.build();
    }
}
