package algorithm.sort;

import com.jeonhwan.algorithm.sort.SelectionSort;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class SelectionSortTest {


    @Test
    public void given_100_random_sort_asc_Test() {
        // # Given
        int[] expected_data = {1,2,3,4,5,6,7,8,9,10};
        SelectionSort selectionSort = new SelectionSort();
        int[] result_data;

        for(int i=0; i < 100; i++) {
            // Generate random input data for test
            int[] input_data = new Random()
                    .ints(100,1,11)
                    .distinct()
                    .limit(10)
                    .toArray();

            // copy array to track before sorted
            int[] temp = Arrays.copyOf(input_data, input_data.length);

            // # Act
            selectionSort.setData(input_data);
            result_data = selectionSort.sort();

            System.out.println("input_data:" + Arrays.toString(temp) + ", result_data: " + Arrays.toString(result_data));

            // # Assert
            assertArrayEquals(expected_data, result_data);
        }
   }

    @Test
    public void basic_asc_sort_test() {
        // given
        int[] input_data = {5,2,6,9,8,7,10,1,3,4};
        int[] expected_data = {1,2,3,4,5,6,7,8,9,10};
        int[] result_data;
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.setData(input_data);

        // act
        result_data = selectionSort.sort();
        System.out.println(Arrays.toString(result_data));

        // assert
        assertArrayEquals(expected_data, result_data);
    }


}
