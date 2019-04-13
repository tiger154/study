package com.jeonhwan.exam.backjune;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * https://www.acmicpc.net/problem/1003
 *  - First input is N number of test case
 *  - From second line it gives N number: 0 < N <= 40
 *  - Result: Print out how many time zero and one called when use fibonacci on each N number.
 */
public class Fibo1003 {

    public static class FiboMemo{
        public int zero_cnt = 0;
        public int one_cnt = 0;
        public int prev_fibo = 0;
        public int result = 0;
    }

    // Inner class
    public static class Calculator {
        public int zero = 0;
        public int one = 0;

        // Memo we dont need
        Map map = new HashMap<Integer, FiboMemo>(){{
            put(0, new FiboMemo(){{
                zero_cnt = 1;
                one_cnt = 0;
                prev_fibo = 1;
                result = 0;
            }});
            put(1, new FiboMemo(){{
                zero_cnt = 0;
                one_cnt = 1;
                prev_fibo = 0;
                result = 1;
            }});
        }};

        // memozation 필요한듯 하다.
        public int fibo(int n) {

            if (n == 0) {
                zero++;
                return n;
            } else if (n ==1) {
                one++;
                return n;
            } else {
                int fibo_result;
                // If there is no calculation value.. do logic
                if (!map.containsKey(n)) {
                    int fibo_prev_result = fibo(n-1);
                    fibo_result  = fibo(n-1) + fibo(n-2);
                    map.put(n,new FiboMemo(){{
                        zero_cnt = zero;
                        one_cnt = one;
                        prev_fibo = fibo_prev_result;
                        result = fibo_result;
                    }});
                } else {
                    fibo_result = ((FiboMemo)map.get(n)).result;
                }
                return fibo_result;
            }
        }
    }

    public static String convertWithStream(Map<Integer, ?> map) {
        String mapAsString = map.keySet().stream()
                .map(key -> key + "=" + map.get(key))
                .collect(Collectors.joining(", ", "{", "}"));
        return mapAsString;
    }

    // main part
    public static void main(String []args){
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
            Calculator cal = new Calculator();
            int target_case_num = test_case_arr[i];
            int fibo_result = cal.fibo(target_case_num);
            //System.out.println("fibo: " + fibo_result);
            //System.out.println("map: " + cal.map);
            //System.out.println(cal.zero + " " + cal.one);
            System.out.println(((FiboMemo)cal.map.get(target_case_num)).prev_fibo + " " + ((FiboMemo)cal.map.get(target_case_num)).result );
        }
    }
}
