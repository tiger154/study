package com.jeonhwan.exam.backjune;

import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/2750
 *
 * Simple order exam
 *  - First line input: N(1 ≤ N ≤ 1,000)
 *  - From second input N number given
 *  - Maximum value is <= 1000
 *  - All number are unique
 *
 */
public class Order2750 {


    /**
     * Mistake note
     *  - When check condition I made more like bubble sort so there was problem.
     *    Fixed properly to check for min_index
     * @param total_number
     * @param arr
     * @return
     */
    public static int[] SelectionOrder(int total_number, int[] arr) {
        int min_index;
        int temp = 0;
        for(int i =0; i < total_number; i ++) {
            min_index = i;
            for (int j = i; j < total_number-1; j++) {
                if (arr[j+1] < arr[min_index]) {
                    min_index = j+1;
                }
            }
            // swap
            temp = arr[min_index];
            arr[min_index] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

    public static void main(String []args){
        //--------------------------------------
        // Set Vars
        //--------------------------------------
        int total_number;
        int[] arr = new int[1001]; // 최대 값 1000 가정시 +1 을 추가 하는것을 권장함.
        // In java we can get input data with Java.util.Scanner class
        Scanner sc = new Scanner(System.in);

        //--------------------------------------
        // Get User inputs
        //--------------------------------------
        total_number = sc.nextInt(); // Argument numbers
        // Get all test data until total number
        for(int i=0; i < total_number; i ++) {
            arr[i] = sc.nextInt();
        }
        //--------------------------------------
        // Logic area
        //--------------------------------------

        int[] result_arr = SelectionOrder(total_number, arr);

        for(int i=0; i < total_number; i ++) {
            System.out.println(arr[i]);
        }
    }

}
