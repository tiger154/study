package exam.leetcode.medium;

import com.jeonhwan.algorithm.sort.MergeSort;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;


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


       first_approach(head, 3);

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

        // 1. copy data to flat = N time
        LinkedList<Integer> temp_queue = new LinkedList<>();
        ArrayList<Integer> temp_int_arr = new ArrayList<>();
        temp_int_arr.add(head.val);
        temp_queue.add(head.val);
        while (temp_next != null) {
            log.debug("next-value: {}", temp_next.val);
            temp_int_arr.add(temp_next.val);
            temp_queue.add(temp_next.val);
            temp_next = temp_next.next;
        }

        // 2. remove nth from last node = 1 time  --> may we can ignore this as well..
        //    As we can avoid while set the data...
        temp_int_arr.remove(temp_int_arr.size()-n);
       // temp_queue.remove(temp_int_arr.size()-n);
       // 3. copy data as linked list
       // need to know what is head.. here


        // init first data for head
        int head_first_val = temp_queue.pop();


        // now lets think about again for practicing
        // 1. Need to set linked-list in loop of temp_queue
        //  1) Set first element as head!
        //  2) Set temp_next element to use new next argument
        //  3) Start loop
        //    3.1) Make a temp instance and use                 --> Save address of this instance
        //    3.2) Set next.next = temp_instance
        //    3.3) In the end set next = temp_instance
        //  * Alright now Im gonna pus skip logic here!


        ListNode head_rtn = new ListNode(head_first_val);
        ListNode next = null; // it doesn't matter null or any garbage instance

        // loop
        int index = 0;
        while (temp_queue.size() > 0) {
            int tv = temp_queue.pop();
            ListNode temp_instance = new ListNode(tv);
            if (index == 0) {
                head_rtn.next = temp_instance;
            } else {
                next.next = temp_instance;
            }
            next = temp_instance;
            index++;
        }

        log.debug("end of loop!");
    }


    /**
     * Its some how linked.
     */
    @Test
    public void testRelation() {

        //
        ListNode head_nxt = new ListNode(-1);   // 40


        ListNode head_rtn = new ListNode(1);    // 41
        ListNode tmp_next = new ListNode(2);    // 42

        head_rtn.next = tmp_next;                   // 42  --> It point same address now
        head_nxt = tmp_next;                        // 42  --> It point same address now

        // We can see in this context all 3 variable pointing same address (Refer by val)
        tmp_next.val = 3;
        head_nxt.val = 4;
        head_rtn.next.val = 5;

        // but if we give new address it will works different way.


        tmp_next = null;

        log.debug("check data");

    }

}
