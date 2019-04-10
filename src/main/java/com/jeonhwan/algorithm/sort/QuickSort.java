package com.jeonhwan.algorithm.sort;


/**
 * 
 */
public class QuickSort {

    private int[] data;


    public int[] getData() {
        return data;
    }

    public QuickSort(int[] data) {
        this.data = data;
    }


    /**
     * I implemented myself. It takes over 4hours with debugging
     * It was actually really hard to figure out without check reference.
     *
     * Pivot rule
     *   - Always pick most left element
     *
     * Mistake Note
     *
     *  - Didn't set the while's exit condition
     *  - My big problem was without debugging couldn't imagine myself for recursive  case deeply
     *  - Tried to do without first/last index, it means I was confused if should use reference data or separate array and merge
     *    Of course it should be referenced data control.
     *  - Wasn't sure what init values for bigger_left_idx/smaller_right_idx
     *    and How to handle if it fail to find bigger_left_idx.
     *    1) For init values I set [bigger_left_idx = first_idx], [smaller_right_idx = last_idx]
     *    2) To handle if there is not bigger value then pivot I set fake bigger value(last_index+1)
     *       to trigger pivot swap
     *  - Compare point should be bigger_left/smaller_right but I tried first_index and last_index
     *    which lead dramatic speed change.
     *
     *
     * @param data
     * @param first_idx
     * @param last_idx
     * @return
     */
    public int[] sortJeonhwanStyle(int [] data, int first_idx, int last_idx) {
        if (first_idx == data.length -1) {
            return data;
        }

        // 데이터의 길이가 1 이하인 경우 즉각 loop 를 빠져나간다.
        if (last_idx - first_idx < 1) {
            return null;
        }

        int pivot = data[first_idx];
        int last = data[last_idx];  // Not using last value so need deleted
        int bigger_left_idx = first_idx;
        int smaller_right_idx = last_idx;


        while (bigger_left_idx < smaller_right_idx) {
            // # 1. find bigger(left -> right)
            for (int i = bigger_left_idx + 1; i < last_idx+1; i++) {
                if (pivot < data[i]) {
                    bigger_left_idx = i;
                    break;
                }
            }
            // # 2. find smaller(right -> left)
            for(int i = smaller_right_idx; i >= first_idx ; i--) {
                if(pivot >= data[i]) {
                    smaller_right_idx = i;
                    break;
                }
            }
            // # 3. if failed to find bigger value then pivot, set fake bigger value
            if (first_idx == bigger_left_idx) {
                bigger_left_idx = last_idx + 1;
            }

            // if stagger happened swap pivot with smaller_right_index
            // And do sort for both side left/right
            if (bigger_left_idx > smaller_right_idx) {
                // swap and call quick sort again
                int temp = data[smaller_right_idx];
                data[smaller_right_idx] = data[first_idx];
                data[first_idx] = temp;

                // start left quickSort
                sortJeonhwanStyle(data, first_idx,smaller_right_idx-1);
                // start right quickSort
                sortJeonhwanStyle(data,smaller_right_idx+1, last_idx);

            } else {
                // swap [here after swap... we can ]
                int temp = data[bigger_left_idx];
                data[bigger_left_idx] = data[smaller_right_idx];
                data[smaller_right_idx] = temp;
            }
        }
        return data;
    }

    /**
     * Pivot pick rule
     *   - Always pick most left element
     *
     * This is better clean code for sure
     *   - To avoid ArrayOutOfBoundsException, make sure find value not over array size
     *   - On loop for looking for right side bigger value, if there is no bigger value
     *     finish loop till end of index. And after exit the loop, make bigger_left_idx = end+1
     *
     * @param data_static
     * @param start
     * @param end
     */
    public void sortCleanCode(int[] data_static, int start, int end) {

        if (start >= end) {
            return;
        }

        int pivot_key = start;
        int bigger_left_idx = start + 1;
        int smaller_right_idx = end;
        int temp;

        while (bigger_left_idx <= smaller_right_idx) {
            // # 1. find bigger(left -> right)
            while (data[bigger_left_idx] <= data[pivot_key] && bigger_left_idx < end) {
                bigger_left_idx++;
            }
            // # 2. find smaller(right -> left)
            while (data[smaller_right_idx] >= data[pivot_key] && smaller_right_idx > start) {
                smaller_right_idx--;
            }

            // 3. If there is not bigger value then pivot
            if(bigger_left_idx == smaller_right_idx) {
                bigger_left_idx = end+1;
            }

            // if stagger swap pivot
            if (bigger_left_idx > smaller_right_idx) {
                // swap
                temp = data[smaller_right_idx];
                data[smaller_right_idx] = data[pivot_key];
                data[pivot_key] = temp;
            // if not swap bigger and smaller
            } else {
                // swap
                temp = data[smaller_right_idx];
                data[smaller_right_idx] = data[bigger_left_idx];
                data[bigger_left_idx] = temp;
            }
        }

        sortCleanCode(data, start ,smaller_right_idx-1);
        sortCleanCode(data, smaller_right_idx+1 ,end);
    }





}
