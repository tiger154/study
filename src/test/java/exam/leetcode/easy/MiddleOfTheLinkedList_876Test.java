package exam.leetcode.easy;

import com.jeonhwan.exam.leetcode.easy.CountAndSay_38;
import com.jeonhwan.exam.leetcode.easy.MiddleOfTheLinkedList_876;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MiddleOfTheLinkedList_876Test {

    private static Logger log = LoggerFactory.getLogger(MiddleOfTheLinkedList_876Test.class);

    @Test
    public void solution_test1() {

        MiddleOfTheLinkedList_876 solution = new MiddleOfTheLinkedList_876();

        MiddleOfTheLinkedList_876.ListNode rtn = solution.second_approach(new MiddleOfTheLinkedList_876.ListNode(1, new MiddleOfTheLinkedList_876.ListNode(2, new MiddleOfTheLinkedList_876.ListNode(3))));

        log.debug("hi there");

    }

    @Test
    public void solution_test2() {

        MiddleOfTheLinkedList_876 solution = new MiddleOfTheLinkedList_876();

        MiddleOfTheLinkedList_876.ListNode rtn = solution.first_approach(new MiddleOfTheLinkedList_876.ListNode(1, new MiddleOfTheLinkedList_876.ListNode(2, new MiddleOfTheLinkedList_876.ListNode(3))));


        log.debug("hi there");
    }




}
