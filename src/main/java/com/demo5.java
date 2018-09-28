package com;

public class demo5 {
    public static void main(String[] args) {
        int a,b,c;
        int i = 100;
        for (int sum; i < 1000; i++) {
            a = i/100;
            b = (i - a*100)/10;
            c = i - a*100 - b*10;
            sum = a*a*a + b*b*b + c*c*c;
            if(sum == i){
                System.out.println(sum);
            }
        }
    }
}
