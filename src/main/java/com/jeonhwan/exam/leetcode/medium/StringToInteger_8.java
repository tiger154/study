package com.jeonhwan.exam.leetcode.medium;

public class StringToInteger_8 {


    /**
     *
     *
     * O(N) possible
     *
     *    make a map! to compare the structure
     *
     *    int result = 0;
     *    boolean is_negative = false;
     *    loop as string length;
     *
     *       // 1) fomular
     *
     *
     *    if (string[idx] == " ") {
     *       continue;
     *    }
     *
     *    if (string[idx] == "-") {
     *       is_negative = true;
     *       continue;
     *    }
     *
     *    // If it's string
     *    if (!num_map.contain(string[idx])) {
     *       return 0;
     *    }
     *
     *
     *    result  = result * 10 + string[idx];
     *
     *
     * @param str
     * @return
     */
    public int myAtoi(String str) {
        int sum_unicode = 0;
        boolean is_negative = false;
        // This is right calculation man
        // 48(0) ~ 57(9)

        // need to check if it exist..
        // (s.charAt(1) - 48) somehow it's convert ?

        // This is a core concept! And its probably actual java implementation for String to int
        for (int i =0; i < str.length(); i++) {

            // 1. All filter here

            // 1.1. if just a space skip man~
            if (str.charAt(i) == ' ') { continue; }

            // 1.2 +, - detail check, check if next char is int
            if ((str.charAt(i) == '+' || str.charAt(i) == '-')) {
                // 1.2.1 if next value is not num exit
                if (i < str.length()-1 && is_not_num(str.charAt(i+1))) {
                    return 0;
                }
                // 1.2.2 if negative set save operator
                if (str.charAt(i) == '-' ) {
                    is_negative = true;
                }
                // and continue both + or - case
                continue;
            }




            // 1.3 if it's not number then just finish this
            if(((str.charAt(i) - 48) < 0 || (str.charAt(i) - 48) > 9)) {
                return 0;
            }

            // 1.4 Check overflow and return it! (-2^31 ~ 2^31-1)
            if (is_negative) {
                int min_d_10 = Integer.MIN_VALUE / 10;
                int negative_sum_unicode = sum_unicode * -1;
                if ( negative_sum_unicode < min_d_10 || (negative_sum_unicode == min_d_10 && ((str.charAt(i) - 48) * -1) < -8) ) {
                    return Integer.MIN_VALUE;
                }
            } else {
                int max_d_10 = Integer.MAX_VALUE / 10;
                if ( sum_unicode > max_d_10 || (sum_unicode == max_d_10 && (str.charAt(i) - 48) > 7) ) {
                    return Integer.MAX_VALUE;
                }
            }



            // 4. make as integer with simple math
            sum_unicode =  sum_unicode * 10 + (str.charAt(i) - 48);

            // 5. if next value is not integer 48~57 then exit!
            if (i < str.length()-1 && ((str.charAt(i+1) - 48) < 0 || (str.charAt(i+1) - 48) > 9)) {
                break;
            }
        }

        // calculate for negative here
        if (is_negative) {
            sum_unicode = sum_unicode * -1;
        }
        return sum_unicode;
    }


    public boolean is_not_num(char c){
        if(((c - 48) < 0 || (c - 48) > 9)) {
            return true;
        } else {
            return false;
        }
    }

}
