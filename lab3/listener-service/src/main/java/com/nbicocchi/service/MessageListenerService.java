package com.nbicocchi.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class MessageListenerService {

    private static final Logger logger = LoggerFactory.getLogger(MessageListenerService.class);

    @RabbitListener(queues = "myQueue")
    public void receiveMessage(String message) {
        logger.info("Received message: {}", message);
    }
}




