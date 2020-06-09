package com.jeonhwan.exam.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class Lcp_14 {

    /**
     * First approach with vertical and break
     * @param strs
     * @return
     */
    public String first_approach(String[] strs) {

        // Idea: 1) loop until end of all string
        //       2) each time check if all elements N char are same
        //           - if same adding up common prefix and go to next loop
        //       3) break when there is no common prefix

        // check elements number

        int index = 0;
        String lcp = "";
        boolean should_exit = false;

        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }

        // 1. loop until the end of first strings length.
        //  - TimeComplexity: O(m*n)
        //  - loop m(length of first string) time
        for (int i = 0; i < strs[0].length(); i++) {

            // 2. loop n(length of string array) time
            for (int j = 1; j < strs.length; j ++) {

                // exit if it's index is out of bound
                if(index >= strs[j].length()) {
                    should_exit = true;
                    break;
                }
                // check common length
                if (strs[0].charAt(index) !=  strs[j].charAt(index)) {
                    // go on..
                    should_exit = true;
                    break;
                }
            }


            // check just incase
            if (should_exit) {
                break;
            }
            // If it reach here it means this index are common among all array..
            lcp = strs[0].substring(0,index+1);

            index++;
        }

        return lcp;
    }

    // 1. Vertical scanning
    //  - O(S) time , S = m*n, m = length , n= number of strings
    //  - Best case n * minLen
    public String vertical_with_return(String[] strs) {
        int index = 0;
        if (strs == null || strs.length == 0) return "";
        for (int i = 0; i < strs[0].length(); i++) {

            char c =  strs[0].charAt(index);  // this make faster
            for (int j = 1; j < strs.length; j ++) {

                if(index == strs[j].length()) {
                    return strs[0].substring(0,index);
                }
                if (strs[j].charAt(index) != c) {
                    return strs[0].substring(0,index);
                }
            }
            index++;
        }
        return strs[0];
    }


    // 1. Horizontal scanning
    //  - O(N) time
    public String horizontal_approach(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    // 2. divide and conquer


}
