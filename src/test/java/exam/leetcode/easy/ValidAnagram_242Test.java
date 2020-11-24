package exam.leetcode.easy;

import com.jeonhwan.exam.leetcode.easy.ValidAnagram_242;
import exam.leetcode.medium.GroupAnagrams_49Test;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class ValidAnagram_242Test {
    private static Logger log = LoggerFactory.getLogger(ValidAnagram_242Test.class);

    @Test
    public void is_anagram_first_test() {

        ValidAnagram_242 solution = new ValidAnagram_242();

        Assert.assertTrue(solution.first_approach("abb","bab"));
        Assert.assertFalse(solution.first_approach("abb","baa"));
        Assert.assertTrue(solution.first_approach("anagram","nagaram"));
        Assert.assertFalse(solution.first_approach("rat","car"));
        log.debug("done");
    }

    @Test
    public void is_anagram_second_test() {

        ValidAnagram_242 solution = new ValidAnagram_242();

        Assert.assertTrue(solution.second_approach("abb","bab"));
        Assert.assertFalse(solution.second_approach("abb","baa"));
        Assert.assertTrue(solution.second_approach("anagram","nagaram"));
        Assert.assertFalse(solution.second_approach("rat","car"));
        log.debug("done");
    }



}
