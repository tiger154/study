package com.jeonhwan.algorithm.search;

import java.util.*;

/**
 * Breath First Search(너비 우선 검색)
 *
 *<br><br>
 *<h3> 1. English Description </h3>
 *<pre>
 *   - Find elements near first
 *   - Use queue
 *    1. Put start element to queue first(Check as visit)
 *    2. (loop until queue is empty) Pop from the queue 1 element and find all elements near the element
 *        - Put not visited elements to queue(Check as visit)
 *    3. O notation
 *      - In most case it uses adjacency list(Faster then adjacency matrix)
 *      - V: vertices, E: Edges
 *      - It can be an edge or edges. Between 2 vertices it can be one edge or two edges.
 *
 *      1) Adjacency metrics: O(V^2)
 *         - Two dimension array
 *      2) Adjacency list: O(V+E)
 *         - Linked list
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
 *</pre>
 * <br><br><h3> 2. Korean Description </h3>
 * <pre>
 *  주변의 노드 를 먼저 검색한다.
 *  큐 를 사용한다
 *
 *  1. 첫번째 노드 를 큐에 입력한다(방문 노드로 기록한다)
 *  2. (큐가 empty 가 될때까지 loop 진행) 데이터를 하나 pop 하고, 해당 노드의 주변 노드를 검색한다.
 *     - 만약 방문기록이 없는 노드인경우, 큐에 삽입한다(이때 방문 노드 기록 추가)
 *
 *  3. 빅 O 는 그래프 저장 방식에 달라진다.
 *   - 통상 링크드 리스트로 활용함(속도가 더 빠르다)
 *   - V: 정점, E:간선(Edge 또는 연결선)
 *   * 간선은 양방향이 될수도 있고 단방향이 될수도 있다. 간선의 수는 양방향일 경우 2개이고 단방향일때는 1개이다.
 *
 *    1) 인접행렬  O(V^2)
 *     - 2차원 배열 사용시
 *    2) 인접 리스트 O(V+E)
 *     - 링크드 리스트 사용시
 * </pre>
 *

 *
 *    @see <a href="https://mygumi.tistory.com/102"> BFS O notation in detail </a> <a href="https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/"> Detail From GeekforGeeks </a> <br>
 *
 *
 *
 *</p>
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

    public void addEdge(int target_index, int add_index) {
        data.get(target_index).add(add_index);
    }

    /**
     *
     *<h3> 1. English Description </h3>
     *<pre>
     *  Binary tree(It linked itself)
     *   1) It start only from root(for now)
     *   2_ One way edge only
     *   3) Not much used this way to implement BFS.
     *     - Because it's only can start from root. IF you want to start from random number it can takes ages...
     *     - Worst case is too far between root node and start node. (ex) data length is over 1 trillion..
     *
     *</pre>
     *<h3> 2. Korean Description </h3>
     *<pre>
     *  이진 트리(하나의 노드로부터 링크드-리스트 형태로 노드 연결되어있음)
     *    1) 항상 최상위에서 부터 시작하게 구현됨
     *    2) 단방향 간선 only (탑다운)
     *    3) 실제 알고리즘 구현에서는 잘 사용되지 않는 형태임.
     *       - 항상 모든 시작이 최상위부터 되야하기때문에, 랜덤한 숫자부터 시작하게 되면, 너무 느려질수 있다.
     *       - 최악의 경우는 최상위 노드와 검색 시작 원하는 노드 위치의 거리가 너무 멀때이다. (약 1조개의 데이터가 있다고 가정해보자...)
     *</pre>
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



    /**
     * Not gonna use actual test but for the practice I implemented myself
     * @return
     */
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
