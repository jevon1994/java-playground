package com.playground.demo;


public class demo12 {
    public static void main(String[] args) {
        for (int i = 0; i <= 5 ; i++) {
            for (int j = 5-i; j >= 0 ; j--) {
                System.out.print(" ");

            }
            for (int k = 0; k < 2*i - 1 ; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
