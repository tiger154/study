package com.jeonhwan.algorithm.sort;

import java.util.Arrays;

public class SelectionSort {

    private int[] data;
    public SelectionSort(int[] data) {
        this.data = data;
    }


    /**
     * looks better if it override from Interface
     *
     * Big O description
     *   - 10 + 9 + 8 ... + 2 + 1 => Arithmetic sequence
     *   - N * (N+1) / 2 => 10 * (10+1) / 2 => 55
     *   - O(n2) : In Big O, small amount number is deleted such as +, /
     *
     * Programming logic description
     *
     *   1. Find Most smallest value (left -> right)
     *   2. First index is smallest value
     *   3.(loop) if next value is smaller then change smallest value.
     *   4. When it hits end of index, change with current index and smallest value.
     *   5. Start from next element and so on.
     *
     * Mistake note
     *    1) Tried to use smallest val not index, but realize when try to swap, there is no way which index was smallest
     *    2) Last element must be biggest value, so it can loop length-1, ex) if 10 it can loop 9 only.
     *    3) Child loop's last must be full length, as first value is always i+1
     *       - index-range: 1 ~ 9
     *       - index-range: 2 ~ 9
     *       - index-range: 3 ~ 9
     *
     *    Tip: Next time must imagine each loop count limit
     * @return
     */
    public int[] sort() {

        int smallest_index;

        for (int i = 0; i < data.length-1; i++) {
            // 2. Set first value as smallest one
            smallest_index = i;
            for (int j=i+1; j < data.length; j++ ) {
                if(data[smallest_index] > data[j]) {
                    smallest_index = j;
                }
            }
            // swap
            int temp = data[smallest_index];
            data[smallest_index] = data[i];
            data[i] = temp;
        }
        return data;

    }
}
