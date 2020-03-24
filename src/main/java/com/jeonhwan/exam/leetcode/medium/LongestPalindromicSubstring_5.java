package com.jeonhwan.exam.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class LongestPalindromicSubstring_5 {


    /**
     * Median Of Two Sorted Arrays
     *  - May we can also add sorted function here
     *
     *<br><br>
     *<h3> 1. English Description </h3>
     *<pre>
     *    1. Definition
     *      1) Brutal force: O(N^3)
     *         - init longest palindromic = 0
     *         - Iterate each element N^2 times
     *         - Check If start/end is same
     *           - check Substring length loop
     *           - Compare Left to Right, Right to Left > If all passed save the length.
     *           - Next time may can skip if length is smaller then current longest palindromic
     *
     *    2. pseudo code
     *    3. weakness
     *      - It works but too slow as expected for example
     *        if input is 1000 its 1000^3 = 1000 * 1000 * 1000; // 1 billion time -_-;;
     *      - So probably should think about better approach LogN or N time condition
     *      - I think probably this I can solve with window sliding way?
     *
     *</pre>
     *
     *<br><br>
     *<h3> 2. Korean Description </h3>
     *<pre>
     *
     *</pre>
     *
     *
     */
    public String bigOMultiple3(String s) {

        if (s.length() == 0) {
            return "";
        }

        int longest = 0;
        int longest_start_index =0;
        int longest_end_index =0;

        // How to
        for (int i =0; i < s.length(); i++) {
            // s.charAt(i);
            for (int j = i+1; j < s.length(); j++) {
                // Possible candidate if its same..

                // 2) if size over two
                if (s.charAt(i) == s.charAt(j)) {
                    // check till the length of substring
                    for(int ii = i; ii <= j; ii++) {
                        // if doesnt match a char then break
                        if (s.charAt(ii) != s.charAt(j- (ii-i) ) ) {
                            break;
                        }
                        // if it's end of the loop check length and register to new longest
                        if( ii == j) {
//                            longest = (longest < ((j - i) + 1)) ? ((j - i) + 1) : longest;
                            if(longest < ((j - i) + 1)) {
                                longest = ((j - i) + 1);
                                longest_start_index = i;
                                longest_end_index = j;
                            }

                        }

                    }
                }

            }
        }

        String longest_string = "";
        for (int fi = longest_start_index; fi <= longest_end_index; fi++) {
            longest_string = longest_string + s.charAt(fi);
        }
        return longest_string;
    }


    /**
     * If we can use Window Slide way... it can be O(N)
     *   It says about Longest Common Substring. N^2
     *
     *
     * @param s
     * @return
     */
    public String bigONMultiple2(String s) {

        return "";
    }



}
