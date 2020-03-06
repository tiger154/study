package com.jeonhwan.algorithm.search;

import java.util.*;


/**
 * Depth First Search(깊이 우선 검색)
 *
 *<br><br>
 *<h3> 1. English Description </h3>
 *<pre>
 *</pre>
 *
 *<br><br>
 *<h3> 2. Korean Description </h3>
 *<pre>
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
