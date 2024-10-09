package com.nbicocchi.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class MainService {

    private final RestClientService restClientService;
    private final MessageSender messageSender;

    public MainService(RestClientService restClientService, MessageSender messageSender) {
        this.restClientService = restClientService;
        this.messageSender = messageSender;
    }

    public Mono<Void> processAndSendMessage() {
        return restClientService.fetchDataFromApi()
                .doOnNext(data -> {
                    // Process the data if needed
                    messageSender.sendMessage(data);
                })
                .then();
    }
}
