package com.jeonhwan.exam.leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RomanToInteger_13 {

    /**
     * Ah its parsing String and to Integer
     *
     * 2 -> II
     * 5 -> 5
     *
     * 25 -> XXV
     *
     * 1) Big number is always left so left to right
     * 2) we can just count from the map the roman with values -> O(1)
     * 3) So loop O(N) time and each time translate from map. and sum up all values then it's done
     *
     *
     * my head debugging
     *
     * given String -> XXV
     *   X -> 10
     *   X -> 10 + 10
     *   V -> 10 + 10 + 5
     *
     *  we can check some exception cases
     *    I -> V(5), X(10) -> 4,9
     *    X -> L(50),C(100)  -> 40, 90
     *    C -> D(500),M(1000)  -> 400, 900
     *
     *   1 ~ 3999 -> under 4000
     *
     *
     *   x = 0 < x < 4000
     *
     *   - check always left value
     *   check if I and right value is V or X
     *   check if X and right value is L or C
     *   check if C and right value is D or M
     *
     *
     *   1) first map - default value of romans
     *   2) I and next value is in V or X then right - left ->
     *      IV=4, IX=9
     *      XL=40, XC=90
     *      CD=400, CM=900
     *
     *    LIX
     *
     *      need check if it's one of them
     *        -
     *
     *      map
     *
     * @param s
     * @return
     */
    public int first_approach(String s) {

        Map<String, Integer> map_two = new HashMap<>();
        map_two.put("IV", 4); // minus cases
        map_two.put("IX", 9); // minus cases
        map_two.put("XL", 40); // minus cases
        map_two.put("XC", 90); // minus cases
        map_two.put("CD", 400); // minus cases
        map_two.put("CM", 900); // minus cases

        Map<Character, Integer> map_one = new HashMap<>();
        map_one.put('I', 1);
        map_one.put('V', 5);
        map_one.put('X', 10);
        map_one.put('L', 50);
        map_one.put('C', 100);
        map_one.put('D', 500);
        map_one.put('M', 1000);

        int i = 0;
        int number = 0;

        while (i < s.length() ) {
            // if there is matching 6 case
            if ( i < s.length()-1 && map_two.get(s.substring(i, i+2)) != null) {
                // need to jump over
                number = number + map_two.get(s.substring(i, i+2));
                i++;
            } else {
                number = number + map_one.get(s.charAt(i));
            }
            i++;
        }
        return number;
    }



    public int second_approach(String s) {

        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int i = 0;
        int result =0;
        int next_num = 0;
        int current_num = 0;

        while (i < s.length() ) {

            current_num = map.get(s.charAt(i));
            next_num = ( i < s.length()-1 ) ? map.get(s.charAt(i+1)) : 0;

            if (current_num >= next_num) {
                result = result + current_num;
            } else {
                result = result + (next_num - current_num);
                i++;
            }

            i++;
        }
        return result;
    }



    /**
     * Alphabet(UpperCase) max decimal value is 90 (65-90)
     *
     *
     *  HashMap uses an array underneath so it can never be faster than using an array correctly.
     *
     * @param s
     * @return
     */
    public int best_approach(String s) {

        int[] map = new int[90];
        map['I'] = 1;
        map['V'] = 5;
        map['X'] = 10;
        map['L'] = 50;
        map['C'] = 100;
        map['D'] = 500;
        map['M'] = 1000;


        int i = 0;
        int result =0;
        int next_num = 0;
        int current_num = 0;
        while (i < s.length() ) {

            current_num = map[s.charAt(i)];
            next_num = ( i < s.length()-1 ) ? map[s.charAt(i+1)] : 0;

            if (current_num >= next_num) {
                result = result + current_num;
            } else {
                result = result + (next_num - current_num);
                i++;
            }
            i++;
        }


        return result;
    }

}
