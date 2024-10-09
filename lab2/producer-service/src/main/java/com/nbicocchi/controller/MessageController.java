package com.nbicocchi.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/send")
    public String sendMessage() {
        rabbitTemplate.convertAndSend("myQueue", "Hello, RabbitMQ!");
        return "Message sent!";
    }
}


