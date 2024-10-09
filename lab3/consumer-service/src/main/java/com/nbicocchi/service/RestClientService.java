package com.nbicocchi.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class RestClientService {

    private final WebClient webClient;

    public RestClientService(WebClient.Builder builder) {
        this.webClient = builder.baseUrl("https://jsonplaceholder.typicode.com").build();
    }

    public Mono<String> fetchDataFromApi() {
        return webClient.get()
                .uri("/todos/1")
                .retrieve()
                .bodyToMono(String.class);
    }
}


