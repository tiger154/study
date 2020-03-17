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
     *    2. pseudo code
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
     *      1 3
     *      2
     *
     *      1 5
     *      9
     *
     *
     *      if it fail to find bigger part from right array
     *
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
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // logic is simple here, finding partition is first but
        // He mention



        return 0;
    }






}
