package com.exercise.react;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import reactor.test.StepVerifier;

import java.time.Duration;

public class ReactiveTest {
    public static void main(String[] args) {
        Flux.range(1, 2).log("Range").subscribe(System.out::println);
    }
}
