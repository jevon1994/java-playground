package com;

public class demo4 {
    public static void main(String[] args) {
        System.out.println("");
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10 ; j++) {
                if(j>i) break;
                System.out.print(" " + i + "*" + j  + "=" + i*j );

                }
            System.out.println("");
            }
        }
    }

