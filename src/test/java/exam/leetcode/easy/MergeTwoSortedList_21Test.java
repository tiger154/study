package exam.leetcode.easy;

import com.jeonhwan.algorithm.sort.MergeSort;
import com.jeonhwan.exam.leetcode.easy.ValidParentheses_20;
import com.jeonhwan.exam.leetcode.medium.RemoveNthNodeFromList_19;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

public class MergeTwoSortedList_21Test {
        private static Logger log = LoggerFactory.getLogger(MergeSort.class);


    /**
     * 21. Merge Two Sorted Lists
     *
     *
     * Merge two sorted linked lists and return it as a new sorted list. The new list should be made by splicing together the nodes of the first two lists.
     *
     *
     * Example:
     *
     * Input: 1->2->4, 1->3->4
     * Output: 1->1->2->3->4->4
     *
     * I think it's just simple problem to merge two array.
     * Im gonna use merge sort way, Complexity gonna be O(m+n) time
     *
     * Merge sort need divide and conquer, but it doesn't need to divide
     *
     *
     */
    @Test
    public void test_man() {


        RemoveNthNodeFromList_19.ListNode l1 = new RemoveNthNodeFromList_19.ListNode(1);
        l1.next = new RemoveNthNodeFromList_19.ListNode(2);
        l1.next.next = new RemoveNthNodeFromList_19.ListNode(4);

        RemoveNthNodeFromList_19.ListNode l2 = new RemoveNthNodeFromList_19.ListNode(1);
        l2.next = new RemoveNthNodeFromList_19.ListNode(3);
        l2.next.next = new RemoveNthNodeFromList_19.ListNode(4);



        RemoveNthNodeFromList_19.ListNode rst = brute_force(l1, l2);




        log.debug("hi there");
        // print recursively




    }


    /**
     *   public class ListNode {
     *       int val;
     *       ListNode next;
     *       ListNode(int x) { val = x; }
     *   }
     *
     *
     *   Let say it's all same length
     *
     *   x, y
     *   k
     *
     *
     *   if x => y
     *     left = x
     *     right = y
     *
     *   dummy_left = left
     *   dummy_right = right
     *
     *   1,2,4
     *   1,3,4
     *
     *   while(left.size is done) {
     *
     *        if(dummy_left.val <= dummy_right.val) {
     *           k = dummy_left.val
     *           dummy_left = left.next  // left index ++
     *        } else {
     *           k = dummy_right.val
     *           dummy_right = dummy_right.next  // left index ++
     *        }
     *   }
     *
     *
     *   if (dummry_left.next != null) {
     *      // put all left value to k
     *   }
     *
     *   if (dummry_right.next != null) {
     *      // put all left value to k
     *   }
     *
     *
     *
     * @param l1
     * @param l2
     * @return
     */
    public RemoveNthNodeFromList_19.ListNode brute_force(RemoveNthNodeFromList_19.ListNode l1, RemoveNthNodeFromList_19.ListNode l2) {

        // We assume l1 and l2 length is same, otherwise need to add check length logic
        RemoveNthNodeFromList_19.ListNode dummy_left = l1;
        RemoveNthNodeFromList_19.ListNode dummy_right = l2;

        RemoveNthNodeFromList_19.ListNode result = new RemoveNthNodeFromList_19.ListNode();
        RemoveNthNodeFromList_19.ListNode result_dummy = null;

        int index = 0;

        // Loop until end of the array O(max(m,n))
        while (dummy_left.next != null) {
            // temp init
            RemoveNthNodeFromList_19.ListNode temp = new RemoveNthNodeFromList_19.ListNode();

            // define left value or right value
            if(dummy_left.val <= dummy_right.val) {
                temp.val = dummy_left.val;
                dummy_left = dummy_left.next;
            } else {
                temp.val = dummy_right.val;
                dummy_right = dummy_right.next;
            }

            // if it's first then set value
            if(index == 0) {
                result.val = temp.val;
                result_dummy = result;
            } else {
                result_dummy.next = temp;
            }

            result_dummy = result_dummy.next;

            index++;
        }


        return null;
    }




}
