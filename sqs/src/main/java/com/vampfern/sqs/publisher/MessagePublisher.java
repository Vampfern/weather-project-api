package com.vampfern.sqs.publisher;

import com.amazonaws.services.sqs.AmazonSQS;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.reflectoring.sqs.api.SqsMessagePublisher;
import org.springframework.stereotype.Component;

@Component
public class MessagePublisher extends SqsMessagePublisher<Object> {

    MessagePublisher(String sqsUrl, AmazonSQS sqsClient, ObjectMapper objectMapper) {
        super(sqsUrl, sqsClient, objectMapper);
    }

}
