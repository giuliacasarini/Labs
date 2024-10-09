package com.nbicocchi.config;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQConsumer {

    @RabbitListener(queues = "myQueue")
    public void listen(String message) {
        System.out.println("Received message: " + message);
    }
}

