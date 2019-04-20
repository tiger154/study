package com.jeonhwan.algorithm.sort;

public class MergeSort {

    private int[] data; // 원본 데이터
    private int[] temp; // 조작 데이터 -> 조작 데이터를 기준으로 정렬 수행후 반환한다.
    public MergeSort(int[] data) {
        this.data = data;
        this.temp = new int[this.data.length];
    }


    /**
     *
     * var i as left_idx
     * var j as right_idx
     * var k as temp_idx
     *
     * ############# Two items scenario
     * # If there are 2 items to compare it would look like this
     * i    j
     * [1] [4]
     * k
     * [0,0]
     *
     * # parameters would be like this
     * start_idx =0, mid_idx=0, end_idx=1
     *
     * # to see each var value and left and right array capacity
     * so left_idx is 0, and left_array => between 0(start_idx) and 0(mid_idx)
     *    right_idx is 1, and right_array => between 1(mid_idx+1) and 1
     *
     * ############# Four items scenario
     * i      j
     * [1,2] [3,4]
     * k
     * [0,0,0,0]
     *
     * If there are 4 items in an array
     *   start_idx =0, mid_idx =1, end_idx 3
     *
     * so left_idx is 0, and left_array => between 0(start_idx) and 1(mid_idx)
     *    right_idx is 2, and right_array => between 2(mid_idx+1) and 3
     *
     *
      * @param start_idx
     * @param mid_idx
     * @param end_idx
     * @return
     */
    public void merge(int start_idx, int mid_idx, int end_idx) {

        int left_idx = start_idx;      // 0
        int right_idx = mid_idx + 1;   // 2
        int temp_idx = start_idx;      // 0

        // Until one of both array index is bigger then it's size
        while (left_idx <= mid_idx && right_idx <= end_idx) {
            // Compare value and find one is smaller
            if (data[left_idx] < data[right_idx]) {
               // add to temp data
               this.temp[temp_idx] = data[left_idx];
               left_idx++;
            } else {
                this.temp[temp_idx] = data[right_idx];
                right_idx++;
            }
            temp_idx++;
        }

        // if one of them is done earlier, put left elements to temp!
        if (left_idx > mid_idx) {
            for (int i = right_idx; i <= end_idx; i++) {
                this.temp[temp_idx] = data[i];
                temp_idx++;
            }
        } else {
            for (int i = left_idx; i <= mid_idx; i++) {
                this.temp[temp_idx] = data[i];
                temp_idx++;
            }
        }

        // Final data paste! It's important as
        for(int i = start_idx; i <=end_idx; i++) {
           data[i] = temp[i];
        }
    }


    /**
     * 최초 시작, 마지막 인자가 필요함
     *   1) 재귀를 통한 데이터 분할
     *   2) 순차적 정복
     *
     * @param start_idx
     * @param end_idx
     * @return
     */
    public int[] sort(int start_idx, int end_idx) {
        // 재귀 함수에는 항상 조건이 존재해야한다. 원소의 값이
        if (start_idx >= end_idx) {
            return null;
        }

        // 1. 분할을 한다.
        int mid_idx = (start_idx + end_idx) / 2; // 미들 인덱스 추출
        sort(start_idx, mid_idx);                // 왼쪽 분할
        sort(mid_idx+1, end_idx);                  // 오른쪽 분할
        // 2. 정복을 한다.
        merge(start_idx, mid_idx, end_idx);

        return temp; // 그냥 temp 보내도 될듯?
    }
}
