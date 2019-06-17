package com.exercise.demo;

public class demo9 {
    public static void main(String[] args) {
        double pi = 0;
        double z = 4;
        double m = 1;
        for (long i = 0; i <999999999 ; i++) {
            pi += z/m;
            z *= -1;
            m += 2.0;
            if(pi>3.1415 && pi <3.1416){
                System.out.println(pi);
                break;
            }
        }
    }
}
