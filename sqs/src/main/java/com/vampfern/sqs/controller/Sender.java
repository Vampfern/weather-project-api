package com.vampfern.sqs.controller;

import com.vampfern.sqs.publisher.MessagePublisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/")
    public void send(@RequestBody Object body) {
        LOGGER.info("Got message");
        this.messagePublisher.publish(body);
    }

}
