package com.jeonhwan.play;

/**
 * To find median I made a simple implementation
 *   - For now it only aim to sorted single array!
 *   - For future I can put sort logic as well -> I guess heap sort would be better ? gonna think about it
 */
public class Median {

    int[] data;

    // Constructor
    public Median(){}
    public Median(int[] data){ this.data = data;}


    public float findMedianFromSortedArray(int[] data) {
        this.data = data;
        float result = 0;

        // 1. if odd, get center value and directly return!
        //    ex) if length == 5 then 5/2 => 2 => [1,2,3,4,5] => 3
        if (this.data.length%2 == 1) {
            result = this.data[(this.data.length/2)];

        // 2. if even
        // find center two value(left,right)
        // and (left + right) / 2 => to float!
        } else {
            // [1,2,3,4] 4/2 2
            int left_center = this.data[ ((this.data.length/2)-1)];
            int right_center = this.data[ (this.data.length/2)];
            result =  (float)(left_center + right_center) / 2;
        }

        return result;
    }

}
