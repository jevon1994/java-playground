package com.playground.demo;

import java.util.Scanner;

public class demo6 {
    public static void main(String[] args) {
        int sum = 0;
        Scanner scanner = new Scanner(System.in);
        int b = scanner.nextInt();
        int d = scanner.nextInt();
        for (int i = 0; i < d ; i++) {
            sum += b;
            b = b + b*10;


        }
        System.out.println(sum);

    }
}
