package com.jeonhwan.exam.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * Approach 1.
 *   - Longest Substring: takes O(N^2) But not
 *   1) Make reverse
 *   2) Make metrics with original and reverse
 *   3) If it's matched check, palindromic
 *      -
 *
 * Approach 2.
 *   - Brute force: Pick all possible starting and ending positions for a substring, and verify if it is a palindrome
 *   - O(N^3)
 *
 */
public class LongestPalindromicSubstring_5 {


    /**
     * This is really cool using DP
     *   - First of all Substring of a word is => n * (n + 1) / 2 => which means we need to check only triangle space on metrics
     *     1) Rule s[i] == s[j] and metrics[i+1][j-1] is true then its palindromic (There is one thing more)
     *     2) make start point of each character like [0][0], [1][1], [2][2], [3][3]
     *     3) iterate i=0 till length of string
     *          > iterate j=0 till length of string, j++
     *              P(j, j + i) => [0,0][1,1][2,2][3,3]
     *                          => [0,1][1,2][2,3][3,4]
     *                          => [0,2][1,3][2,4][3,5]
     *
     *     To improve over the brute force solution, we first observe how we can avoid unnecessary re-computation while validating palindromes.
     *     Consider the case "ababa". If we already knew that "bab" is a palindrome, it is obvious that "ababa" must be a palindrome since
     *     the two left and right end letters are the same.
     *
     *     We define P(i,j)P(i,j) as following:
     *        - P(i,j)={true,false,if the substring Si…Sj is a palindromeotherwise.
     *     Therefore,
     *       - P(i,j) = (P(i+1,j−1) and Si == Sj)
     *     The base cases are:
     *       - P(i,i)=true
     *       - P(i,i+1)=(Si==Si+1)
     * @param s
     * @return
     */
    public String dpBigO2(String s) {


        if(s.length() == 0) {
            return "";
        }

        // So lets code about this amazing dp solution
        char[] s_arr = s.toCharArray();
        boolean[][] metrics = new boolean[s.length()][s.length()];
        String longest_string = "";
        int longest_start_index = 0;
        int longest_end_index = 0;
        int current_longest_length = 0;
        // Run time   O(n^2 + n / 2)
        // 1. iterate i=0 till length of string
        for(int i =0; i < s_arr.length; i++) {

            // 1.1 iterate j=0 till length of string - i, j++ --> So it can decrease runtime as consecutive time
            for(int j = 0; j <s_arr.length-i; j++) {
                // Important thing is... j, j+1 => which is comparing index, which is it can iterate
                int start = j;
                int end   = j+i;
                // Rule s[i] == s[j] and metrics[i+1][j-1] is true then its palindromic (There is one thing more)
                // Initial each char set default true.
                // start == and or length < 2
                // 0,4 is same but not cant find center is same
                // 1,2 case is same but not related
                if (s.charAt(start) == s.charAt(end) && (start == end ||  end-start == 1 )) {
                    metrics[start][end] = true;
                    current_longest_length = longest_end_index - longest_start_index + 1;
                    if (current_longest_length < ((end - start) + 1)) {
                        longest_start_index = start;
                        longest_end_index = end;
                    }
                }

                // Check if it's palindromic -> from center before
                if ((end > 0) && (start < s_arr.length -1)  && s.charAt(start) == s.charAt(end) && metrics[start+1][end-1] == true ) {

                    // This is palindromic
                    metrics[start][end] = true;

                    current_longest_length = longest_end_index - longest_start_index + 1;
                    if (current_longest_length < ((end - start) + 1)) {
                        longest_start_index = start;
                        longest_end_index = end;
                    }
                }
            }
        }


        // Finally get longest string! => can be N time
        for(int i = longest_start_index; i <= longest_end_index; i++) {
            longest_string = longest_string + s.charAt(i);
        }

        return longest_string;
    }


    /**
     * Same it's over time limit...
     * @param s
     * @return
     */
    public String lcsBigO3(String s) {

        String reverse_s = "";
        String longest_string = "";

        // 1. empty check
        if (s.length() == 0) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }
        // 2. reverse string ( N time)
        for (int i =0; i< s.toCharArray().length; i++) {
            reverse_s = reverse_s + s.charAt((s.length() - 1) - i);
        }

        if(s.equals(reverse_s)) {
            return s;
        }


        char[] a = s.toCharArray();
        char[] b = reverse_s.toCharArray();
        int[][] metrics =  new int[a.length][b.length];

        // 3. Make metrics!
        for (int i =0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (a[i] == b[j]) {
                    if ( (i > 0 && j > 0) && metrics[i-1][j-1] > 0) {

                        // 1. Set metrics
                        metrics[i][j] = metrics[i-1][j-1] + 1;
                        // 2. Check if it's palindromic
                        // start_index and last_index
                        int start_index = i - metrics[i][j] + 1;
                        int last_index = i;
                        boolean is_palindromic = true;
                        String candidate_palindromic = "";

                        for (int ii = start_index; ii <= i; ii++) {
                            candidate_palindromic = candidate_palindromic + a[ii];
                            // ++ --
                            if(a[ii] != a[last_index]) {
                                is_palindromic = false;
                                break;
                            }
                            last_index--;
                        }

                        // 4. if it's a palindromic then compare longest then samp!
                        if (is_palindromic && longest_string.length() < metrics[i][j]) {
                            longest_string = candidate_palindromic;
                        }

                    } else {
                        metrics[i][j] = 1;

                        // If there is no value then set data
                        if (longest_string.length() == 0) {
                            longest_string = longest_string + a[i];
                        }

                    }
                } else {
                    metrics[i][j] = 0;
                }
            }
        }

        return longest_string;
    }



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
        // check if empty
        if (s.length() == 0) {
            return "";
        }
        // check if it's same
        // then just return all


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
     *
     * Next approach is
     *
     *
     *
     *
     * @param s
     * @return
     */
    public String bigONMultiple2(String s) {

        return "";
    }



}
