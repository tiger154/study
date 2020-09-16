package com.jeonhwan.exam.leetcode.hard;

import java.util.Stack;

public class LongestValidParentheses_32 {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else if (!stack.empty() && stack.peek() == '(') {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.empty();
    }

    /**
     * Find every possible substring
     *
     * Time complexity : O(n^3). Generating every possible substring from a string of length nn requires O(n^2).
     * Checking validity of a string of length nn requires O(n).
     *
     *
     *
     * @param s
     * @return
     */
    public int bruteforce_approach(String s) {
        int maxlen = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 2; j <= s.length(); j+=2) {
                if (isValid(s.substring(i, j))) {
                    maxlen = Math.max(maxlen, j - i);
                }
            }
        }
        return maxlen;
    }




    /**
     * O(n).
     *
     * This is really hard to come up in time.
     * So for now gonna skim and understand logic generally.
     *
     * make dp array, which same length with given string's length
     * each index represent length of longest valid substring.
     *
     * '(' is always 0. so we only update value when we meet ')'.
     *
     * 1. we gonna check every two consecutive characters of the string
     *  1) s[i] = ')' and s[i-1] = '(' => '()'
     *    - dp[i] = dp[i-2] + 2
     *  2) s[i] = ')' and s[i-1] = ')' => '))'
     *    and if s[i - dp[i-1] -1 ] = '(' then
     *    - dp[i] = dp[i-1] + dp[i- dp[i-1] -2] + 2
     *
     *  Wow hard to even understand second formula ! shit
     *
     * @param s
     * @return
     */
    public int dynamic_approach(String s) {
        int maxans = 0;
        int dp[] = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }


    /**
     * Using stack it's really simple approach. I like this idea.
     *
     * Instead of finding every possible string and checking its validity,
     * We can make use of stack while scanning the given string to check if
     * the string scanned so far is valid, and also length of the longest valid string.
     * In order to do so, we start by pushing -1 onto the stack.
     *
     * For every '(' encountered, we push its index onto the stack.
     *
     * For every ')' encountered, we pop the topmost element and subtract(minus)
     * the current element's index from the top element of the stack,
     * which gives the length of the currently encountered valid string of parentheses.
     *
     * If while popping the element, the stack becomes empty, we push the current element's index on to the stack.
     * In this way, we keep on calculating the lengths of the valid substrings,
     * and return the length of the longest valid string at the end.
     *
     *
     *
     * @param s
     * @return
     */
    public int third_approach(String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }


    public int fourth_approach(String s) {
        // create an array to mark valid parenthesis.
        int[] arr = new int[s.length()];

        // use a stack to store location of opening brackets.
        Stack<Integer> stack = new Stack<>();
        for(int k=0; k<s.length(); k++) {
            // if opening bracket is found, push its location onto the stack.
            if (s.charAt(k) == '(') {
                stack.add(k);
            }
            // if closing bracket is found and stack is not empty, that means the
            // the current closing bracket is a pair of the opening bracket at location
            // available at stack.peek().
            // mark both location as valid in the array.
            else if (s.charAt(k) == ')') {
                if (!stack.isEmpty()) {
                    int top = stack.pop();
                    arr[top] = 1;
                    arr[k] = 1;
                }
            }
        }
        // find maximum of continuous valid locations in the array.
        int max = 0;
        int curr = 0;
        for(int k=0; k<arr.length; k++) {
            if(arr[k] == 1) {
                curr++;
            }
            else {
                max = Math.max(curr, max);
                curr = 0;
            }
        }
        return Math.max(curr, max);
    }

}
