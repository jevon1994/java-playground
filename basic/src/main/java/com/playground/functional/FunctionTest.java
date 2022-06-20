package com.playground.functional;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Function;

@Slf4j
public class FunctionTest {
    public static void main(String[] args) {
        Function<Integer, Integer> A = i -> i + 1;
        Function<Integer, Integer> B = i -> i * i;
        System.out.println("F1:" + B.apply(A.apply(5)));
        System.out.println("F1:" + B.compose(A).apply(5));
        System.out.println("F2:" + A.apply(B.apply(5)));
        System.out.println("F2:" + B.andThen(A).apply(5));
    }
}

