package com.playground.demo;

public class demo8 {
    public static void main(String[] args) {

        for (int i = 1; i <= 13 ; i+=2) {
            for (int j = 1; j<=i && j + i <= 14 ; j++) {
                System.out.print("*" + " ");
            }
            System.out.println();
        }
    }
}
