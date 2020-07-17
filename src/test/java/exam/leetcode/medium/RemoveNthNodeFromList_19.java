package exam.leetcode.medium;

import com.jeonhwan.algorithm.sort.MergeSort;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.NodeList;

import java.util.ArrayList;


public class RemoveNthNodeFromList_19 {
    private static Logger log = LoggerFactory.getLogger(MergeSort.class);


     public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    @Test
    public void first_test() {


       //ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);


       first_approach(head, 2);

       log.debug("Lets test!");

    }


    /**
     * Alright so...
     *
     *   1. loop of list and save it to simple array => N time
     *   2. remove by index
     *   3. save as linked list => N time
     *
     *   - I thought it need N*2 time
     *   - But I think i can make it only N time !
     *
     *   -
     *
     *
     * @param head
     * @param n
     */
    public void first_approach(ListNode head, int n) {


        ListNode temp_next = head.next;

        log.debug("head-value: {}", head.val);

        ArrayList<Integer> temp_int_arr = new ArrayList<>();
        temp_int_arr.add(head.val);
        while (temp_next != null) {
            log.debug("next-value: {}", temp_next.val);
            temp_int_arr.add(temp_next.val);
            temp_next = temp_next.next;
        }

        // remove nth from last node
        temp_int_arr.remove(temp_int_arr.size()-n);

        log.debug("end of loop!");
    }

}
