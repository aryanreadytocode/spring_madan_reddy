package com.aryan.serversenteventsexample.controller;

import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

@RestController
@RequestMapping("/server-events")
public class ServerEventsController {

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ServerSentEvent<String>> getEvents() throws IOException {
        Stream<String> lines = Files.lines(Path.of("/ARYAN/Projects/ARYAN/JAVA/Spring_By_Madan_Reddy_Udemy/server-sent-events-example" +
                "/server-sent-events-example/pom.xml"));
        AtomicInteger counter = new AtomicInteger(1);
        return Flux.fromStream(lines)
                .filter(line -> !line.isBlank())
                .map(line -> ServerSentEvent.<String>builder()
                        .id(String.valueOf(counter.getAndIncrement()))
                        .data(line)
                        .event("lineEvent")
                        .retry(Duration.ofMillis(1000))
                        .build()
                )
                .delayElements(Duration.ofMillis(300));
    }

    @GetMapping(path = "/alternative", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> getEventsAlternativeOption() throws IOException {
        Stream<String> lines = Files.lines(Path.of("/ARYAN/Projects/ARYAN/JAVA/Spring_By_Madan_Reddy_Udemy/server-sent-events-example" +
                "/server-sent-events-example/pom.xml"));
        AtomicInteger counter = new AtomicInteger(1);
        return Flux.fromStream(lines)
                .filter(line -> !line.isBlank())
                /*.map(line -> ServerSentEvent.<String>builder()
                        .id(String.valueOf(counter.getAndIncrement()))
                        .data(line)
                        .event("lineEvent")
                        .retry(Duration.ofMillis(1000))
                        .build()
                )*/
                .delayElements(Duration.ofMillis(300));
    }
}