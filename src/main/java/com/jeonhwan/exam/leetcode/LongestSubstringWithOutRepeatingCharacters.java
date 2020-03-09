package com.jeonhwan.exam.leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class LongestSubstringWithOutRepeatingCharacters {


    // 중복을 제거한 가장 높은 데이터를 가져온다.
    public String longestSubString(String str, int start_index) {
        str = "abc abc bb";
        str = "pwwkew";
        return null;
    }


    /**
     *
     * Input: "abcabcbb"
     * Output: 3
     * Explanation: The answer is "abc", with the length of 3.
     *
     * Input: "pwwkew"
     * Output: 3
     * Explanation: The answer is "wke", with the length of 3.
     *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
     *
     * @param s
     * @return
     */


    public int lengthOfLongestSubstring(String s) {

        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;

//        int n = s.length();
//        int ans = 0;
//        for (int i = 0; i < n; i++) {
//            for (int j = i + 1; j <= n; j++) {
//                if (allUnique(s, i, j)) {
//                    ans = Math.max(ans, j - i);
//                }
//            }
//
//        }
//
//        return ans;
    }

    public boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            System.out.println(ch);
            if (set.contains(ch)) return false;
            set.add(ch);
        }
        return true;
    }





}
