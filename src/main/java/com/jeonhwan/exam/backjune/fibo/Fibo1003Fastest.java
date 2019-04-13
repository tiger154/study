package com.jeonhwan.exam.backjune.fibo;


import java.util.Scanner;

/**
 *  * Mistake note
 *    - When tried with array i set length as 40.
 *      but it must be 41 as condition is 0 > N <=40.
 *
 */
public class Fibo1003Fastest {


    // Inner class
    public static class Calculator {

        // For faster calculation with array memo
        public int[] memo_arr = new int[41];

        public Calculator() {
            memo_arr[0] = 0;
            memo_arr[1] = 1;
        }

        public int fibo(int n) {
            if (n <= 1) {
                return n;
            }  else {
                if (memo_arr[n] > 0) {
                    return memo_arr[n];
                } else {
                    memo_arr[n] = fibo(n-1) + fibo(n-2);
                    return memo_arr[n];
                }
            }
        }


    }

    // main part
    public static void main(String []args) {
        // 1. Input
        Scanner sc = new Scanner(System.in);
        int total_number;
        int[] test_case_arr;
        int result = 0;
        //--------------------------------------
        // Get User inputs
        //--------------------------------------
        total_number = sc.nextInt();
        test_case_arr = new int[total_number];
        // Get all test data until total number
        for(int i=0; i < total_number; i ++) {
            test_case_arr[i] = sc.nextInt();
        }

        //--------------------------------------
        // Logic area
        //--------------------------------------

        for(int i=0; i < total_number; i ++) {
            Fibo1003Fastest.Calculator cal = new Fibo1003Fastest.Calculator();
            int target_case_num = test_case_arr[i];


            // 3. Fast with Array
            int fibo_fast_arr_result = cal.fibo(target_case_num);
            if (target_case_num == 0) {
                System.out.println("1 0");
            } else {
                System.out.println(cal.memo_arr[target_case_num-1] + " " + cal.memo_arr[target_case_num] );
            }


        }
    }
}
