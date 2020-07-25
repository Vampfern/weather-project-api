package com.vampfern.sqs.controller;

import com.vampfern.sqs.publisher.MessagePublisher;
import com.vampfern.sqs.response.Response;
import com.vampfern.sqs.utils.ObjectToJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/send")
public class Sender {

    private static final Logger LOGGER = LoggerFactory.getLogger(Sender.class);

    MessagePublisher messagePublisher;

    @Autowired
    Sender(MessagePublisher messagePublisher) {
        this.messagePublisher = messagePublisher;
    }

    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> send(@RequestBody Object body) {
        String json = ObjectToJson.convert(body);
        LOGGER.info("Message received {}", json);
        this.messagePublisher.publish(body);

        return ResponseEntity.ok(Response.builder().message("Created").result(json).build());
    }

}
