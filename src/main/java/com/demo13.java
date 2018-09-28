package com;


public class demo13 {
    public static void main(String[] args) {

        int[] arry = new int[10];
        int min = arry[0];
        int max = arry[0];
        for (int i = 0; i < arry.length ; i++) {
            arry[i] = (int)(100*Math.random());
            System.out.println(arry[i]);
            if(max<arry[i]){
                max = arry[i];
            }
            if(min>arry[i]){
                min = arry[i];
            }
        }
        System.out.println(max + " " + min);
    }
}
