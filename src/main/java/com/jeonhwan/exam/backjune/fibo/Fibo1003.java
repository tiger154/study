package com.jeonhwan.exam.backjune.fibo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * https://www.acmicpc.net/problem/1003
 *  - First input is N number of test case
 *  - From second line it gives N number: 0 < N <= 40
 *  - Result: Print out how many time zero and one called when use fibonacci on each N number.
 *
 *  It has 3 kind of approach all together you can just change on main method each of them!
 */
public class Fibo1003 {

    public static class FiboMemo{
        public int prev_fibo = 0;   // Same as total zero count
        public int result = 0;      // Same as total one count
    }

    // Inner class
    public static class Calculator {
        // For slow calculation
        public int zero = 0;
        public int one = 0;

        // For faster calculation with map memo
        Map map = new HashMap<Integer, FiboMemo>(){{
            put(0, new FiboMemo(){{
                prev_fibo = 1;
                result = 0;
            }});
            put(1, new FiboMemo(){{
                prev_fibo = 0;
                result = 1;
            }});
        }};

        // For faster calculation with array memo
        public int[] memo_arr = new int[41];

        public Calculator() {
            memo_arr[0] = 0;
            memo_arr[1] = 1;
        }

        public int fiboFastArr(int n) {
            if (n <= 1) {
                return n;
            }  else {
                if (memo_arr[n] > 0) {
                   return memo_arr[n];
                } else {
                    memo_arr[n] = fiboFastArr(n-1) + fiboFastArr(n-2);
                    return memo_arr[n];
                }
            }
        }


        /**
         * Faster as it use memo
         *   - using map
         * @param n
         * @return
         */

        public int fiboFastMap(int n) {
            if (n <= 1) {
                return ((FiboMemo)map.get(n)).result;
            } else {
                int fibo_result;
                // If there is no calculation value.. do logic
                if (!map.containsKey(n)) {
                    int fibo_prev_result = fiboFastMap(n-1);
                    fibo_result  = fiboFastMap(n-1) + fiboFastMap(n-2);
                    map.put(n,new FiboMemo(){{
                        prev_fibo = fibo_prev_result;
                        result = fibo_result;
                    }});
                } else {
                    fibo_result = ((FiboMemo)map.get(n)).result;
                }
                return fibo_result;
            }
        }

        /**
         * Slow calculation
         *   - reclusive even same tree again again it slow
         * @param n
         * @return
         */
        public int fiboSlow(int n) {
            if (n == 0) {
                zero++;
                return n;
            } else if (n ==1) {
                one++;
                return n;
            } else {
                return fiboSlow(n-1) + fiboSlow(n-2);
            }
        }


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
            // 1. Slow fibonacci
//            int fibo_slow_result = cal.fiboSlow(target_case_num);
//            System.out.println(cal.zero + " " + cal.one);

            // 2. Fast with Map memo
//            int fibo_fast_map_result = cal.fiboFastMap(target_case_num);
//            System.out.println(((FiboMemo)cal.map.get(target_case_num)).prev_fibo + " " + ((FiboMemo)cal.map.get(target_case_num)).result );

            // 3. Fast with Array
            int fibo_fast_arr_result = cal.fiboFastArr(target_case_num);
            if (target_case_num == 0) {
                System.out.println("1 0");
            } else {
                System.out.println(cal.memo_arr[target_case_num-1] + " " + cal.memo_arr[target_case_num] );
            }


        }
    }
}
