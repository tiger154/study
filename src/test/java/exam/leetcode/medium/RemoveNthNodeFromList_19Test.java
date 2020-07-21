package exam.leetcode.medium;

import com.jeonhwan.algorithm.sort.MergeSort;
import com.jeonhwan.exam.leetcode.medium.RemoveNthNodeFromList_19;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;


public class RemoveNthNodeFromList_19Test {
    private static Logger log = LoggerFactory.getLogger(MergeSort.class);




    @Test
    public void first_test() {

        RemoveNthNodeFromList_19.ListNode head = new RemoveNthNodeFromList_19.ListNode(1);
        head.next = new RemoveNthNodeFromList_19.ListNode(2);
        head.next.next = new RemoveNthNodeFromList_19.ListNode(3);
        head.next.next.next = new RemoveNthNodeFromList_19.ListNode(4);
        head.next.next.next.next = new RemoveNthNodeFromList_19.ListNode(5);


        RemoveNthNodeFromList_19 solution = new RemoveNthNodeFromList_19();

        RemoveNthNodeFromList_19.ListNode rst = solution.second_approach(head, 2);
        //RemoveNthNodeFromList_19.ListNode result = solution.brute_force(head, 2);

       log.debug("Lets test!");

    }




}
