package com.jeonhwan.exam.leetcode.medium;

public class ContainerWithMostWater_11 {

    /**
     * Two pointers approach
     *
     *   - If we set two pointers start/end, it means we gonna have most bigger width value.
     *   - And always smaller height from two point is the possible size of water.
     *
     *   - The smaller height pointer is now know most biggest size it can.
     *   - So we don't have to check other possible combinations anymore.
     *   - Thus, Delete or move to other pointer from the smaller height pointer.
     *     > if left < right then ++ or --
     *     > Until left is smaller then right or difference is > 0
     *
     *
     *   - Here why we don't have to check from bigger pointer to smaller pointer.
     *   - Even though you find bigger value, it can't be bigger then previous smaller value. (min(ai,aj))
     *   - Even though you find smaller value, we dont' need it as because what we need is maximum value.
     *
     *   - So here is prove
     *   - Formula to get a size from two points = S = (j-i) * min(ai, aj)
     *   - Let say i < j perhaps we check from bigger to smaller means => j-1
     *   - S' = (j-1-i) * min(ai, aj-1)
     *   - If S' is smaller then S we don't need to check
     *   - S` <= S
     *   - (j-1-i) * min(ai, aj-1) <= (j-i) * min(ai, aj)
     *   - (j-1-i) * ai <=  (j-i) * ai
     *
     *
     *
     * @param height
     * @return
     */
    public int bigON(int[] height) {

        // It must be at least two size
        if (height.length < 2) {
            return 0;
        }

        // So... let's set two pointer
        int left = 0;
        int right = height.length-1;
        int max = 0;

        // while N time or N-1 time (I think N-1 time)
        while (left<right) {

            int width = right-left;
            int temp_height = Math.min(height[left], height[right]);

            // 1. swap maximum value
            if(max < width * temp_height) {
                max = width * temp_height;
            }

            // 2. move pointers
            if(height[left] < height[right]) {
                left++;
            } else {
                right--;
            }

        }


        return max;
    }

    /**
     * pretty code from leetCode
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return maxarea;
    }


    /**
     * we can do memo as well
     *  - if x y is same in memo then skip calculation
     * @param height
     * @return
     */
    public int bigONSquare(int[] height) {

        int max = 0;


        for (int i =0; i < height.length; i++) {

            for (int j = i+1; j < height.length; j++) {

                // 1. get important vars
                int width = j - i;
                int smaller = (height[i] > height[j]) ? height[j] : height[i];

                // 3. CHECK
                if (max < width * smaller) {
                    max = width * smaller;
                }
                //System.out.println(" i(" + i  + ") * j(" + j  + ") = " + (height[i]*height[j]) + ", check width(" + width  + ") * smaller(" + smaller  + ") = " + (width*smaller));
            }

        }

        return max;
    }
}
