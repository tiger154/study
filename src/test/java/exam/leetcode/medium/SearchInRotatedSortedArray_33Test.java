package exam.leetcode.medium;

import com.jeonhwan.algorithm.sort.MergeSort;
import com.jeonhwan.exam.leetcode.medium.SearchInRotatedSortedArray_33;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SearchInRotatedSortedArray_33Test {

    private static Logger log = LoggerFactory.getLogger(SearchInRotatedSortedArray_33Test.class);

    @Test
    public void solution_test1() {

        int[] nums = {4,5,6,7,0,1,2};

        SearchInRotatedSortedArray_33 solution =  new SearchInRotatedSortedArray_33();

        Assert.assertEquals(4, solution.first_approach(nums, 0));
        Assert.assertEquals(-1, solution.first_approach(nums, 3));
        Assert.assertEquals(-1, solution.first_approach(new int[]{1}, 0));

        log.debug("hey");
    }



    @Test
    public void solution_test2() {

        int[] nums = {4,5,6,7,0,1,2};

        SearchInRotatedSortedArray_33 solution =  new SearchInRotatedSortedArray_33();

        Assert.assertEquals(4, solution.second_approach(nums, 0));
        Assert.assertEquals(-1, solution.second_approach(nums, 3));
        Assert.assertEquals(-1, solution.second_approach(new int[]{1}, 0));

        log.debug("hey");
    }





}
