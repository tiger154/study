package exam.leetcode.hard;

import com.jeonhwan.algorithm.sort.MergeSort;
import com.jeonhwan.exam.leetcode.easy.MergeTwoSortedList_21;
import com.jeonhwan.exam.leetcode.hard.MedianOfTwoSortedArrays_4;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
//        ListNode[] test_list = new ListNode[]{a,b,c} ;
//        ListNode[] test_list = new ListNode[]{a,b} ;
//        ListNode[] test_list = new ListNode[]{a} ;

//        ListNode[] test_list = new ListNode[]{null,null} ;
        ListNode[] test_list = new ListNode[]{null,e} ;

//        ListNode[] test_list = new ListNode[]{aa,bb,cc} ;

        ListNode node =  first_approach(test_list);

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
     *  It's interesting
     *    1) traverse all elements -> to an array
     *    2) sort
     *    3) make new list
     *
     */
    public void brute_force() {

    }


}
