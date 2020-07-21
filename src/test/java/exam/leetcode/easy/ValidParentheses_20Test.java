package exam.leetcode.easy;

import com.jeonhwan.algorithm.sort.MergeSort;
import com.jeonhwan.exam.leetcode.easy.RomanToInteger_13;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

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
     * // Use queue (FIFO)
     *
     * // SEARCH TO FIND OPENBRACKET
     * OPEN_BRACKET_IN_ORDER = [(,{,[ ]  --> OPEN BRACKET IN ORDER
     *   [}] --> IS THIS CLOSE BRACKET? THEN COMPARE.. FROM THE QUEUE , IF NOT MATCHED IT'S FALSE!
     *
     *
     *
     * If we find clse first --> then error
     * If untill the end the que is not empty --> then error
     *
     *
     */
    @Test
    public void test_man() {

           log.debug("hi there~");

       }



}
