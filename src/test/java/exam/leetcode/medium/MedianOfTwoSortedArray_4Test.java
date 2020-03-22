package exam.leetcode.medium;

import com.jeonhwan.exam.leetcode.medium.AddTwoNumbers;
import com.jeonhwan.exam.leetcode.medium.MedianOfTwoSortedArrays_4;
import org.junit.Test;

public class MedianOfTwoSortedArray_4Test {



    @Test
    public void bigOLogN_test() {
        MedianOfTwoSortedArrays_4 median = new MedianOfTwoSortedArrays_4();

//        int[] l1 = {1,3,5};
//        int[] l2 = {2,4,6};


        int[] l1 = {1,2,3,4};
        int[] l2 = {5,6,7,8};

        float median_result = median.findMedianSortedArraysBigOLogMinN(l1,l2);


        System.out.println("hey");
    }



    @Test
    public void bigON_test() {

        MedianOfTwoSortedArrays_4 median = new MedianOfTwoSortedArrays_4();

        int[] l1 = {1,3,5};
        int[] l2 = {2,4,6};

//        int[] l1 = {1,3};
//        int[] l2 = {2};

//        int[] l1 = {1,2};
//        int[] l2 = {3,4};

//        int[] l1 = {};
//        int[] l2 = {1};

//        int[] l1 = {3};
//        int[] l2 = {-2, -1};

//        int[] l1 = {2};
//        int[] l2 = {1,3,4};


        float median_result = median.findMedianSortedArraysBigONlogN(l1, l2);

        System.out.println("hey");
    }

}
