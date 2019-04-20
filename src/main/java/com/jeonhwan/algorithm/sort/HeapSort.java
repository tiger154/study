package com.jeonhwan.algorithm.sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HeapSort {

    private static Logger log = LoggerFactory.getLogger(HeapSort.class);

    private int[] data;
    public HeapSort(int[] data) {
        this.data = data;
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

        return data;
    }
}
