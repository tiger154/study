package play;

import com.jeonhwan.algorithm.sort.MergeSort;
import com.jeonhwan.play.Median;
import com.jeonhwan.play.MergeTwoArray;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MergeTwoArrayTest {
    private static Logger log = LoggerFactory.getLogger(MergeSort.class);


    @Test
    public void merge_two_array_with_mergesort_test() {

//        int[] left = {1,5,7,8};
//        int[] right = {2,3,6,9};
        int[] left = {1,7,8,9};
        int[] right = {2,3,5,6};

        MergeTwoArray mergeTwoArray = new MergeTwoArray(left, right);

        int[] merged_array = mergeTwoArray.mergeWithMergeFunc();
        log.debug("done");

    }


    @Test
    public void merge_two_array_test() {

//        int[] left = {1,5,7,8};
//        int[] right = {2,3,6,9};
        int[] left = {1,7,8,9};
        int[] right = {2,3,5,6};

        MergeTwoArray mergeTwoArray = new MergeTwoArray(left, right);

        int[] merged_array = mergeTwoArray.mergeWithInsertionMerge();
        log.debug("done");

    }


    @Test
    public void find_median() {

//        int[] left = {1,5,7,8};
//        int[] right = {2,3,6,9};
        int[] left = {1,7,8,9};
        int[] right = {2,3,5,6};

        MergeTwoArray mergeTwoArray = new MergeTwoArray(left, right);
        int[] merged_array = mergeTwoArray.mergeWithInsertionMerge();
        float median = mergeTwoArray.findMedianFromTwoSortedArray();
        log.debug("done");

    }
}
