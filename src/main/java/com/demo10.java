package com;

import java.util.Scanner;

public class demo10 {

    public static void main(String[] args) {
        int a = 1 ,b = 1;
        int sum = 0;
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if(n <= 2){
            sum = 1;
        }else{
            for (int i = 0; i < n - 2 ; i++) {
                sum = a + b;
                a = b;
                b = sum;

            }
        }

        System.out.println(sum);
    }
}
