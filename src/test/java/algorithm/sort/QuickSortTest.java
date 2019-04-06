package algorithm.sort;

import com.jeonhwan.algorithm.sort.BubbleSort;
import com.jeonhwan.algorithm.sort.InsertionSort;
import com.jeonhwan.algorithm.sort.QuickSort;
import helper.DataGenerator;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.junit.Assert.assertArrayEquals;

public class QuickSortTest {

    int[] expected_data_100;

    @Before
    public void setUp() throws Exception {
        expected_data_100 = IntStream.iterate(1, n -> n + 1).limit(100).toArray();
    }

    @Test
    public void given_100_random_data_quick_sort_asc_Test() {
        long startTime = System.nanoTime();
        int[] expected_data = expected_data_100;
        int[] result_data;

        for(int i=0; i < 100; i++) {
            // Generate random input data for test
            int[] input_data = DataGenerator.randomRangedInts(1, 100);
            // copy array to track before sorted
            int[] temp = Arrays.copyOf(input_data, input_data.length);

            QuickSort quickSort = new QuickSort(input_data);
            result_data = quickSort.sortJeonhwanStyle(input_data, 0, input_data.length -1);
            System.out.println("input_data:" + Arrays.toString(temp) + ", result_data: " + Arrays.toString(result_data));

            // # Assert
            assertArrayEquals(expected_data, result_data);
        }
        long endTime = System.nanoTime();
        long timeElapsed =  endTime - startTime;
        System.out.println("# Jeonhwan Code: elapsed time(milliseconds ):" + timeElapsed / 1000000);
    }

    /**
     * Big O(N logN)
     *
     *
     * Data scenario
     *
     *  [5,2,6,9,8,7,10,1,3,4] 0
     *
     */
    @Ignore
    @Test
    public void basic_quick_sort_asc_test() {

        // given
        int[] input_data = {5,2,6,9,8,7,10,1,3,4};
        int[] expected_data = {1,2,3,4,5,6,7,8,9,10};
        int[] result_data;
        int[] temp = Arrays.copyOf(input_data, input_data.length);

        // act
        QuickSort quickSort = new QuickSort(input_data);
        result_data = quickSort.sortJeonhwanStyle(input_data, 0, input_data.length - 1);
        System.out.println("input_data:" + Arrays.toString(temp) + ", result_data: " + Arrays.toString(result_data));
        // assert
        assertArrayEquals(expected_data, result_data);
    }


    @Test
    public void given_100_random_data_quick_sort_clean_code_asc_Test() {
        long startTime = System.nanoTime();
        int[] expected_data = expected_data_100;
        int[] result_data;

        for(int i=0; i < 100; i++) {
            // Generate random input data for test
            int[] input_data = DataGenerator.randomRangedInts(1, 100);
            // copy array to track before sorted
            int[] temp = Arrays.copyOf(input_data, input_data.length);
            QuickSort quickSort = new QuickSort(input_data);
            quickSort.sortCleanCode(input_data, 0, input_data.length -1);
            result_data = quickSort.getData();
            System.out.println("input_data:" + Arrays.toString(temp) + ", result_data: " + Arrays.toString(result_data));

            // # Assert
            assertArrayEquals(expected_data, result_data);
        }
        long endTime = System.nanoTime();
        long timeElapsed =  endTime - startTime;
        System.out.println("# CleanCode: elapsed time(milliseconds ):" + timeElapsed / 1000000);
    }


    @Test
    public void z_basic_quick_sort_clean_code_asc_test() {

        // given
        //int[] input_data = {5,2,6,9,8,7,10,1,3,4};
        int[] input_data = {4,1,9,10,2,3,8,6,5,7};

        int[] expected_data = {1,2,3,4,5,6,7,8,9,10};
        int[] result_data;
        int[] temp = Arrays.copyOf(input_data, input_data.length);

        // act
        QuickSort quickSort = new QuickSort(input_data);
        quickSort.sortCleanCode(input_data, 0, input_data.length - 1);
        result_data = quickSort.getData();

        System.out.println("input_data:" + Arrays.toString(temp) + ", result_data: " + Arrays.toString(result_data));
        // assert
        assertArrayEquals(expected_data, result_data);
    }



}
