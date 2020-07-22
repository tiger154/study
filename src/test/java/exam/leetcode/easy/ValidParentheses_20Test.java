package exam.leetcode.easy;

import com.jeonhwan.algorithm.sort.MergeSort;
import com.jeonhwan.exam.leetcode.easy.RomanToInteger_13;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class ValidParentheses_20Test {
        private static Logger log = LoggerFactory.getLogger(MergeSort.class);


    /**
     *
     * 20. Valid Parentheses
     *
     * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
     *
     * An input string is valid if:
     *
     * Open brackets must be closed by the same type of brackets.
     * Open brackets must be closed in the correct order.
     * Note that an empty string is also considered valid.
     *
     * Example 1:
     *
     * Input: "()"
     * Output: true
     * Example 2:
     *
     * Input: "()[]{}"
     * Output: true
     * Example 3:
     *
     * Input: "(]"
     * Output: false
     * Example 4:
     *
     * Input: "([)]"
     * Output: false
     * Example 5:
     *
     * Input: "{[]}"
     * Output: true
     *
     *
     * ############################################################
     *
     *
     * So lets think about it we need to know open bracket in order
     *
     *
     * Set<String> OPEN_BRACKET = (,{,[;
     * Set<String> CLOSE_BRACKET = ),},];
     * map<String,String> BRACKET_PARE = (),{},[];
     *
     *
     *
     * // Use stack (LIFO)
     *
     * // SEARCH TO FIND OPENBRACKET -> O(N) time possible I guess!
     * FOUND_OPEN_BRACKET = [(,{,[ ]  --> OPEN BRACKET IN ORDER
     *   [}] --> IS THIS CLOSE BRACKET?
     *       1) If FOUND_OPEN_BRACKET is empty, then return false
     *       2) Get last item from FOUND_OPEN_BRACKET, and get from BRACKET_PARE, IF NOT MATCHED IT'S FALSE!
     *
     *
     * If until the end the que is not empty --> then error
     *
     *
     */
    @Test
    public void test_man() {



           // test strings
           List<String> strings = Arrays.asList(
                   "()"
                   //,"()[]{}","(]","([)]","{[]}",""
           );

            // test and check result!
           for (String s : strings) {
               //boolean rtn  = this.brute_force(s);
               boolean rtn  = this.second_approach(s);
               log.debug("string:{},  result: {}", s, rtn);
           }

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




            // if there is left elements...

            log.debug("left: {}, right:{}", left_chr, right_chr);
        }


//        // loop length of s
//        for (int i =0; i < s.length(); i++) {
//            // 1. if this is open bracket..
//            Character current_chr = s.charAt(i);
//            // 1. if this is open bracket
//            if (OPEN_BRACKET.contains(current_chr)) {
//                // put to stack
//                open_stack.push(s.charAt(i));
//                continue;
//            }
//            // 2. if this is close bracket
//            if (CLOSE_BRACKET.contains(current_chr)) {
//                // 2.1 check if stack is empty
//                if(open_stack.size() == 0) {return false;}
//                // 2.2
//                if (!BRACKET_PARE.get(open_stack.pop()).equals(current_chr)) {
//                    return false;
//                }
//                continue;
//            }
//        }
//
//        // if stack size is over zero, it means it failed to find matched-close bracket
//        if (open_stack.size() > 0) {
//            return false;
//        }

        return true;
    }



}
