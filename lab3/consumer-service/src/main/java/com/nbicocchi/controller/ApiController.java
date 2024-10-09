
package com.nbicocchi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import com.nbicocchi.service.MessageSender;
import com.nbicocchi.service.RestClientService;

@RestController
public class ApiController {

    private final RestClientService syncService;
    private final MessageSender messageSender;

    public ApiController(RestClientService syncService, MessageSender messageSender) {
        this.syncService = syncService;
        this.messageSender = messageSender;
    }

    @GetMapping("/process")
    public Mono<String> process() {
        return syncService.fetchDataFromApi()
                .doOnNext(response -> messageSender.sendMessage(response))
                .map(response -> "Message sent to RabbitMQ: " + response);
    }
}
