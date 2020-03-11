package exam.leetcode.medium;

import com.jeonhwan.exam.leetcode.medium.AddTwoNumbers;
import org.junit.Test;

public class AddTwoNumbersTest {

    /**
     * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     * Output: 7 -> 0 -> 8
     * Explanation: 342 + 465 = 807.
     *
     * 2 + 5 no carry
     * 0  = carry is 1
     * 3 + 4 + 1 = 8
     *
     *
     * Wow I dont have to do this ugly code man
     *
     *
     * Lets finish myself first and...Check what they want from the question.
     *   and check psedo code
     *
     * I think this
     *
     */


    public static AddTwoNumbers.ListNode toListNode(int[] arr) {

        int index = 0;
        AddTwoNumbers.ListNode node = new AddTwoNumbers.ListNode(arr[0]);
        AddTwoNumbers.ListNode next = node.next;

        for (int i = 1; i < arr.length; i++) {

            AddTwoNumbers.ListNode temp_next = new AddTwoNumbers.ListNode(arr[i]);

            if (i == 1) {
               node.next = temp_next;
            } else {
               next.next = temp_next;
            }

            next = temp_next;
        }

        return node;
    }

    @Test
    public void toListNodeTest() {
        int [] x = {1,2,3,4,5,6,7,8,9,10};

        AddTwoNumbers.ListNode result = toListNode(x);


        System.out.println("hey");

    }


    @Test
    public void addTwoNumber() {


        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();


//        int[] l1 = {9};
//        int[] l2 = {1,9,9,9,9,9,9,9,9,9};

        int[] l1 = {5,5};
        int[] l2 = {5,5};


        AddTwoNumbers.ListNode result = addTwoNumbers.addTwoNumbersBetterWay(toListNode(l1), toListNode(l2));

        System.out.println("hey");
    }

}
