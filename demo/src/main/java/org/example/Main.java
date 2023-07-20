package org.example;

import java.util.*;


public class Main {
    public static void main(String[] args) {

        int arr[] = new int[]{1, 2, 3, 4};
        int arr1[]=new int[]{0,0};
        int sum = 0;
        int sum2=0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];

        }
        System.out.println(sum);
        for (int j= 0; j< arr1.length; j++) {
            sum2 = sum2 + arr[j];

        }
        System.out.println(sum2);
        int sum3=sum+sum2;
        System.out.println(sum3);
    }
}
