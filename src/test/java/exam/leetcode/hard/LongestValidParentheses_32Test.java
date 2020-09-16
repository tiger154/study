package exam.leetcode.hard;

import com.jeonhwan.algorithm.sort.MergeSort;
import com.jeonhwan.exam.leetcode.hard.LongestValidParentheses_32;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Stack;

public class LongestValidParentheses_32Test {

    private static Logger log = LoggerFactory.getLogger(MergeSort.class);

    @Test
    public void solution_test() {

        //String s = "((())";
        //int result = bruteforce_approach(s);

//        String s = "())((())";
//        int result = dynamic_approach(s);

//        String s = "())((())";
//        int result = third_approach(s);

        String s = "())((())";
        LongestValidParentheses_32 solution = new LongestValidParentheses_32();
        int result = solution.third_approach(s);


        log.debug("hi there");
    }

}
