package algorithm.search;

import com.jeonhwan.algorithm.search.BfsSearch;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


import static org.junit.Assert.assertArrayEquals;

public class BfsSearchTest {

    /**
     * TopDown data tree -> Edge is only one way(Not both way)
     */
    @Test
    public void bfs_tree_test() {

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
     * Each node can have more then one edges.
     */
    @Test
    public void bfs_graph_test() {

        // given
        LinkedList<Integer> node1 = new LinkedList<>();
        LinkedList<Integer> node2 = new LinkedList<>();
        LinkedList<Integer> node3 = new LinkedList<>();
        LinkedList<Integer> node4 = new LinkedList<>();

        List<LinkedList<Integer>> input_node = new ArrayList<>();
        input_node.add(node1);
        input_node.add(node2);
        input_node.add(node3);
        input_node.add(node4);

        BfsSearch bfsSearch =  new BfsSearch(input_node);
        bfsSearch.addEdge(0,1);
        bfsSearch.addEdge(0,2);
        bfsSearch.addEdge(1,2);
        bfsSearch.addEdge(2,0);
        bfsSearch.addEdge(2,3);
        bfsSearch.addEdge(3,3);


        int[] expected_data = {2,0,3,1};
        List<Integer> result_data = bfsSearch.search(2);

        System.out.println("input_data:" + Arrays.toString(result_data.toArray()));
        int[] array = result_data.stream().mapToInt(i->i).toArray();
        // assert
        assertArrayEquals(expected_data, array);
    }



    @Test
    public void bfs_one_tree_test() {

        // given
        List<LinkedList<Integer>> input_node = generate_balanced_tree_data(15);
        // first node
        BfsSearch.TreeNode treeNode1 = new BfsSearch.TreeNode(1);
        BfsSearch.TreeNode treeNode2 = new BfsSearch.TreeNode(2);
        BfsSearch.TreeNode treeNode3 = new BfsSearch.TreeNode(3);
        BfsSearch.TreeNode treeNode4 = new BfsSearch.TreeNode(4);
        BfsSearch.TreeNode treeNode5 = new BfsSearch.TreeNode(5);
        BfsSearch.TreeNode treeNode6 = new BfsSearch.TreeNode(6);
        BfsSearch.TreeNode treeNode7 = new BfsSearch.TreeNode(7);
        treeNode1.setLeftChild(treeNode2);
        treeNode1.setRightChild(treeNode3);
        treeNode2.setLeftChild(treeNode4);
        treeNode2.setRightChild(treeNode5);
        treeNode3.setLeftChild(treeNode6);
        treeNode3.setRightChild(treeNode7);

        int[] expected_data = {1,2,3,4,5,6,7};


        BfsSearch bfsSearch =  new BfsSearch(treeNode1);
        List<Integer> result_data = bfsSearch.searchTree();


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
