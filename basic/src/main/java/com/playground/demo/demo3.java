package com.playground.demo;

public class demo3
{
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 0 ; i < 100; i++) {
            sum = i + sum;
        }
        System.out.println(sum);
    }
}
