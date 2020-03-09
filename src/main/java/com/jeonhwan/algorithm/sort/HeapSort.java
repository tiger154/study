package com.jeonhwan.algorithm.sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Stack;


/**
 * HeapSort
 *
 *<br><br>
 *<h3> 1. English Description </h3>
 *<pre>
 *     1) Key note
 *       (1) Heap
 *       (2) Heapify
 *          - Given parent index, check child(left,right) and swap if parent is smaller of them
 *          - And Go down to child if it exist So it make all keep state always
 *       (3) Sort
 *          (1) swap
 *          (2) heapify (top->bottom, bottom->top)
 *
 *     2) Big O notation
 *
 *
 *</pre>
 *
 *<br><br>
 *<h3> 2. Korean Description </h3>
 *<pre>
 *     1) 주요 포인트
 *     2) Big O
 *
 *</pre>
 */
public class HeapSort {

    private static Logger log = LoggerFactory.getLogger(HeapSort.class);

    private int[] data;
    public HeapSort() {}
    public HeapSort(int[] data) {
        this.data = data;
    }
    public int[] getData(){return  this.data;}


    // 1. Gonna make Heapify first and test!
    // Max heap first!
    public void heapify(int parent_index) {

        // 5 / 2 - 1 = 1
        // So it's gonna work only one time
        // data : ex [11 5 8 7 4 ]

        // 1. Get Left Child Index
        int left_child_index = parent_index * 2 + 1;
        // 2. Get Right Child index
        int right_child_index = parent_index * 2 + 2;
        // 3. If it's swaped(Heapified), we need to know which child index is swaped
        //    So we can go down to the
        boolean is_swaped = false;
        int swaped_index = 0;

        // 1. if parent < left then swap

        if (data.length > left_child_index && data[parent_index] < data[left_child_index]) {
            // swap
            swap(parent_index, left_child_index);
            is_swaped = true;
            swaped_index = left_child_index;
        }

        // 2. if parent < right then swap
        if (data.length > right_child_index && data[parent_index] < data[right_child_index]) {
            // swap
            swap(parent_index, right_child_index);
            is_swaped = true;
            swaped_index = right_child_index;
        }

        // heapfify for child!
        if(is_swaped) {
            heapify(swaped_index);
        }

    }


    public void swap (int a, int b) {
        int temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }





    /**
     * O(N)
     *   1) Make Heap structure first
     *   2) Order
     *
     *
     * Perfect binary tree.
     *   - A node can have maximum two nodes only
     *   - It puts data from left to right
     *
     * 1. Heap is used to find smallest or biggest value from perfect binary tree.
     * 2. Max Heap: Parent node is bigger then child nodes
     * 3. Min Heap: Child node is smaller then child nodes
     * 4. Heapify Algorithm : If one node break heap, it used to make proper structure(for only one node)
     *
     * @return
     */
    public int[] sort() {



        int size = data.length;
        // init data
        for (int parent_index = size / 2 -1 ; parent_index > 0; parent_index--) {

            // swap
            // heapfify  int parent_index = size / 2 -1;
            heapify(parent_index);

        }


        return data;
    }


}
