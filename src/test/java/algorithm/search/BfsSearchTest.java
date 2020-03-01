package algorithm.search;

import com.jeonhwan.algorithm.search.BfsSearch;
import com.jeonhwan.algorithm.sort.HeapSort;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertArrayEquals;

public class BfsSearchTest {

    @Test
    public void bfs_basic_test() {

        // given
        List<LinkedList<Integer>> input_node = generate_balanced_tree_data(15);
        int[] expected_data = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};

        BfsSearch bfsSearch =  new BfsSearch(input_node);
        List<Integer> result_data = bfsSearch.search(1);

        System.out.println("input_data:" + Arrays.toString(result_data.toArray()));
        int[] array = result_data.stream().mapToInt(i->i).toArray();
        // assert
        assertArrayEquals(expected_data, array);
    }


    /**
     * Auto tree generator with LinkedList
     * @param length
     * @return
     */
    public List<LinkedList<Integer>> generate_balanced_tree_data(int length) {
        List<LinkedList<Integer>> input_node = new ArrayList<>();
        for (int i =0; i <= length; i++) {
            LinkedList node = new LinkedList<Integer>();
            input_node.add(node);
        }

        // 자동 트리 만들기
        for (int i = 1; i <= (length/2); i++) {
            input_node.get(i).add(i*2);
            input_node.get(i).add(i*2+1);
        }
        return input_node;

    }



}
