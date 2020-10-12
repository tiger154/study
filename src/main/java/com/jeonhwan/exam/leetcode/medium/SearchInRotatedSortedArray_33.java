package com.jeonhwan.exam.leetcode.medium;

public class SearchInRotatedSortedArray_33 {



    /**
     *
     * Key point here is how to decide which side first should look at.
     * Basically it just look up ordered part only and repeat.
     * Time complexity is same as O(LogN)
     *
     *
     * 1. Rotating mean from random index position, it swap left and right.
     * 2. Use binary search because -> It's ordered already(Just little tweak exist)
     * 3. First check middle belongs to left or right
     *
     *
     *    if middle > low --> It belongs to left
     *
     *       if target > middle : Stay Right: low = middle + 1
     *       if target < low : Go to Right: low = middle + 1
     *
     *       if target > middle || target < low then middle + 1
     *
     *       else  Stay left: high = middle-1
     *
     *
     *
     *    else            --> It belongs to right
     *       if target > high: Go to Left
     *       if target < middle: Go to: Left
     *
     *       if target > high || target < middle then high = middle-1
     *
     *       else Stay Right : low = middle +1
     *
     * @return
     */
    public int first_approach(int[] nums, int target) {

        int low = 0, high = nums.length -1;

        // lets do while
        while (low <= high) {

            int middle = (low + high) / 2;

            if (target == nums[middle]) return middle;

            // left component
            if (nums[low] <= nums[middle]) {

                if (target > nums[middle] || target < nums[low])
                    low = middle + 1;
                else
                    high = middle - 1;

                // right component
            } else {

                if (target > nums[high] || target < nums[middle])
                    high = middle -1;
                else
                    low = middle + 1;
            }
        }
        return -1;
    }


    /**
     *
     * All same but lets make it simple!
     *
     * Compare condition only check if target is in ordered section side
     *
     *
     * @return
     */
    public int second_approach(int[] nums, int target) {

        int low = 0, high = nums.length -1;

        while (low <= high) {

            int middle = (low + high) / 2;

            if (target == nums[middle]) return middle;

            // left side
            if (nums[low] <= nums[middle]) {
                if (target >= nums[low] && target < nums[middle])
                    high = middle - 1;
                else
                    low = middle + 1;
            } else {
                if (target > nums[middle] && target <= nums[high])
                    low = middle + 1;
                else
                    high = middle - 1;
            }
        }
        return -1;
    }


}
