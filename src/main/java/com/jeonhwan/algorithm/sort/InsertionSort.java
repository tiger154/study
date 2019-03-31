package com.jeonhwan.algorithm.sort;

public class InsertionSort {
    private int[] data;
    public InsertionSort(int[] data) {
        this.data = data;
    }

    /**
     *
     * Big O(N^2)
     *   - 10 + 9 + 8 ... + 2 + 1 => Arithmetic sequence
     *   - N * (N+1) / 2 => 10 * (10+1) / 2 => 55
     *   - O(n2) : In Big O, small amount number is deleted such as +, /
     *
     * Logic
     *   - Left part is always sorted. so from parent index, it goes to left until hit smaller value
     *   1) Parent loop left -> right, 1-9
     *   2) Child loop right -> left. child index start from parent index. And minus calculation.
     *     - if current index is smaller then left element swap, not break.
     *     - current index must be bigger then zero
     *
     *
     * Data sorting scenario
     *   [5,2,6,9,8,7,10,1,3,4]
     *   [2,5,6,9,8,7,10,1,3,4] 1
     *   [2,5,6,9,8,7,10,1,3,4] 2
     *   [2,5,6,9,8,7,10,1,3,4] 3
     *   [2,5,6,8,9,7,10,1,3,4] 4
     *   [2,5,6,7,8,9,10,1,3,4] 5
     *   ...
     *  Mistake note
     *    - Didn't think about it must be bigger then zero on child loop
     *    - Didn't give break condition on child loop
     *
     * @return
     */
    public int[] sort() {
        // 1. Parent left -> right(1-9) -> start: 1, end: length
        for (int i=1; i < data.length; i++) {
            // 2. Child right -> left: 1-0, 2 -0, ... 9 - 0 -> start 1, end 1,2..9 i && i > 0, minus condition
            //    It must be bigger then 0
            //    This part also can be implemented with while condition
            for (int j=i; j <= i && j > 0; j--) {
                if (data[j-1] > data[j]) {
                    // swap
                    int temp = data[j-1];
                    data[j-1] = data[j];
                    data[j] = temp;
                } else {
                    break;
                }
            }
        }
        return data;
    }
}
