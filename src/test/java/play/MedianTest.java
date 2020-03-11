package play;

import com.jeonhwan.algorithm.sort.MergeSort;
import com.jeonhwan.play.Median;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MedianTest {
    private static Logger log = LoggerFactory.getLogger(MergeSort.class);


    @Test
    public void find_median_test_given_array() {

//        int[] input_odd = {1,2,3,4,5};
//        int[] input_even = {1,2,3,4};
        int[] input_odd = {2};
        int[] input_even = {10,15};

        Median median = new Median();
        float median_from_odd = median.findMedianFromSortedArray(input_odd);
        float median_from_even = median.findMedianFromSortedArray(input_even);


        log.debug("median_from_odd: {}, median_from_even: {}", median_from_odd, median_from_even);

        log.debug("done");

    }
}
