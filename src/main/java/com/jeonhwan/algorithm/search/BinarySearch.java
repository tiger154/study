package com.jeonhwan.algorithm.search;

/**
 * O(LogN)
 */
public class BinarySearch {


    /**
     * Search data by normal iteration and return Index of the data
     * @param arr
     * @param target
     * @return
     */
    public static int search_itr(int[] arr, int target) {

        int low = 0, high = arr.length-1;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (target == arr[mid]) return mid;

            if (target > arr[mid])
                low = mid + 1;
            else
                high = mid -1;
        }
        return -1;
    }

    /**
     * Search by recursive
     * @param arr
     * @param low
     * @param high
     * @param mid
     * @param target
     * @return
     */
    public static int search_recursive(int[] arr, int low, int high, int mid, int target) {
        // exit condition
        if (low <= high) {
            // when found value
            if (arr[mid] == target) return mid;
            // actual logic
            if (target > arr[mid])
                return search_recursive(arr, mid+1, high, ((mid+1 + high) / 2), target);
            else
                return search_recursive(arr, low, mid-1, ((low + mid-1) / 2), target);
        }
        return -1;
    }

}
