package exam.leetcode.easy;

import com.jeonhwan.algorithm.sort.MergeSort;
import com.jeonhwan.exam.leetcode.easy.RemoveDuplicatesFromSortedArray_26;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicatesFromSortedArray_26Test {
    private static Logger log = LoggerFactory.getLogger(MergeSort.class);

    @Test
    public void solution_test() {

        int[] arr = new int[]{0,0,0,1,1,1,2,2,2};

        List<int[]> arr_list = new ArrayList<>();
        arr_list.add(new int[]{0,0,0,1,1,1,2,2,2});
        arr_list.add(new int[]{0,0,1,2,3});
        arr_list.add(new int[]{0,1,2,3,3,3,4,5,5,5,5});
        arr_list.add(new int[]{0,0,0,0,1,1,1,1,2,2,3,3,3,5,5,5});
        arr_list.add(new int[]{0,2,2,2,5,5,5,5,5,5,5});

        for (int[] items : arr_list) {
            log.debug("before: {}", items);
            RemoveDuplicatesFromSortedArray_26 solution =  new RemoveDuplicatesFromSortedArray_26();
            int unique_count = solution.first_approach(items);
            log.debug("after: {}, unique_count: {}", items, unique_count);

            log.debug("hi there");
        }



        log.debug("hi there");
    }





}
