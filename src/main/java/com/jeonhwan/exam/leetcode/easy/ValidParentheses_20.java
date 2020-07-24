package com.jeonhwan.exam.leetcode.easy;

import java.util.*;

public class ValidParentheses_20 {

    /**
     * It can be O(n/2)
     * @param s
     * @return
     */
    public boolean second_approach(String s) {
        // if empty it's valid
        if(s == "") {  return true;}
        // if it's not even number its just wrong
        if(s.length() % 2 > 0) {  return false;}

        // 1. Set vars
        Set<Character> OPEN_BRACKET = new HashSet<>(Arrays.asList('(','{','['));
        Set<Character> CLOSE_BRACKET = new HashSet<>(Arrays.asList(')','}',']'));
        Map<Character,Character> BRACKET_OPEN_PARE = new HashMap<Character, Character>(){{
            put('(',')');
            put('{','}');
            put('[',']');
        }};
        Map<Character,Character> BRACKET_CLOSE_PARE = new HashMap<Character, Character>(){{
            put(')','(');
            put('}','{');
            put(']','[');
        }};

        // to save open bracket found
        Stack<Character> open_stack = new Stack<>();
        Stack<Character> close_stack = new Stack<>();
        Stack<Character> reverse_close_stack = new Stack<>();

        // if length is just two we can calculate only one time
        // "){"
        if (s.length() == 2) {
            if(BRACKET_OPEN_PARE.get(s.charAt(0)) == null) {
                return false;
            }
            if (!BRACKET_OPEN_PARE.get(s.charAt(0)).equals(s.charAt(1))) {
                return false;
            } else {
                return true;
            }
        }


        // loop N/2 time
        for (int i =0; i < s.length()/2; i++) {
            Character left_chr = s.charAt(i);                   // left > right
            Character right_chr = s.charAt(s.length()-(i+1));   // right > left

            // left char
            if (OPEN_BRACKET.contains(left_chr)) {
                open_stack.push(left_chr);
            } else if (CLOSE_BRACKET.contains(left_chr)) {
                if(open_stack.size() == 0) {return false;}
                if (!BRACKET_OPEN_PARE.get(open_stack.pop()).equals(left_chr)) {
                    return false;
                }
            }

            //  right chr
            if (CLOSE_BRACKET.contains(right_chr)) {
                close_stack.push(right_chr);
            } else if (OPEN_BRACKET.contains(right_chr)) {
                if(close_stack.size() == 0) {return false;}
                if (!BRACKET_CLOSE_PARE.get(close_stack.pop()).equals(right_chr)) {
                    return false;
                }
            }
        }

        // compare close_stack == open_stack is same  O(1)
        if(close_stack.size() != open_stack.size()) {
            return false;
        }


        // till open stack is zero compare
        while (open_stack.size() > 0) {
            Character ob = open_stack.pop(); // (
            Character cb = close_stack.pop(); // )
            if (!BRACKET_OPEN_PARE.get(ob).equals(cb)) {
                return false;
            }
        }
        return true;
    }




    /**
     * I think this is O(N) as loop as length of s
     *   - Hm but it's so slow... how to make it faster??
     *
     * @param s
     * @return
     */
    public boolean brute_force(String s) {
        // if empty it's valid
        if(s == "") {  return true;}
        // if it's not even number its just wrong
        if(s.length() % 2 > 0) {  return false;}

        // 1. Set vars
        Set<Character> OPEN_BRACKET = new HashSet<>(Arrays.asList('(','{','['));
        Set<Character> CLOSE_BRACKET = new HashSet<>(Arrays.asList(')','}',']'));
        Map<Character,Character> BRACKET_PARE = new HashMap<Character, Character>(){{
            put('(',')');
            put('{','}');
            put('[',']');
        }};

        // to save open bracket found
        Stack<Character> open_stack = new Stack<>();


        // loop length of s
        for (int i =0; i < s.length(); i++) {
            // 1. if this is open bracket..
            Character current_chr = s.charAt(i);
            // 1. if this is open bracket
            if (OPEN_BRACKET.contains(current_chr)) {
                // put to stack
                open_stack.push(s.charAt(i));
                continue;
            }
            // 2. if this is close bracket
            if (CLOSE_BRACKET.contains(current_chr)) {
                // 2.1 check if stack is empty
                if(open_stack.size() == 0) {return false;}
                // 2.2
                if (!BRACKET_PARE.get(open_stack.pop()).equals(current_chr)) {
                    return false;
                }
                continue;
            }
        }

        // if stack size is over zero, it means it failed to find matched-close bracket
        if (open_stack.size() > 0) {
            return false;
        }

        return true;
    }


    public boolean third_approach(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            // ch is '(' or '[' or '{'
            if (!map.containsKey(ch)) stack.push(ch);
                // ch is ')' or ']' or '}'
            else if (stack.isEmpty() || stack.pop() != map.get(ch)) return false;
        }
        return stack.isEmpty();
    }



}
