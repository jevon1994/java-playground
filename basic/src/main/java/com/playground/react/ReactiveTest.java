package com.playground.react;

import reactor.core.publisher.Flux;

public class ReactiveTest {
    public static void main(String[] args) {
        Flux.range(1, 2).log("Range").subscribe(System.out::println);
    }
}
