package com.jeonhwan.exam.leetcode.easy;

import java.util.ArrayList;
import java.util.List;



public class ImplementStrStr_28 {

    /**
     *
     * TimeComplexity: O(N)
     * Description: Use two pointer, 1) match_index which increase++ when encountered same character
     * 2) look_for_index just move from left to right.
     *
     * It was working but I didn't consider substring cases.
     *
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int first_approach(String haystack, String needle) {

        // if empty return just 0
        if (needle.length() == 0) return 0;

        // if same length compare right away!
        if (needle.length() == haystack.length()) return (needle.equals(haystack)) ? 0 : -1;

        int match_index = 0;
        int first_matched_index = -1;

        for (int j = 0; j < haystack.length(); j++) {
            // when it hit the maximum then break.
            if (match_index == needle.length()) {
                first_matched_index = j - match_index;
                break;
            }

            // if matched increase match_index and move to next
            if ( haystack.charAt(j) == needle.charAt(match_index) )
                match_index++;
            else
                match_index = 0;
        }

        return first_matched_index;
    }


    /**
     * TimeComplexity: O(N+K) K is count(needle[0] == haystack(N))
     *                 Worst case can be O(N^2) if given haystack, needle are really similar ==> ('aaaaaaaabb','aaaaaaaaa')
     * Description: First I thought to make all possible substring.
     *              But made better Idea like above. But worst case result could be just not much difference
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int second_approach(String haystack, String needle) {

        // if empty return just 0
        if (needle.length() == 0) return 0;

        // if same length compare right away!
        if (needle.length() == haystack.length()) return (needle.equals(haystack)) ? 0 : -1;

        // needle must be smaller then haystack
        if (haystack.length() < needle.length()) return -1;


        int match_index = 0;
        int first_matched_index = -1;
        int term = needle.length();

        List<Integer> candidates = new ArrayList<>();

        // first check all same start with
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0))
                candidates.add(i);
        }

        for (Integer item : candidates) {
            if (item+term <= haystack.length() && haystack.substring(item, item+term).equals(needle)) {
                first_matched_index = item;
                break;
            }
        }

        return first_matched_index;
    }


    /**
     * TimeComplexity: O(N)
     * Description: While I was building second approach, I was like why don't I merge this logic at once.
     *              This just loop N time only, and compare "haystack.charAt(i) == needle.charAt(0)" first
     *              If find same char of that, then compare needle data from 'i' to 'i + needle.length'.
     *              If it's true just return 'i' value.
     *
     *              Much simpler and effective!!!
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int third_approach(String haystack, String needle) {


        // if empty return just 0
        if (needle.length() == 0) return 0;

        // if same length compare right away!
        if (needle.length() == haystack.length()) return (needle.equals(haystack)) ? 0 : -1;

        // needle must be smaller then haystack
        if (haystack.length() < needle.length()) return -1;


        int first_matched_index = -1;
        int term = needle.length();


        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                int end = i + term;
                if (end <= haystack.length() && haystack.substring(i, end).equals(needle)) {
                    first_matched_index = i;
                    break;
                }
            }
        }

        return first_matched_index;

    }
}
