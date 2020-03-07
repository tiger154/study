package com.jeonhwan.algorithm.search;

import java.util.*;


/**
 * Depth First Search(깊이 우선 검색)
 *
 *<br><br>
 *<h3> 1. English Description </h3>
 *<pre>
 *     1. Depth First Search implementation
 *       - Usually used for simulation for game
 *     2. Big O notation
 *       - O(V+E) or O(V^2). most of time use Adjacency list for data structure( O(V+E) )
 *</pre>
 *
 *<br><br>
 *<h3> 2. Korean Description </h3>
 *<pre>
 *     1. 깊이 우선 검색
 *       - 통상 게임 시뮬레이션에 자주 사용된다.
 *     2. Bio O
 *       - O(V+E) 또는 O(V^2) 이고, 통상 인접 리스트 데이터 O(V+E) 형으로 구현한다.
 *
 *</pre>
 */
public class DfsSearch {
    private List<LinkedList<Integer>> data;
    public DfsSearch() {}
    public DfsSearch(List<LinkedList<Integer>> data) {
        this.data = data;
    }
    public void addEdge(int target_index, int add_index) {
        data.get(target_index).add(add_index);
    }
    public List<Integer> getSearch_path() {return this.search_path;}
    public List<Integer> getLeft_right_parent_list() {return this.left_right_parent_list;}

    /**
     *
     *<br><br>
     *<h3> 1. English Description </h3>
     *<pre>
     *    Search through recursive.
     *      - Set search path
     *      - Set Left - Right - Parent order data
     *</pre>
     *
     *<br><br>
     *<h3> 2. Korean Description </h3>
     *<pre>
     *   재귀 함수를 통한 간단한 구현.
     *
     *
     *   1) 데이터를 시각화 한다.
     *
     *   0 1 2 3 4 5
     *
     *   0 1 2
     *   1 3 4
     *   2 5
     *   3 - empty
     *   4 - empty
     *   5 - empty
     *
     *   vertices :  0 - 5 , total 5
     *   1) left -> right -> parent
     *          0
     *       1     2
     *     3  4  5
     *
     *   3 4 1 5 2 0
     *
     *
     *
     *</pre>
     *
     * @param start_index
     * @return
     */

    List<Integer> search_path = new ArrayList<>();
    List<Integer> left_right_parent_list = new ArrayList<>();
    Set<Integer> visited_list = new HashSet<>();

    public List<Integer> searchRecursive(int start_index) {
        // 1. Add on search path
        search_path.add(start_index);
        // 2. Set as visited the index
        visited_list.add(start_index);

        // 3. Get Iterator
        Iterator<Integer> itr = data.get(start_index).iterator();

        // 4. If it has child run loop
        if (itr.hasNext()) {
            // To Check total child
            int length = data.get(start_index).size();
            // To Check if last loop of child
            int idx = 1;
            while (itr.hasNext()) {
                Integer item = itr.next();
                // 5. If never visited Go to deep with recursive
                if(!visited_list.contains(item)) {
                    searchRecursive(item);
                }
                // 6. If it's end of child loop
                if(idx == length) {
                    left_right_parent_list.add(start_index); // 만약 밑에 아무것도 없다면... finding last node I guess?
                }
                idx++;
            }
        } else {
            left_right_parent_list.add(start_index); // 만약 밑에 아무것도 없다면... finding last node I guess?
        }

        return left_right_parent_list;
    }


    /**
     *
     *<br><br>
     *<h3> 1. English Description </h3>
     *<pre>
     *    Search through Stack data structure.
     *</pre>
     *
     *<br><br>
     *<h3> 2. Korean Description </h3>
     *<pre>
     *   스택 데이터 구조를 이용한 깊이우선탐색색     *</pre>
     *
     * @param start_index
     * @return
     */
    public List<Integer> search(int start_index) {

        // 1. Stack 구조를 데이터 중간 저장의 기준으로.
        Stack<Integer> stack = new Stack<>();
        // 2. 방문 기록 용 데이터 변수 추가
        Set<Integer> visit_list = new HashSet<>();
        // 3. 최종 데이터 전달 데이터
        List<Integer> final_list = new ArrayList<>();

        // 4. Stack 에 시작 index 추가
        stack.push(start_index);
        // 5. 시작 index 방문 기록 추가
        visit_list.add(start_index);

        // 6. Stack 데이터 empty 까지 loop 진행
        while (stack.size() > 0) {

            // 7. 현재 최상위 값 가져오기. (데이터는 그대로 존재함)
            Integer current_top = stack.peek();

            // 8. 자식 리스트를 가져온다.
            Iterator<Integer> itr = data.get(current_top).iterator();

            // 자식 존재여부 체크
            boolean has_child = false;



            while (itr.hasNext()) {
                Integer node_value = itr.next();


                // 9. <loop> 방문기록이 없는가? Stack 에 입력한다.(방문 처리한다.), 그리고 바로 나간다.
                if(!visit_list.contains(node_value) ) {
                    stack.push(node_value);
                    visit_list.add(node_value);

                    has_child = true;
                    break;
                }

            }

            // 10. 만약 자식이 없는 상태라면.. Stack 에서 제거해준다!
            if (!has_child) {
                Integer pop_node_value = stack.pop();
                final_list.add(pop_node_value);
            }


        }

        // 8.1 만약 자식이 하나도 없다면..현재 노드 삭제
        // 9. <loop> 방문기록이 없는가? Stack 에 입력한다.(방문 처리한다.), 그리고 바로 나간다.
        // 10. 만약 자식이 없는 상태라면.. Stack 에서 제거해준다!




        return final_list;
    }
}
