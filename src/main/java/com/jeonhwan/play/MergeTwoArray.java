package com.jeonhwan.play;


/**
 * This is for testing many way to merge arrays
 *
 *  1) O(M*N)
 *    - Insertion sort way
 *    (1) put together two array
 *    (2) Insertion Point is First index of second array
 *       arrayA.length is Starting point to compare
 *
 *    (3) From start point compare with arr[current_index-1]
 *      - while arrayB length
 *        - while If (arr[current_index-1] > arr[current_index])
 *           then swap data and current_index--
 *
 *
 *  2) O(M+N)
 *    - Merge sort way -> I can picture this more easy way
 *
 *
 */
public class MergeTwoArray {
    int[] left;
    int[] right;

    public MergeTwoArray() {}
    public MergeTwoArray(int[] left, int[] right) {
        this.left = left;
        this.right = right;
    }


    /**
     * loop M+N time so O(m+n)
     * and find median -- good to practice again
     *
     * @return
     */
    public int[] mergeWithMergeFunc() {

        int left_index = 0;
        int right_index = 0;
        int merged_index = 0;
        int[] merged_array = new int[left.length + right.length];

        // 1. while left.length && right.length is end!
        while (left_index < left.length && right_index < right.length) {
            // 2. compare each index (basic)
            if (left[left_index] < right[right_index]) {
                merged_array[merged_index] = left[left_index];
                merged_index++;
                left_index++;
            } else {
                merged_array[merged_index] = right[right_index];
                merged_index++;
                right_index++;
            }
        }

        // If there is left one need to put all the others to
        if (right_index >= right.length && right_index > left_index) {
            for (int i = left_index; i < left.length; i++) {
                merged_array[merged_index] = left[i];
                merged_index++;
            }
        }
        if (left_index >= left.length && left_index > right_index) {
            for (int i = right_index; i < right.length; i++) {
                merged_array[merged_index] = right[i];
                merged_index++;
            }
        }


        return merged_array;
    }


    /**
     * 1) MergeTwo Array And Sort => O(M*N)
     *  - Inefficient way but good to practice for warming up.
     *
     * @return
     */
    public int[] mergeWithInsertionMerge() {
        // 1. create new array
        int[] merged_array = new int[left.length + right.length];

        // 2. Copy all data to new merged array -> N time.. already Hm..
        for(int i =0; i < left.length; i++) {
            merged_array[i] = left[i];
        }
        for(int i = 0; i < right.length; i++) {
            int merged_array_index = left.length + i;
            merged_array[merged_array_index] = right[i];
        }

        // 3. Check start point
        int index = 0;
        // 4. while till length of right
        while (index < right.length) {
            int insertion_index = left.length + index;
            // 4. start sorting
            while (insertion_index-1 >= 0 && merged_array[insertion_index-1] > merged_array[insertion_index]) {
                // 4.1 swap data
                int temp = merged_array[insertion_index];
                merged_array[insertion_index] = merged_array[insertion_index-1];
                merged_array[insertion_index-1] = temp;
                // 4.2 and go to left
                insertion_index--;
            }
            index++;
        }
        return merged_array;
    }

    public float findMedian(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        // 1. if it's odd
        if (array.length%2 != 0) {
           return (float)array[array.length/2];
        } else {
            return (float)(array[(array.length/2) - 1]+ array[array.length/2]) / 2;
        }
    }


    public float findMedianFromTwoSortedArray() {
       int[] merged_array = mergeWithInsertionMerge();
       return findMedian(merged_array);
    }

}
