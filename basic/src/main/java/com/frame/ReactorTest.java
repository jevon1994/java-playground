package com.frame;

import io.vavr.API;
import io.vavr.control.Try;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

import static io.vavr.API.*;

public class ReactorTest {
    public static void main(String[] args) {
        testMatch();
    }

    private static void testMatch() {
        Match(1).of(
                Case($(v -> v > 0), o -> run(() -> System.out.println("> 0"))),
                Case($(0), o -> run(() -> System.out.println("0"))),
                Case($(), o -> run(() -> System.out.println("< 0")))
        );
    }

    private static void reduce() {
        // 累加
        Flux.just(1, 1, 1, 1, 1).reduceWith(() -> 1, (x, y) -> x + y).subscribe(System.out::println);

    }


    private static void poll() {
        AtomicInteger integer = new AtomicInteger(1);
        // 定时轮询
        LocalDateTime start = LocalDateTime.now();
        Flux.interval(Duration.ofSeconds(1))
                .flatMap(o -> {
                    return Mono.just(1)
                            .map(r -> {
                                System.out.println(integer.getAndAdd(1));
                                return r;
                            });
                })
                .takeUntil(r -> r >= 10 || Duration.between(start, LocalDateTime.now()).getSeconds() >= 9)
                .doOnComplete(() -> System.out.println("done!!!"))
                .blockLast();
    }
    private static void tryTest(){
        Try.of(() -> 1 / 0 )
        .onFailure(e -> System.out.println("fail"));
    }
}
