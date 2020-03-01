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
    public BfsSearch(List<LinkedList<Integer>> data) {
        this.data = data;
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
