package exam.leetcode.medium;

import com.jeonhwan.algorithm.sort.MergeSort;
import com.jeonhwan.exam.leetcode.medium.Permutations_46;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations_46Test {

    private static Logger log = LoggerFactory.getLogger(Permutations_46Test.class);

    @Test
    public void substring_test() {
        String a = "1234";
        int i = 0;
        Assert.assertEquals("234", ((i > 0) ? a.substring(0,i) : "") + a.substring(i+1));
        i = 1;
        Assert.assertEquals("134", ((i > 0) ? a.substring(0,i) : "") + a.substring(i+1));
        i = 2;
        Assert.assertEquals("124", ((i > 0) ? a.substring(0,i) : "") + a.substring(i+1));
        i = 3;
        Assert.assertEquals("123", ((i > 0) ? a.substring(0,i) : "") + a.substring(i+1));
    }






    @Test
    public void test_p() {

        Permutations_46 solution = new Permutations_46();

        List<List<Integer>> final_list = new ArrayList<>();
        String str = "1234";
        solution.first_solution_("", str, final_list, 0, 3);

        log.debug("hi there");

    }



    @Test
    public void test_p_2() {
        Permutations_46 solution = new Permutations_46();

        int[] nums = new int[]{0,-1,1};
        //int[] nums = new int[]{1,2,3};

        List<List<Integer>> rtn = solution.first_solution(nums);

        log.debug("hi there");

    }




    @Test
    public void test_p_3() {
        Permutations_46 solution = new Permutations_46();

        //int[] nums = new int[]{1,2};
        //int[] nums = new int[]{1,2,3};
        int[] nums = new int[]{0,-1,1};

        List<List<Integer>> rtn = solution.second_solution(nums);

        for (List<Integer> list:
             rtn) {
            log.debug("list: {}", list);
        }

        log.debug("hi there");

    }





}
