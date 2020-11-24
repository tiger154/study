package com.jeonhwan.exam.leetcode.easy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class ValidAnagram_242 {
    private static Logger log = LoggerFactory.getLogger(ValidAnagram_242.class);

    /**
     *
     * TimeComplexity O(slogs + tlogt)
     *
     *
     * @param s
     * @param t
     * @return
     */
    public boolean first_approach(String s, String t) {
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        Arrays.sort(sc);
        Arrays.sort(tc);
        return (Arrays.equals(sc, tc));
    }


    /**
     *
     *  TimeComplexity O(s + t)
     *
     *
     * @param s
     * @param t
     * @return
     */
    public boolean second_approach(String s, String t) {
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();

        int[] cpt = new int[26];
        int[] tpt = new int[26];

        for (char c : sc) cpt[c - 'a']++;
        for (char c : tc) tpt[c - 'a']++;

        return (Arrays.equals(cpt, tpt));
    }

}
