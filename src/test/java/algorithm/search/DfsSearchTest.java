package algorithm.search;

import com.jeonhwan.algorithm.search.BfsSearch;
import com.jeonhwan.algorithm.search.DfsSearch;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class DfsSearchTest {




    @Test
    public void dfs_tree_recursive_test() {

        LinkedList<Integer> node0 = new LinkedList<>();
        LinkedList<Integer> node1 = new LinkedList<>();
        LinkedList<Integer> node2 = new LinkedList<>();
        LinkedList<Integer> node3 = new LinkedList<>();
        LinkedList<Integer> node4 = new LinkedList<>();
        LinkedList<Integer> node5 = new LinkedList<>();

        List<LinkedList<Integer>> input_node = new ArrayList<>();
        input_node.add(node0);
        input_node.add(node1);
        input_node.add(node2);
        input_node.add(node3);
        input_node.add(node4);
        input_node.add(node5);

        DfsSearch dfsSearch =  new DfsSearch(input_node);
        dfsSearch.addEdge(0,1);
        dfsSearch.addEdge(0,2);
        dfsSearch.addEdge(1,3);
        dfsSearch.addEdge(1,4);
        dfsSearch.addEdge(2,5);


        int[] search_path_expected_data = {0,1,3,4,2,5};
        int[] left_right_parent_expected_data = {3,4,1,5,2,0};

        List<Integer> result_data = dfsSearch.searchRecursive(0);

        // assert Search Path
        assertArrayEquals(search_path_expected_data, dfsSearch.getSearch_path().stream().mapToInt(i->i).toArray());
        // assert Left-Right-Parent data
        assertArrayEquals(left_right_parent_expected_data, dfsSearch.getLeft_right_parent_list().stream().mapToInt(i->i).toArray());
    }



    @Test
    public void dfs_graph_test() {

        // given
//        LinkedList<Integer> node1 = new LinkedList<>();
//        LinkedList<Integer> node2 = new LinkedList<>();
//        LinkedList<Integer> node3 = new LinkedList<>();
//        LinkedList<Integer> node4 = new LinkedList<>();
//
//        List<LinkedList<Integer>> input_node = new ArrayList<>();
//        input_node.add(node1);
//        input_node.add(node2);
//        input_node.add(node3);
//        input_node.add(node4);
//
//        DfsSearch dfsSearch =  new DfsSearch(input_node);
//        dfsSearch.addEdge(0,1);
//        dfsSearch.addEdge(0,2);
//        dfsSearch.addEdge(1,2);
//        dfsSearch.addEdge(2,0);
//        dfsSearch.addEdge(2,3);
//        dfsSearch.addEdge(3,3);

        LinkedList<Integer> node0 = new LinkedList<>();
        LinkedList<Integer> node1 = new LinkedList<>();
        LinkedList<Integer> node2 = new LinkedList<>();
        LinkedList<Integer> node3 = new LinkedList<>();
        LinkedList<Integer> node4 = new LinkedList<>();
        LinkedList<Integer> node5 = new LinkedList<>();

        List<LinkedList<Integer>> input_node = new ArrayList<>();
        input_node.add(node0);
        input_node.add(node1);
        input_node.add(node2);
        input_node.add(node3);
        input_node.add(node4);
        input_node.add(node5);

        DfsSearch dfsSearch =  new DfsSearch(input_node);
        dfsSearch.addEdge(0,1);
        dfsSearch.addEdge(0,2);
        dfsSearch.addEdge(1,3);
        dfsSearch.addEdge(1,4);
        dfsSearch.addEdge(2,5);


        int[] expected_data = {3,4,1,5,2,0};


        List<Integer> result_data = dfsSearch.search(0);

        System.out.println("input_data:" + Arrays.toString(result_data.toArray()));
        int[] array = result_data.stream().mapToInt(i->i).toArray();
        // assert
        assertArrayEquals(expected_data, array);
    }
}
