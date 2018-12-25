package com.exercise.demo;

import java.util.Scanner;

public class demo2 {
    public static void main(String[] args) {
        System.out.println("请输入分数");
        Scanner scanner = new Scanner(System.in);
        int score = scanner.nextInt();
        switch (score/10){
            case 7: case 8:
                System.out.println("B");
                break;
            case 9: case 10:
                System.out.println("A");
                break;

                default:
                    System.out.println("C");


        }
    }
}
