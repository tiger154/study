package algorithm.sort;

import com.jeonhwan.algorithm.sort.HeapSort;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class HeapSortTest {

    @Test
    public void max_heapify_test() {


        int[] input_data = {11,5,8,7,4};
        int[] expected_data = {11,7,8,5,4};

        HeapSort heapSort = new HeapSort(input_data);

        // 1. Heapify test from specific index
        // heapSort.heapify(1);

        // 2. HeapSort Test
        heapSort.sort();

        assertArrayEquals(expected_data, heapSort.getData());
        System.out.println("hey there");
    }


    /**
     * O(N log N)
     */
    @Test
    public void basic_heap_sort_asc_test() {

        // given
        int[] input_data = {5,2,6,8,7,1,3,4};
        int[] expected_data = {1,2,3,4,5,6,7,8};
        int[] result_data;
        int[] temp = Arrays.copyOf(input_data, input_data.length);

        // act
        HeapSort heapSort= new HeapSort(input_data);
        result_data = heapSort.sort();

        System.out.println("input_data:" + Arrays.toString(temp) + ", result_data: " + Arrays.toString(result_data));

        // assert
        assertArrayEquals(expected_data, result_data);
    }
}
