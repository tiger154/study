package com.jeonhwan.exam.leetcode.medium;

import java.util.LinkedList;

public class RemoveNthNodeFromList_19 {

    public static class ListNode {
        public int val;
        public ListNode next;
        public ListNode() {}
        public ListNode(int val) { this.val = val; }
        public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }



    /**
     *  1. Go till the end to check length
     *  2. Loop head till the remove index.
     *    1) set previous node, post node.
     *    2) set previous.next = post node.
     *      - It means removing,
     *
     *    - O(N * 2) but best case can be O(N) time.
     *    - Wow this is my first time to solve the problem good effcitency without check any solution from discussion.
     * @param head
     * @param n
     * @return
     */
    public ListNode second_approach(ListNode head, int n) {


        // lets make more simple to check length
        ListNode temp_next = head.next;
        int length_idx = 1;
        while (temp_next != null) {
            temp_next = temp_next.next;
            length_idx++;
        }

        int skip_index = length_idx-n;

        // now we iterate from head to end
        // If it meet skip point, delete current nth node
        ListNode prev = null;  // root gonna be previous
        ListNode current = head;          // next is current
        int index = 0;
        while (current != null) {
            // When hit deletion index
            if (index == skip_index) {
               // on previous_node's next set current's next!
                if (index == 0) {
                    head = current.next;
                } else {
                    prev.next =  current.next;
                }
              break;
            }
            prev = current;
            current = current.next;     // set new current
            index++;
        }

        return head;
    }

    /**
     *  I designed myself, and I learned Java pass by value in depth.
     *    1) Copy ListNode to Queue : N time
     *    2) Copy back to ListNode(Removed Nth Node): N Time
     *
     *   - Big O: O(n*2)
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode brute_force(ListNode head, int n) {

        // 1. copy data to flat = N time
        LinkedList<Integer> temp_queue = new LinkedList<>();
        temp_queue.add(head.val);

        ListNode temp_next = head.next;
        while (temp_next != null) {
            temp_queue.add(temp_next.val);
            temp_next = temp_next.next;
        }


        // 2. copy data as linked list

        // now lets think about again for practicing
        // 1. Need to set linked-list in loop of temp_queue
        //  1) Set first element as head!
        //  2) Set temp_next element to use new next argument
        //  3) Start loop
        //    3.1) Make a temp instance and use                 --> Save address of this instance
        //    3.2) Set next.next = temp_instance
        //    3.3) In the end set next = temp_instance
        //  * Alright now Im gonna pus skip logic here!

        // needed removed index
        int skip_index = temp_queue.size()-n;
        // if remove index is 0 then just pop and go through
        if(skip_index == 0) {
            temp_queue.pop();
        }

        // If it's empty then return
        if(temp_queue.size() == 0) {
            return null;
        }

        // init first data for head
        ListNode head_rtn = new ListNode(temp_queue.pop());
        ListNode next = null; // it doesn't matter null or any garbage instance

        // loop
        int index = 1;
        while (temp_queue.size() > 0) {
            // 1. pop first data
            ListNode temp_instance = new ListNode(temp_queue.pop());
            // 2. Skip if it hit skip index
            if (skip_index == index) {
                index++;
                continue;
            }
            // 3. Set next data
            if (head_rtn.next == null) {
                head_rtn.next = temp_instance;
            } else {
                next.next = temp_instance;
            }
            // 4. Set next for next iteration
            next = temp_instance;
            // 5. index increment
            index++;
        }

        return head_rtn;
    }
}
