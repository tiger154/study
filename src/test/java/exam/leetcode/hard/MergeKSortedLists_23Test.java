package exam.leetcode.hard;

import com.jeonhwan.algorithm.sort.MergeSort;
import com.jeonhwan.exam.leetcode.easy.MergeTwoSortedList_21;
import com.jeonhwan.exam.leetcode.hard.MedianOfTwoSortedArrays_4;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class MergeKSortedLists_23Test {

    private static Logger log = LoggerFactory.getLogger(MergeSort.class);


    public static class ListNode {
        public int val;
        public ListNode next;
        ListNode() {}
        public ListNode(int x) { this.val = x; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * using merge sort way but check 3
     * O(n)
     *
     * given array a,b,c
     * index i,j,k
     * result array d
     *
     * loop till end of two of them is done.
     * get min(min(a,b),c)
     *
     * increase min index and set to d.
     *
     * How to get min linked list
     *   - Simple smallest and foreach k time each index, So every time at least need to check k time
     *
     *   let say 2 array has two item
     *
     *
     * last_array = null;
     *
     * while(true) {
     *
     *    1. exit when only one array left
     *
     *
     *     - current_smallest = a
     *    2. for(item : k) k time {
     *        if(item.val < a) {
     *            current_smallest = item
     *            item = item.next
     *        }
     *    }
     *
     *    3. Add smallest node
     *      d.next = current_smallest.val;
     *
     * }
     *
     * // left data insert
     * if(last_array is not null) {
     *     d.next = last_array
     * }
     *
     * then it's gonna work, Im not sure why it's hard level ?
     *
     *
     * Input:
     * [
     *   1->4->5,
     *   1->3->4,
     *   2->6
     * ]
     * Output: 1->1->2->3->4->4->5->6
     *
     */
    @Test
    public void tester () {

        // 1. Give 3 test array
        // Check if only one left probably for reach here? then  O(k*N) would be
        ListNode a = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode b = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode c = new ListNode(2, new ListNode(6));
        ListNode d = new ListNode(1, new ListNode(7));
        ListNode e = new ListNode(1);


        ListNode aa = new ListNode(-2, new ListNode(1, new ListNode(4, new ListNode(5))));
        ListNode bb = new ListNode(-2, new ListNode(5, new ListNode(6)));
        ListNode cc = new ListNode(-2, new ListNode(0));

//        ListNode[] test_list = new ListNode[]{a,b,c,d} ;
        ListNode[] test_list = new ListNode[]{a,b,c} ;
//        ListNode[] test_list = new ListNode[]{a,b} ;
//        ListNode[] test_list = new ListNode[]{a} ;

//        ListNode[] test_list = new ListNode[]{null,null} ;
//        ListNode[] test_list = new ListNode[]{null,e} ;

//        ListNode[] test_list = new ListNode[]{aa,bb,cc} ;

//        ListNode node =  first_approach(test_list);

        ListNode node =  second_approach(test_list);

        // [[-2,1,4,5],[-2,5,6],[-2,0]]
        // -2,-2,-2,0,..

        log.debug("test for fun programming");

    }


    /**
     *  It's working! but so long code and so slow lol
     *    - Runtime: 583 ms, faster than 5.03% of Java online submissions for Merge k Sorted Lists.
     *    - Memory Usage: 41.2 MB, less than 76.41% of Java online submissions for Merge k Sorted Lists.
     *
     *  I tried to use toll debugging more then brain debugging which is not good.
     *  But it was good to practice
     *     1) iterate linked list next value setting. (Understanding Java Pass by value)
     *     2) infinity loop hole find out
     *     3) At least I can make it working and explain
     *
     *  now let's check other's talented approach, and check with my ugly solution
     *
     * @param lists
     * @return
     */
    public ListNode first_approach(ListNode[] lists) {

        // basic check
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }

        // what would be the clean code
        List<ListNode> temp_list = new ArrayList<>();
        for(int i=0; i < lists.length; i++) {
            if (lists[i] != null) {
                temp_list.add(lists[i]);
            }
        }
        // change totally to new lists
        lists = temp_list.toArray(new ListNode[temp_list.size()]);

        // basic check again!
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }




        ListNode min  = lists[0];
        int min_idx = 0;

        ListNode node = new ListNode(0);
        ListNode remote_node = node;

        int index = 0;



        while (true) {
            // kN time loop
            for(int i=0; i < lists.length; i++) {

                // if it's middle no problem. but if end of element then problem so it must be condition before end element hit
                if(i < lists.length-1 && lists[i] == null) { continue;}
                if(min == null) { continue;}

                // null check is required here
                if (lists[i] != null && min.val > lists[i].val) {
                    min = lists[i];
                    min_idx = i;
                }

                // at k time reached, decide what to move the head
                // here need to give more condition let say
                // if there is no more alive value then it's gonna be infinity loop wow
                if (i == lists.length-1) {

                    log.debug("min val: {}", min.val);

                    // 1. set min value here
                    remote_node.next = new ListNode(min.val);
                    // 2. remove head of min
                    min = min.next;
                    lists[min_idx] = min;

                    // if it't null it means a list-node is out, so need to choose new min
                    if(min == null) {

                        // choose new min. any element first come-up.
                        int null_count = 0;
                        for (int j=0; j < lists.length; j++) {

                            if(lists[j] != null) {
                                min = lists[j];
                                min_idx = j;
                            } else {
                                null_count++;
                            }
                            // checked all list
                            if(null_count >= lists.length) {
                                return node.next;
                            }
                        }

                        // now only one null then let's go out
                        if (lists.length - null_count == 1) {
                            remote_node.next.next = lists[min_idx];
                            return node.next;
                        }

                    }
                    // 3. change nodes next part
                    remote_node = remote_node.next;
                }
            }
            index++;
        }


    }


    /**
     * All same but using data through priority queue
     * Hm how I can implement this data structure. Im kinda interested as I should be ready as member of Big4
     *
     * Linked-list, Queue, Stack, Heaps
     *
     *
     * How I can implement Queue?
     *
     * It should support iterate
     * It should support FIFO
     * It should support Get Most Front element
     * It should support Put an element on tail
     *
     * Put mean get last node
     *   Add next from the last node
     *   > property next needed
     * Get Front node mean
     *   Get head from Queue
     *   > property head needed
     *
     *
     * Queue tail ?
     * Queue next ?
     * Queue head ?
     *
     *
     *
     * Time complexity : O(N log k) where k is the number of linked lists.
     *
     * The comparison cost will be reduced to O(logk) for every pop and insertion to priority queue. But finding the node with the smallest value just costs O(1) time.
     * There are N nodes in the final linked list.
     *
     *
     * @param lists
     * @return
     */
    public ListNode second_approach(ListNode[] lists) {

        // basic check
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }

        // 1. set compare condition(
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((a, b) -> a.val - b.val);


        // 2. transform to pq
        //    - compare each linked list's head
        for (ListNode node : lists) {
            // When Add null data, it throws NullPointerException
            if(node != null) {
                pq.add(node);
            }
        }

        // I would call this as remote string to a balloon
        ListNode head = new ListNode(0);
        ListNode current = head;


        // 3. loop til pq is empty
        //     use priority queue's remove function which guarantee get smallest value and remove the ListNode's head.
        while (!pq.isEmpty()) {
            // get smallest node
            ListNode top = pq.remove();

            // set to next and change pointer
            current.next = top;
            current = current.next;

            // If next is not null reassign to the queue
            if (top.next != null) {
                pq.add(top.next);
            }

        }


        return head.next;
    }

    /**
     *  It's interesting
     *    1) traverse all elements -> to an array
     *    2) sort
     *    3) make new list
     *
     */
    public void brute_force() {

    }


}
