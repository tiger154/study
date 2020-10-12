package exam.leetcode.medium;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FindFirstLastPositionOfElementInSortedArray_34Test {

    private static Logger log = LoggerFactory.getLogger(FindFirstLastPositionOfElementInSortedArray_34Test.class);

    @Test
    public void solution_test1() {


//        int[] nums = {5,7,7,8,8,10};
//
//        Assert.assertArrayEquals(new int[]{3,4}, first_approach(nums, 8));
//        Assert.assertArrayEquals(new int[]{-1,-1}, first_approach(new int[]{5,7,7,8,8,10}, 6));
//        Assert.assertArrayEquals(new int[]{-1,-1}, first_approach(new int[]{}, 8));
//
//
//        Assert.assertArrayEquals(new int[]{1,2}, first_approach(new int[]{1,2,2,3,4,5}, 2));
//
//        Assert.assertArrayEquals(new int[]{0,0}, first_approach(new int[]{1,2,2,3,4,5}, 1));
//        Assert.assertArrayEquals(new int[]{3,3}, first_approach(new int[]{1,2,2,3,4,5}, 3));
//        Assert.assertArrayEquals(new int[]{4,4}, first_approach(new int[]{1,2,2,3,4,5}, 4));
        Assert.assertArrayEquals(new int[]{5,5}, first_approach(new int[]{1,2,2,3,4,5}, 5));
//        Assert.assertArrayEquals(new int[]{-1,-1}, first_approach(new int[]{1,2,2,3,4,5}, 6));

    }


    /**
     *
     * Search two time for leftmost and rightmost. which means O(LogN * 2)
     *
     *
     *
     *
     * So how to look for left most
     *   - loop till low == high (not return right awy if find target value)
     *
     *   If middle == target then go to left
     *   If target < middle then go to left
     *     - as it's ascending if target is smaller then a value, target must be exist left side only
     *     - high = middle
     *   else go to right
     *     - low = middle+1
     *
     *
     * How to look for right most
     *
     *   If target < middle then go to left (that's same, but don't care same cases)
     *     - high = middle
     *   else go to right
     *     - low = middle+1
     *
     *
     *   I think there are many clever people wow
     *
     *   What I learned from here is binary search could have many tricky problems.
     *
     *   Draw algorithm as an image would be good to remember.
     *
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] first_approach(int[] nums, int target) {

        int[] result = {-1,-1};


        // find left most
        int left_idx = find_most_left_or_right_index(nums, target, true);


        // assert that left_idx is within the array bounds and that 'target' is actually in 'nums'
        if (left_idx == nums.length || nums[left_idx] != target)
            return result;


        // find right most

        result[0] = left_idx;
        result[1] = find_most_left_or_right_index(nums, target, false)-1;




        return result;
    }



    public int find_most_left_or_right_index(int[] nums, int target, boolean left) {
        int low = 0, high = nums.length;

        while (low < high) {
            int mid = (low + high) / 2;
            if (target < nums[mid] || (left && target == nums[mid])   ) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }


    /**
     * Refer: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/discuss/14699/Clean-iterative-solution-with-two-binary-searches-(with-explanation)
     *  - Through I want to define myself all rule one by one and implement!
     *
     *
     *
     *  1. Time complexity same as first approach
     *     - O(LogN * 2 )
     *  2. Through Binary search Get Left most and Right most
     *
     *  3. Left most rule
     *    1) If mid > target then go to left
     *       - hi = mid - 1
     *    2) if mid == target then go to left
     *       - hi = mid - 1
     *    3) if mid < target then go to right
     *      - lo = mid + 1
     *
     *
     *
     *  4. Right most rule
     *    1) if mid > target then go to left
     *       - hi = mid - 1
     *    2) if mid < target then go to right
     *       - lo = mid + 1
     *    3) if mid == target then go to right
     *       - lo = mid + 1
     *
     *
     *
     *
     *
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] second_approach(int[] nums, int target) {
        int[] result = {-1,-1};


        int lo = 0, hi = nums.length-1;
        // until it's same or lower.
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] >= target)
                hi = mid;
            else
                lo = mid+1;
        }

        // if it's over the range
        if (lo >= nums.length || nums[lo] != target)
            return result;

        log.debug("left most index: {}", lo);
        result[0] = lo;

        // now lets get right! as well
        hi = nums.length;
        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (nums[mid] > target)
                hi = mid;
            else if (nums[mid] <= target)
                lo = mid+1;

        }
        log.debug("right most index: {}", lo);
        result[1] = lo-1;






        return result;
    }

    @Test
    public void solution_test2() {

//        int[] nums = {5,7,7,8,8,10};
//        int[] result = second_approach(nums, 8);
//        second_approach(nums, 11);


        Assert.assertArrayEquals(new int[]{1,2}, second_approach(new int[]{1,2,2,3,4,5}, 2));

        Assert.assertArrayEquals(new int[]{0,0}, second_approach(new int[]{1,2,2,3,4,5}, 1));
        Assert.assertArrayEquals(new int[]{3,3}, second_approach(new int[]{1,2,2,3,4,5}, 3));
        Assert.assertArrayEquals(new int[]{4,4}, second_approach(new int[]{1,2,2,3,4,5}, 4));
        Assert.assertArrayEquals(new int[]{5,5}, second_approach(new int[]{1,2,2,3,4,5}, 5));
        Assert.assertArrayEquals(new int[]{-1,-1}, second_approach(new int[]{1,2,2,3,4,5}, 6));




        log.debug("hey");

    }


}
