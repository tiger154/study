package com.jeonhwan.exam.leetcode.easy;

import java.util.*;

public class MergeTwoSortedList_21 {

    public static class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int x) { val = x; }
    }


    /**
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
     *  // O(max(m,n))
     *
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode first_approach(ListNode l1, ListNode l2) {

        // Empty check
        if(l1 == null && l2 == null) {
            return null;
        }
        if(l1 == null && l2 != null) {
            return l2;
        }
        if(l1 != null && l2 == null) {
            return l1;
        }


        // We assume l1 and l2 length is same, otherwise need to add check length logic
        ListNode dummy_left = l1;
        ListNode dummy_right = l2;

        ListNode result = new ListNode(0); // init with trash data
        ListNode result_dummy = null;

        int index = 0;

        // If one of list is empty, exit
        while (dummy_left != null && dummy_right != null) {
            // temp init
            ListNode temp = new ListNode(0);

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
                result_dummy = result_dummy.next;
            }
            index++;
        }


        // 2. save all left data here
        while (dummy_left != null) {

            ListNode temp = new ListNode(dummy_left.val);
            dummy_left = dummy_left.next;

            result_dummy.next = temp;
            result_dummy = result_dummy.next;
        }

        // 3. save all left data here
        while (dummy_right != null) {
            ListNode temp = new ListNode(dummy_right.val);
            dummy_right = dummy_right.next;

            result_dummy.next = temp;
            result_dummy = result_dummy.next;
        }

        return result;
    }
}
