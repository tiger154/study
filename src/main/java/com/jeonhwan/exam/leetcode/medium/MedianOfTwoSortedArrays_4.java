package com.jeonhwan.exam.leetcode.medium;

import java.util.Stack;

public class MedianOfTwoSortedArrays_4 {


    /**
     * Median Of Two Sorted Arrays
     *  - May we can also add sorted function here
     *
     *<br><br>
     *<h3> 1. English Description </h3>
     *<pre>
     *     1. Definition
     *      - Given array A, B
     *      > If A[i] < B[x] then A[i]'s left part is smaller then B[x]
     *      > If B[j] < A[y] then B[j]'s left part is smaller then A[y]
     *      > max(A[i], B[j]) is smaller then min(A[y],B[j])
     *
     *    2. How to find each partition
     *      - To make LogN => Log(min(n,m)). We can use Binary search.
     *
     *      1) Should partition balanced as multi array.
     *      2) So try to find middle first and by the result, we can go to left or right
     *        and find middle again
     *      3) If partitionX is 0, it means there are no more left, if partitionX is A's length no more right
     *        - If partitionX is 0 =>
     *        - partitionX is A's length =>
     *
     *
     *
     *
     *      if n > m
     *       i = 0 ~ m
     *       j = m + n + 1 / 2 - i;
     *
     *     So..
     *        int i_min = 0
     *        int i_max = m => x.length
     *     Binary search
     *        set i = i_min + i_max / 2
     *        set j = (m + n + 1) / 2 - i
     *
     *     if( A[i-1] < B[j] && A[j-1] < B[i] ) {
     *         -- we found partition.
     *     }
     *
     *
     *
     *
     *
     *
     *    3. pseudo code
     *
     *     int[] A; // {1,3,4}
     *     int[] B; // {2,5}
     *
     *     if total length is even
     *       return (float) max(A[i], B[j]) + min(A[y],B[j]) / 2 => median
     *     else
     *
     *       if left.length > right.length
     *         return max(A[i], B[j])
     *       else
     *         return min(A[y],B[j])
     *
     *
     *
     *
     *</pre>
     *
     *<br><br>
     *<h3> 2. Korean Description </h3>
     *<pre>

     *</pre>
     *
     *
     */
    public float findMedianSortedArraysBigOLogMinN(int[] nums1, int[] nums2) {


        int x = nums1.length;
        int y = nums2.length;
        if(x > y)
            return findMedianSortedArraysBigOLogMinN(nums2, nums1);
        int low = 0;
        int high = x;
        while(low <= high)  {
            int partitionX = (low + high)/2;
            int partitionY = (x+y+1)/2-partitionX;
            //if partitionX is 0 it means nothing is there on left side. Use -INF for maxLeftX
            //if partitionX is length of input then there is nothing on right side. Use +INF for minRightX
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = (partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX];

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = (partitionY == y) ? Integer.MAX_VALUE : nums2[partitionY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                //We have partitioned array at correct place
                // Now get max of left elements and min of right elements to get the median in case of even length combined array size
                // or get max of left for odd length combined array size.
                if ((x + y) % 2 == 0) {
                    return ((float)Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))/2;
                } else {
                    return (float) Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) { //we are too far on right side for partitionX. Go on left side.
                high = partitionX - 1;
            } else { //we are too far on left side for partitionX. Go on right side.
                low = partitionX + 1;
            }

        }
        return 0;

    }

    /**
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public float findMedianSortedArraysBigONlogN(int[] nums1, int[] nums2) {

        int i =0;
        int j =0;
        int k =0;
        int[] arr = new int[ nums1.length + nums2.length];
        boolean should_merge = true;

        if (nums1.length == 0 && nums2.length == 0) {
            return 0;
        }


        if (nums1.length == 0 && nums2.length > 0) {
            arr = nums2;
            should_merge = false;
        }
        if (nums2.length == 0 && nums1.length > 0) {
            arr = nums1;
            should_merge = false;
        }


        if(should_merge) {
            // 1. merge array (Merge sort way)
            int index = 0;
            // while only under min(nums1.length, nums2.length) time
            while (i < nums1.length && j < nums2.length) {
                // compare nums1 && nums2
                // if nums1 is smaller then put new array and increase i
                if (nums1[i] < nums2[j]) {
                    arr[k] = nums1[i];
                    i++;
                    k++;
                } else {
                    arr[k] = nums2[j];
                    j++;
                    k++;
                }
                index++;
            }

            // if right array left, put all left part from right array
            if (i > j || (nums2.length - j) > 0) {
                for (int jj = j; jj < nums2.length; jj++) {
                    arr[k] = nums2[jj];
                    k++;
                }
            }

            if (j > i || (nums1.length - i) > 0) {
                for (int ii = i; ii < nums1.length; ii++) {
                    arr[k] = nums1[ii];
                    k++;
                }
            }


        }


        // 2. find median simple way
        if (arr.length == 1) {
            return arr[0];
        }

        if (arr.length%2 > 0) {
            return (float) arr[arr.length/2];
        } else {
            return (float) (arr[arr.length/2] + arr[(arr.length/2) - 1]) / 2;
        }
    }






}
