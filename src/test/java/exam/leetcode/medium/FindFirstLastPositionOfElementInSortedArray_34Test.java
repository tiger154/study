package exam.leetcode.medium;

import com.jeonhwan.exam.leetcode.medium.FindFirstLastPositionOfElementInSortedArray_34;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FindFirstLastPositionOfElementInSortedArray_34Test {

    private static Logger log = LoggerFactory.getLogger(FindFirstLastPositionOfElementInSortedArray_34Test.class);

    @Test
    public void solution_test1() {

        FindFirstLastPositionOfElementInSortedArray_34 solution = new FindFirstLastPositionOfElementInSortedArray_34();
        int[] nums = {5,7,7,8,8,10};

        Assert.assertArrayEquals(new int[]{3,4}, solution.first_approach(nums, 8));
        Assert.assertArrayEquals(new int[]{-1,-1}, solution.first_approach(new int[]{5,7,7,8,8,10}, 6));
        Assert.assertArrayEquals(new int[]{-1,-1}, solution.first_approach(new int[]{}, 8));


        Assert.assertArrayEquals(new int[]{1,2}, solution.first_approach(new int[]{1,2,2,3,4,5}, 2));

        Assert.assertArrayEquals(new int[]{0,0}, solution.first_approach(new int[]{1,2,2,3,4,5}, 1));
        Assert.assertArrayEquals(new int[]{3,3}, solution.first_approach(new int[]{1,2,2,3,4,5}, 3));
        Assert.assertArrayEquals(new int[]{4,4}, solution.first_approach(new int[]{1,2,2,3,4,5}, 4));
        Assert.assertArrayEquals(new int[]{5,5}, solution.first_approach(new int[]{1,2,2,3,4,5}, 5));
        Assert.assertArrayEquals(new int[]{-1,-1}, solution.first_approach(new int[]{1,2,2,3,4,5}, 6));

    }




    @Test
    public void solution_test2() {

        FindFirstLastPositionOfElementInSortedArray_34 solution = new FindFirstLastPositionOfElementInSortedArray_34();

        int[] nums = {5,7,7,8,8,10};

        int[] result = solution.second_approach(nums, 8);



        Assert.assertArrayEquals(new int[]{1,2}, solution.second_approach(new int[]{1,2,2,3,4,5}, 2));

        Assert.assertArrayEquals(new int[]{0,0}, solution.second_approach(new int[]{1,2,2,3,4,5}, 1));
        Assert.assertArrayEquals(new int[]{3,3}, solution.second_approach(new int[]{1,2,2,3,4,5}, 3));
        Assert.assertArrayEquals(new int[]{4,4}, solution.second_approach(new int[]{1,2,2,3,4,5}, 4));
        Assert.assertArrayEquals(new int[]{5,5}, solution.second_approach(new int[]{1,2,2,3,4,5}, 5));
        Assert.assertArrayEquals(new int[]{-1,-1}, solution.second_approach(new int[]{1,2,2,3,4,5}, 6));




        log.debug("hey");

    }


}
