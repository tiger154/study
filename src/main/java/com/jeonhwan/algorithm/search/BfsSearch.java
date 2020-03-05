package com.jeonhwan.algorithm.search;

import java.util.*;

/**
 * Breath First Search(너비 우선 검색)
 *   - Find elements near first
 *   - Use queue
 *    1. Put start element to queue first(Check as visit)
 *    2. (loop until queue is empty) Pop from the queue 1 element and find all elements near the element
 *        - Put not visited elements to queue(Check as visit)
 *    3. O notation would be
 *
 *  1) My implementation is not fancy as it just use Java's basic LinkedList for tree
 *     - Why not good? this is strongly rely on index number based not actual node data and prev/next or neighbors..
 *     - So it looks better to define Tree class and Graph version myself for deep understanding
 *
 *
 *   It looks better to try better approach check this link
 *      - https://www.baeldung.com/java-breadth-first-search
 *     1) It makes tree version
 *     2) It also makes graph version
 *
 *
 */
public class BfsSearch {
    // Given data, may I can implement my own Nodes structure
    private List<LinkedList<Integer>> data;
    private TreeNode tree_node;
    public BfsSearch() {

    }
    public BfsSearch(List<LinkedList<Integer>> data) {
        this.data = data;
    }
    public BfsSearch(TreeNode tree_node) {
        this.tree_node = tree_node;
    }


    /**
     * Binary tree
     *   it linked itself
     */

    public static class TreeNode {
        int data; // data value
        TreeNode left_child;
        TreeNode right_child;
        public TreeNode(int data) {
            this.data = data;
        }
        public int getData() {
            return this.data;
        }
        public void setLeftChild(TreeNode left_child) {
            this.left_child = left_child;
        }
        public void setRightChild(TreeNode right_child) {
            this.right_child = right_child;
        }
        public TreeNode getLeft_child() {
            return this.left_child;
        }
        public TreeNode getRight_child() {
            return this.right_child;
        }

    }
    public class Graph {};


    public List<Integer> searchTree() {
        // 1. 데이터 임시로 머무를 큐 생성
        // 2. 최종 결과 리스트 생성
        // 3. 방문 결과 리스트 생성

        LinkedList<TreeNode> queue = new LinkedList<>();
        List<Integer> final_list = new ArrayList<>();
        HashMap<Integer, Boolean> visit_map = new HashMap<>();

        // 1. 먼저 최초 데이터 입력 한다.
        queue.add(tree_node);
        visit_map.put(tree_node.getData(), true);

        // 2. 데이터가 없을때까지 반복문 진행
        while (queue.size() > 0) {

            // 2. 임시 큐에서, 큐를 추출한다.
            TreeNode current_node = queue.poll();
            final_list.add(current_node.getData());

            // 3. 자식 노드 가 존재하는가? 그렇다면, 임시 큐에 추가한다
            TreeNode left_child = current_node.getLeft_child();
            TreeNode right_child = current_node.getRight_child();

            // 값이 존재하고 && 한번도 방문한적이 없다면..
            if (left_child != null && left_child.getData() > 0 && visit_map.get(left_child.getData()) == null ) {
                queue.add(left_child);
                visit_map.put(left_child.getData(), true);
            }
            if (right_child != null && right_child.getData() > 0  && visit_map.get(right_child.getData()) == null) {
                queue.add(right_child);
                visit_map.put(right_child.getData(), true);
            }
        }

        System.out.println("hey there");
        return final_list;
    }


    public List<Integer> search(int start_index) {

        // Linked list implement interface of Queue so, its already queue
        // 1. Use as base data structure
        LinkedList<Integer> queue = new LinkedList<Integer>();
        // 2. Visited check list
        HashMap<Integer, Boolean> visited = new HashMap<>();
        // 3. Final data list
        List<Integer> final_list = new ArrayList<>();

        // 3. Set init data
        queue.add(start_index);
        visited.put(start_index, true);

        // 4. Run until queue is empty!
        while (queue.size() > 0) {

            // 5. Get from queue and set as final data.
            int target_data = queue.poll();
            final_list.add(target_data);
            // 6. Get all related data from this

            if(data.size() > target_data) {
                Iterator<Integer> iterator = data.get(target_data).iterator();

                // 7. Run all linked data
                while (iterator.hasNext()) {
                    int item = iterator.next();
                    // 8. put never visit data only
                    if (visited.get(item) == null) {
                        queue.add(item);
                        visited.put(item, true);
                    }
                }
            }

        }
        return final_list;
    }




}
