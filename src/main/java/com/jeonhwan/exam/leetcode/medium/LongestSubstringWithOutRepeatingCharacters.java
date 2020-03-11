package com.jeonhwan.exam.leetcode.medium;

import java.util.*;



/**
 * Longest Substring without repeating characters
 *
 *
 *<br><br>
 *<h3> 1. English Description </h3>
 *<pre>
 *     1.
 *
 *</pre>
 *
 *<br><br>
 *<h3> 2. Korean Description </h3>
 *<pre>
 *     1. 가장 긴 중복 제거된(distinct) SubString 찾기
 *       - Longest Common Substring 과 다름.
 *     2. Mistake Note
 *       - 문제 자체를 이해하는데 시간이 반나절 이상 걸림.
 *       - 개략적 이해를 바탕으로 스스로 구현(빅 O 최악의 수로: O(N^3)+ ) 은 하였으나, 테스트 케이스 통과 실패함
 *       - 이에 솔루션 속독 확인후 재구현 시도함.
 *       - Window Sliding 으로 구현하였으며, 해당 알고리즘 스터디 없이 구현 하면서(코드를 보며, 디버깅 하며) 이해함.
 *
 *     2. 주요 스터디 포인트
 *       1) 차이점 이해 Substring and Subsequence
 *         (1) Substring: 이어진 문자열 (수열)
 *         (2) SubSequence: 중간에 이빨 빠진 문자열 (부분 수열)
 *       2) Window Sliding 알고리즘 스터디
 *       3) TODO - 이외 O(N^3) 의 케이스도 추가 구현 하여 차이점을 체크 해봐야한다.
 *                 이외 더 개선된 방향이 없는지 비교 할것.
 *                 영문 설명 추가 할것. 휴!!
 *
 *
 *
 *
 *</pre>
 */
public class LongestSubstringWithOutRepeatingCharacters {

    public int lengthOfLongestSubstringApproach2(String s) {

        // init vars
        int longest = 0;
        Set<Character> unique_string_map = new HashSet<>();


        int start_pointer = 0;
        int search_pointer = 0;
        int length_temp = 0;

        while (search_pointer < s.length()) {
            if (search_pointer >= s.length()) {
                break;
            }

            if (!unique_string_map.contains(s.charAt(search_pointer))) {
                unique_string_map.add(s.charAt(search_pointer));

                length_temp = (search_pointer == (s.length() - 1)) ? search_pointer + 1 : search_pointer;

                if ((length_temp - start_pointer) > longest) {
                    longest = (length_temp-start_pointer);
                }
                search_pointer++;
            } else {

                if ((search_pointer-start_pointer) > longest) {
                    longest = (search_pointer-start_pointer);
                }

                start_pointer++;
                search_pointer = start_pointer;

                unique_string_map = new HashSet<>();
            }
        }
        return longest;
    }


    /**
     *
     * Approach1 - Easiest version to implement
     *
     *  1. Find all possible substring
     *  2. And Make Unique char string
     *  3. Find all possible substring from number 2
     *  4. loop with number 3 substring
     *     1) Check if the substring exist from number 1
     *       - If it exist, compare current longest string length
     *       - If it's longer then current one, set to new value.
     *       - and so on
     * psuedo
     *
     *
     *
     *
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringApproach1(String s) {
        // init vars
        int longest = 0;
        String longest_string = "";
        Set<String> all_possible_substring = new HashSet<>();
        String unique_string = "";
        Set<Character> unique_string_map = new HashSet<>();
        Set<String> possible_substring_from_unique_string = new HashSet<>();

        // 1. Find Unique char string O(N)
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            // 1. Get Unique String
            if (!unique_string_map.contains(s.charAt(i))) {
                unique_string_map.add(s.charAt(i));
                builder.append(s.charAt(i));
            }
        }
        unique_string = builder.toString();


        // 2. Find all possible substring from above => O(N^3)
        possible_substring_from_unique_string = extractAllSubString(unique_string);

        // 3. Find all possible substring => O(N^3)
        all_possible_substring = extractAllSubString(s);


        // 4. loop all of possible_substring_from_unique_string
        // filter first if it's substrnig
        Iterator<String> itr = possible_substring_from_unique_string.iterator();
        while (itr.hasNext()) {
            String item = itr.next();
            if (all_possible_substring.contains(item)) {
                // If only item value is bigger then longest!
                if(item.length() > longest) {
                    longest = item.length();
                    longest_string = item;
                }
            }
        }

        return longest;
    }

    public Set<String> extractAllSubString(String s) {
        Set<String> list = new HashSet<>();

        for(int i = 0; i < s.length(); i++) {
            // 3.1. Get All possible substring
            for (int j = i; j < s.length(); j++) {
                int temp_index = i;
                String temp_string = "";
                // Get Substring by range.. (temp_index ~ j)
                while (temp_index <= j) {

                    temp_string = temp_string + s.charAt(temp_index);
                    if (temp_index == j ) {
                        list.add(temp_string);
                    }
                    temp_index++;
                }
                s.charAt(i);
            }
        }

        return list;
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


    public int lengthOfLongestSubstringLeetcode(String s) {

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
