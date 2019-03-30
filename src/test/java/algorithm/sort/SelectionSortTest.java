package algorithm.sort;

import com.jeonhwan.algorithm.sort.SelectionSort;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SelectionSortTest {

    @Test
    public void sort_asc_by_selection_sort() {
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
