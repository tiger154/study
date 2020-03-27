package com.jeonhwan.exam.leetcode.easy;


public class ReverseInteger {


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
