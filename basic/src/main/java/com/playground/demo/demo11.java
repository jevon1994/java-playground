package com.playground.demo;

public class demo11 {
    public static void main(String[] args) {
        double z = 1 , m = 1;
        double sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += z/m;
            z *= -1.0;
            m += 2.0;
        }
        System.out.println(sum);
    }
}
