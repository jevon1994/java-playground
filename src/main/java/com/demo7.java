package com;

public class demo7 {
    public static void main(String[] args) {
        double z = 2.0;
        double m = 1.0;
        double sum = 0;
        for (int i = 0; i < 20; i++) {
            sum += z/m;
            m = z;
            z += m;
        }
        System.out.println(sum);



    }
}
