package algorithm.sort;

import com.jeonhwan.algorithm.sort.BubbleSort;
import com.jeonhwan.algorithm.sort.MergeSort;
import helper.DataGenerator;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.junit.Assert.assertArrayEquals;

public class MergeSortTest {


    @Test
    public void given_100_random_data_merge_sort_asc_Test() {
        int[] expected_data = IntStream.iterate(1, n -> n + 1).limit(100).toArray();
        int[] result_data;

        for(int i=0; i < 100; i++) {
            // Generate random input data for test
            int[] input_data = DataGenerator.randomRangedInts(1, 100);
            // copy array to track before sorted
            int[] temp = Arrays.copyOf(input_data, input_data.length);

            MergeSort mergeSort = new MergeSort(input_data);
            result_data = mergeSort.sort(0, input_data.length-1);

            System.out.println("input_data:" + Arrays.toString(temp) + ", result_data: " + Arrays.toString(result_data));

            // # Assert
            assertArrayEquals(expected_data, result_data);
        }
    }
    /**
     * O(N log N)
     */
    @Test
    public void basic_merge_sort_asc_test() {

        // given
        int[] input_data = {5,2,6,8,7,1,3,4};
        int[] expected_data = {1,2,3,4,5,6,7,8};
        int[] result_data;
        int[] temp = Arrays.copyOf(input_data, input_data.length);

        // act
        MergeSort mergeSort= new MergeSort(input_data);
        result_data = mergeSort.sort(0, input_data.length-1);

        System.out.println("input_data:" + Arrays.toString(temp) + ", result_data: " + Arrays.toString(result_data));

        // assert
        assertArrayEquals(expected_data, result_data);
    }




}
