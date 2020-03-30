package com.jeonhwan.exam.leetcode.easy;


public class ReverseInteger {


    /**
     *
     * We can solve this with simple math
     *
     * if we can handle as stack data structure number with simple math.
     *
     *  - Given number 123
     *  - What we want from iteration
     *<pre>
     * ==> pseudo code
     * {@code
     *  result = 0;
     *  left = given;
     *
     *  for i -> length of the given number {
     *
     *   result = result * 10  + (left % 10);   -- 0 + 3  , 30 + 2, 320 + 1
     *   left = left / 10;  -- set left part    -- 12 ,  1 , 0
     *
     *   > -123
     *
     *   result = result * 10  + (left % 10);   -- 0 + -3 , -32, -320 + -1
     *   left = left / 10;  -- set left part    -- -12 ,  -1  , 0
     *
     *   > 110
     *   result = result * 10  + (left % 10);   -- 0 + 0  ,  0 + 1, 10 + 1
     *   left = left / 10;  -- set left part    -- 11     ,  1    , 0
     * }
     *
     * 1) POP
     *   - number % 10 => Last element
     *   - nember / 10 => other elements
     *
     * 2) PUSH
     *   - (last pop result) * 10 + (left pop % 10)
     *
     *
     *</pre>
     *
     *
     *
     *
     * @param x
     * @return
     */
    public int bigONWithSimpleMath(int x) {

            int result = 0;
            int left = x;


            // until.. left part is equal zero
            // negative or positive in the end gonna be zero.
            while (left != 0) {

                // 0. check overflow,
                // 32bit int is 2^32 (-xx ~ xx)
                // because we have formula (result * 10) which can lead overflow, if we divide from max or min value,
                // we can check if it's over flow. let's say range is (-326 ~ 325) and
                // 1) result is 33 then (33*10) > 325
                // 1.1) result is 32 and pop is 6 (32*10) + 6 > 325
                // 2) result is -33 then (-33*10) < -326
                // 2.1) result is -32 and pop is -7 then (-33*10) + -7 < -326
                // Also I noticed all unsigned data type range end with 0 ~ xxx5
                //                all signed data type range end with -xxx8 ~ xxx7
                // May better memorize
                int pop = left % 10;

                // Check Max Overflow > 2,147,483,647
                if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && pop > 7)) {
                    return 0;
                }
                // Check Min Overflow > -32,768 to 32,767
                if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && pop < -8)) {
                    return 0;
                }

                // 1. push
                result = result * 10 + pop;
                // 2. pop
                left = left / 10;
            }

            return result;
        }



        /**
         *
         * @param x
         * @return
         */
        public int bigONwithStringBuilder(int x) {



            // 1.
            String number_string = String.valueOf(x);
            char[] number_string_arr = number_string.toCharArray();
            String reversed_string = "";
            int reversed_int = 0;

            // reverse string
            if (x < 0) {
                reversed_string = "-";
            }


            for (int i = 0; i < number_string_arr.length; i++) {

                if (x < 0 && i == number_string_arr.length-1) {
                    break;
                }
                reversed_string = reversed_string + number_string_arr[number_string_arr.length-1-i];
            }

            // now try cast
            try {
                reversed_int =  Integer.parseInt(reversed_string);
            // Over flow exception then return 0
            } catch (Exception e) {
                return 0;
            }

            return reversed_int;
        }


    /**
     * If you use StringBuilder it's much much faster with same logic
     *   - https://stackoverflow.com/questions/1532461/stringbuilder-vs-string-concatenation-in-tostring-in-java
     *   - https://cjh5414.github.io/why-StringBuffer-and-StringBuilder-are-better-than-String/
     * @param x
     * @return
     */
    public int bigONwithoutStringBuilder(int x) {

        // 1.
        String number_string = String.valueOf(x);
        char[] number_string_arr = number_string.toCharArray();
        String reversed_string = "";
        int reversed_int = 0;

        // reverse string


        StringBuilder sb = new StringBuilder();
        if (x < 0) {
            //reversed_string = "-";
            sb.append("-");
        }

        for (int i = 0; i < number_string_arr.length; i++) {

            if (x < 0 && i == number_string_arr.length-1) {
                break;
            }
            sb.append(number_string_arr[number_string_arr.length-1-i]);

            //reversed_string = reversed_string + number_string_arr[number_string_arr.length-1-i];
        }

        // now try cast
        try {
            reversed_int =  Integer.parseInt(sb.toString());
            // Over flow exception then return 0
        } catch (Exception e) {
            return 0;
        }

        return reversed_int;
    }


}
