package com.jeonhwan.exam.leetcode.easy;


/**
 * Added solution description
 *  - https://blog.naver.com/junhwen/222115360694
 */
public class MiddleOfTheLinkedList_876 {


    public static class  ListNode {
        int val;
        ListNode next;
        public ListNode() {};
        public ListNode(int val) {this.val = val;}
        public ListNode(int val, ListNode next) {this.val = val; this.next = next; }
    }


    /**
     * It's not fully tested but enough to see the logic
     *  - loop two time so O(N * 2) or O( N + N/2)
     *
     * @param head
     * @return
     */
    public ListNode bruteforce_approach(ListNode head) {

        ListNode temp = head;
        int count = 1;

        while (temp.next != null) {
            temp = temp.next;
            count++;
        }

        // now we know count

        int index = 0;
        int mid = count/2;
        while (head.next != null) {
            if (index == mid) {
               return head;
            }
            head = head.next;
            index++;
        }
        return head;
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
