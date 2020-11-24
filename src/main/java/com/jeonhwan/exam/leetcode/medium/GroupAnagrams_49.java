package com.jeonhwan.exam.leetcode.medium;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class GroupAnagrams_49 {

    private static Logger log = LoggerFactory.getLogger(GroupAnagrams_49.class);

    /**
     *
     *
     * TimeComplexity O(nlogn * w)
     *   - w: All words
     *   - n: Maximum length of string  <-- I made a mistake this as whole character
     *   - nlogn: Java sorting Time Complexity.
     *
     *  Worst cases
     *    n = 100
     *    logn = 10
     *    w = 104
     *
     *    100 * 10 * 104 = 104,000
     *
     * But here we didnt add String.valueOf things.. if its n time we need to multiply n time more then (nlogn * n * w)
     *
     * Constraints:
     *    1 <= strs.length <= 104
     *    0 <= strs[i].length <= 100
     *    strs[i] consists of lower-case English letters.
     *
     *
     * @param strs
     * @return
     */
    public List<List<String>> first_approach(String[] strs) {
        // edge cases
        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s :  strs) {
            char[] sc = s.toCharArray();
            Arrays.sort(sc); 			        // nlogn time (May I can practice this ~ as well if interviewer want me to implement)
            String key = String.valueOf(sc);    // n time
            if (!map.containsKey(key)) map.put(key, new ArrayList<String>());
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }


    /**
     * Little bit of improvement
     *    From nlogn -> n
     *
     * TimeComplexity O(n * w)
     *
     *
     * But Idea is smart using character with some pattern!
     * @param strs
     * @return
     */
    public List<List<String>> second_approach(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ca = new char[26];
            for (char c : s.toCharArray()) {
                ca[c - 'a'] = 1;
            }
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<>());
            map.get(keyStr).add(s);
        }
        return new ArrayList<>(map.values());
    }

}
