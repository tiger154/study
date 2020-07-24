package exam.leetcode.easy;

import com.jeonhwan.algorithm.sort.MergeSort;
import com.jeonhwan.exam.leetcode.easy.RomanToInteger_13;
import com.jeonhwan.exam.leetcode.easy.ValidParentheses_20;
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
     *
     *  Note. First I had right direction
     *        Second I made bit much complex, Idea was good to make N/2 times but there were too many checking logics so looks dirty
     *           - It was dirty, but good try as it was totally unique way to solve the problem, but efficiency was low then I expected
     *        Third - Checked other's approach, and was So simple code, and it was same direction but mine was not elegant enough
     *
     */
    @Test
    public void test_man() {



           // test strings
           List<String> strings = Arrays.asList(
                   "()"
                   ,"()[]{}","(]","([)]","{[]}",""
           );


        ValidParentheses_20 solution = new ValidParentheses_20();
            // test and check result!
           for (String s : strings) {


               //boolean rtn  = this.brute_force(s);
               boolean rtn  = solution.third_approach(s);
               log.debug("string:{},  result: {}", s, rtn);
           }

    }




}
