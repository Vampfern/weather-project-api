package com.vampfern.sqs.configuration;

import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AWSConfig {

    @Bean
    public AmazonSQSAsync amazonSQSAsync() {
        return AmazonSQSAsyncClientBuilder
                .defaultClient();
    }

    @Value("${sqsUrl}")
    private String sqsUrl;

    @Bean()
    public String sqsUrl() {
        return this.sqsUrl;
    }

}
