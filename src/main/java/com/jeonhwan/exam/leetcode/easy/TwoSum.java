package com.jeonhwan.exam.leetcode.easy;

public class TwoSum {


    /**
     *  1) O(N^2) - Worst Time complexity but easy to implement
     *  TODO: It should be O(N) level using HashMap
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {

        // Big O(N^2)

        int i_index = 0;
        int j_index = 0;
        boolean found = false;

        for(int i = 0; i < nums.length-1; i++) {

            for(int j=i+1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                if (sum == target) {
                    j_index = j;
                    i_index = i;
                    break;
                }
            }

        }

        int[] input_data = {i_index,j_index,};
        return input_data;
    }


    public int[] twoSumBigON(int[] nums, int target) {

      return null;
    }

}
