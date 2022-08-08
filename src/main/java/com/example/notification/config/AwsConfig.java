package com.example.notification.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AwsConfig {

    @Value("${aws.credentials.access.key}")
    private String accessKey;
    @Value("${aws.credentials.secret.key}")
    private String secretKey;
    @Value("${aws.credentials.region}")
    private String region;

    public AmazonSimpleEmailService getClient(){
        AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);

        AmazonSimpleEmailService client = AmazonSimpleEmailServiceClientBuilder
                .standard().withCredentials(new AWSStaticCredentialsProvider(credentials)).withRegion(region).build();

        return client;
    }
}
