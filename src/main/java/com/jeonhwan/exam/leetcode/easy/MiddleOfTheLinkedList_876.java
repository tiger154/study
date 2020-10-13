package com.jeonhwan.exam.leetcode.easy;

public class MiddleOfTheLinkedList_876 {


    public static class  ListNode {
        int val;
        ListNode next;
        public ListNode() {};
        public ListNode(int val) {this.val = val;}
        public ListNode(int val, ListNode next) {this.val = val; this.next = next; }
    }




    public ListNode first_approach(ListNode head) {

        ListNode[] arr = new ListNode[100];  // maximum is 100
        int index = 0;
        while (head != null) {
            arr[index++] = head;
            head = head.next;
        }
        return arr[index/ 2];

    }


    /**
     *
     * let's do fast, slow pointer
     * slow go to 1, fast go to 2 when fast reach to the end, slow gonna be in middle.
     *
     * @param head
     * @return
     */
    public ListNode second_approach(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
