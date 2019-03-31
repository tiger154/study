package com.jeonhwan.algorithm.sort;

public class BubbleSort {
    private int[] data;

    public BubbleSort(int[] data) {
        this.data = data;
    }

    /**
     * Big O(N^2)     *
     *   - 10 + 9 + 8 ... + 2 + 1 => Arithmetic sequence
     *   - N * (N+1) / 2 => 10 * (10+1) / 2 => 55
     *   - O(n2) : In Big O, small amount number is deleted such as +, /
     *
     * Logic
     *   1) Left -> Right
     *   2) Bubble sort loop start always from index 0
     *   3) Last node must be ordered value. And it's decreased by Parent loop index
     *     - 1-9, 1-8, 1-7,...1-2
     *
     * Data sorting scenario
     *
     *   [5,2,6,9,8,7,10,1,3,4] 1 9
     *   [2,5,6,8,7,9,1,3,4,10] 2 8
     *   [2,5,6,7,8,1,3,4,9,10] 3 7
     *   [2,5,6,7,1,3,4,8,9,10] 4 6
     *   [2,5,6,1,3,4,7,8,9,10] 5 5
     *   [2,5,1,3,4,6,7,8,9,10] 6 4
     *   [2,1,3,4,5,6,7,8,9,10] 7 3
     *   [1,2,3,4,5,6,7,8,9,10] 8 2
     *   [1,2,3,4,5,6,7,8,9,10] 9 1
     * @return
     */
    public int[] sort() {

        // Last node is sorted so don't have to go end of element (0-8)
        for(int i =0; i <data.length-1; i++) {
            // 2. Last node is sorted, so decrease of limit  (length - i), ex) 0-9,0-8,...0-1
            for (int j = 1; j < data.length-i; j++) {
                if (data[j-1] > data[j]) {
                    // swap index here
                    int temp = data[j];
                    data[j] = data[j-1];
                    data[j-1] = temp;
                }
            }
        }
        return data;
    }


}
