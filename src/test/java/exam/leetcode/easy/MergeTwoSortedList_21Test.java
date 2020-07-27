package exam.leetcode.easy;

import com.jeonhwan.algorithm.sort.MergeSort;
import com.jeonhwan.exam.leetcode.easy.MergeTwoSortedList_21;
import com.jeonhwan.exam.leetcode.easy.ValidParentheses_20;
import com.jeonhwan.exam.leetcode.medium.RemoveNthNodeFromList_19;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
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


        MergeTwoSortedList_21.ListNode l1 = new MergeTwoSortedList_21.ListNode(1);
        l1.next = new MergeTwoSortedList_21.ListNode(2);
        l1.next.next = new MergeTwoSortedList_21.ListNode(4);

        MergeTwoSortedList_21.ListNode l2 = new MergeTwoSortedList_21.ListNode(1);
        l2.next = new MergeTwoSortedList_21.ListNode(3);
        l2.next.next = new MergeTwoSortedList_21.ListNode(4);

        MergeTwoSortedList_21 solution = new MergeTwoSortedList_21();
        MergeTwoSortedList_21.ListNode rst = solution.first_approach(l1, l2);

        log.debug("hi there");
    }



}
