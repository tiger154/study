package exam.leetcode.easy;

import com.jeonhwan.algorithm.sort.MergeSort;
import com.jeonhwan.exam.leetcode.easy.ImplementStrStr_28;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class ImplementStrStr_28Test {
    private static Logger log = LoggerFactory.getLogger(MergeSort.class);

    private ImplementStrStr_28 solution;

    @Before
    public void init() {
        solution = new ImplementStrStr_28();
    }

    @Test
    public void solution_test_case1() {

        String haystack = "hello";
        String needle = "ll";

        int result = solution.third_approach(haystack, needle);
        Assert.assertEquals(result, 2);
    }

    @Test
    public void solution_test_case2() {
        String haystack = "aaaaa";
        String needle = "bba";
        int result = solution.third_approach(haystack, needle);
        Assert.assertEquals(result, -1);
    }

    @Test
    public void solution_test_case3() {
        String haystack = "Hello world!";
        String needle = "world";
        int result = solution.third_approach(haystack, needle);
        Assert.assertEquals(result, 6);
    }

    @Test
    public void solution_test_case4() {
        String haystack = "mississippi";
        String needle = "issip";
        int result = solution.third_approach(haystack, needle);
        Assert.assertEquals(result, 4);
    }

    @Test
    public void solution_test_case5() {
        String haystack = "";
        String needle = "a";
        int result = solution.third_approach(haystack, needle);
        Assert.assertEquals(result, -1);
    }

    @Test
    public void solution_test_case6() {
        String haystack = "mississippi";
        String needle = "pi";
        int result = solution.third_approach(haystack, needle);
        Assert.assertEquals(result, 9);
    }

    @Test
    public void solution_test_case7() {
        String haystack = "aaa";
        String needle = "a";
        int result = solution.third_approach(haystack, needle);
        Assert.assertEquals(result, 0);
    }




}
