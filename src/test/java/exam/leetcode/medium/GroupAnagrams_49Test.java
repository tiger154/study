package exam.leetcode.medium;

import com.jeonhwan.exam.leetcode.medium.GroupAnagrams_49;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class GroupAnagrams_49Test {

    private static Logger log = LoggerFactory.getLogger(GroupAnagrams_49Test.class);

    @Test
    public void group_anagrams_test() {

        GroupAnagrams_49 solution =  new GroupAnagrams_49();

        // ["eat","tea","tan","ate","nat","bat"]
        String[] strs = new String[] {"eat","tea","tan","ate","nat","bat"};

        List<List<String>> expected = new ArrayList<List<String>>(){{
            add(Arrays.asList("eat","tea","ate"));
            add(Arrays.asList("bat"));
            add(Arrays.asList("tan","nat"));
        }};

        List<List<String>> actual = solution.first_approach(strs);
        //List<List<String>> actual = solution.second_approach(strs);
        Assert.assertEquals(expected, actual);

        log.debug("lets check data");

    }





}
