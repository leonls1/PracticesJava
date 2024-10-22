package com.example.micro1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/apí/service1/")
public class controllador1 {
    private final WebClient webClient;

    public controllador1(WebClient.Builder webClientBuilder){
        this.webClient = webClientBuilder.baseUrl("http://localhost:8081").build();
    }

    @GetMapping("/data-from-service-2")
    public Mono<String> getDataFromService2(){
        return webClient.get()
                .uri("/endpoint-service-2") //el endpoint del service 2
                .retrieve()
                .bodyToMono(String.class); //espera que la respuesta sea en formato string
    }

    @GetMapping("/getting-a-list")
    public Flux<String> getList(){
        return webClient.get()
                .uri("/endpoint-with-list")
                .retrieve()
                .bodyToFlux(String.class); //espera una lista de string
    }
}
