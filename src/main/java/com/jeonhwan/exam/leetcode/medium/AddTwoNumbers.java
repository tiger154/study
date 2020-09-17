package com.jeonhwan.exam.leetcode.medium;

import java.util.Stack;

public class AddTwoNumbers {


    public  static class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int x) { val = x; }
        public void setNext(ListNode next) {this.next = next;}
    }

    public void toStack(ListNode listNode, Stack stack) {
        if (listNode.next != null) {
            stack.push(listNode.next.val);
            toStack(listNode.next, stack);
        }
    }

    public long toNumber(Stack<Integer> stack) {
        String concat_string = "";
        while (stack.size() > 0) {
            int item  = stack.pop();
            String item_string = Integer.toString(item);
            concat_string += item_string;
        }

        return Long.parseLong(concat_string);
    }

    /**
     * Add Two Numbers
     *
     *<br><br>
     *<h3> 1. English Description </h3>
     *<pre>
     *     1. Questions: Add Two Numbers
     *       - You are given two non-empty linked lists representing two non-negative integers.
     *       - The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
     *       - You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     *
     *     2. Tip
     *       - Sum each digit by order. ex) [1, 2, 3] [4, 5, 6] => 1+4, 2+5, 3+6
     *       - Track if there is overflow(over 10) value. It called carry. and sum next calculation
     *       - sum%mod => withour overflow
     *
     *     3. Pseudo code
     *        1) Init vars
     *        2) while loop (till reach end of both array left,right )
     *          2.1) core vars calculation
     *            2.1.1) sum basic: int sum = left.val + right.val + carry
     *            2.1.2) get sum value without overflow: int mod = sum%10  => overflow 제외한 결과값 추출
     *            2.1.3) calculate carry : carry = (sum > 10) ? 1 : 0
     *
     *          2.2) save data
     *            2.2.1) ListNode.next = new ListNode(mod)
     *
     *          2.3) Exit condition write down
     *            - when Reach end of both array left,right (next node == null or nod == null)
     *            2.3.1) if (carry > 0) add next node
     *               - node.next = 1
     *
     *        return node;


     *
     *       -- 4) If it end..
     *       -- if ( l == null || (lt != null && l.next == null)
     *          && l == null || (lt != null && l.next == null)) {
     *
     *              if(carry > 0) {
     *
     *                  if(index == 0) {
     *                      root.next = new ListNode(1);
     *                  }else {
     *                      next.next = new ListNode(1);
     *                  }
     *              }
     *
     *              break;
     *          }
     *
     *
     *     4. Mistake note
     *       1) I tried to solve this with Actual total number sum. but I realized it's overflow, they give huge number range
     *          So I tried with Integer and Long but it was tooooo small to sum it.
     *       2) And I used a lot of conversion from ListNode -> Stack -> List of Integer -> String -> Integer -> Sum... etc
     *
     *</pre>
     *
     *<br><br>
     *<h3> 2. Korean Description </h3>
     *<pre>
     *     1. 2 &#xc22b;&#xc790; &#xb354;&#xd558;&#xae30;
     *       -
     *
     *     2.
     *     3. Pseudo code
     *        1) &#xb370;&#xc774;&#xd130; &#xcd08;&#xae30;&#xd654;
     *        2) while loop &#xc9c4;&#xd589;(left,right &#xbc30;&#xc5f4;&#xc758; &#xcd5c;&#xb300; &#xae38;&#xc774; &#xb9cc;&#xd07c;)
     *          2.1) &#xc8fc;&#xc694; &#xac12; &#xacc4;&#xc0b0;
     *            2.1.1) &#xae30;&#xbcf8; &#xb354;&#xd558;&#xae30;: int sum = left.val + right.val + carry
     *            2.1.2) &#xc800;&#xc7a5; &#xac12; &#xad6c;&#xd558;&#xae30;: int mod = sum%10  => overflow &#xc81c;&#xc678;&#xd55c; &#xacb0;&#xacfc;&#xac12; &#xcd94;&#xcd9c;
     *            2.1.3) carry &#xac12; &#xad6c;&#xd558;&#xae30;: carry = (sum > 10) ? 1 : 0
     *
     *          2.2) &#xb370;&#xc774;&#xd130; &#xc800;&#xc7a5;
     *            2.2.1) ListNode &#xac12; &#xcd94;&#xac00;
     *
     *          2.3) Exit &#xc870;&#xac74; &#xba85;&#xae30;
     *            - left. right &#xbc30;&#xc5f4;&#xc758; &#xcd5c;&#xb300; &#xae38;&#xc774;&#xc5d0; &#xb3c4;&#xb2ec;&#xd558;&#xba74;(next node == null or nod == null)
     *            2.3.1) carry > 0 &#xc77c;&#xacbd;&#xc6b0; &#xb370;&#xc774;&#xd130; &#xcd94;&#xac00;
     *               - node.next = 1
     *
     *        return node;
     *
     *     5. O(N) &#xc73c;&#xb85c; &#xc815;&#xb9ac; &#xac00;&#xb2a5;.
     *
     *
     *</pre>
     *
     * @see <a href="https://leetcode.com/problems/add-two-numbers/">leetcode add-two-numbers</a>
     */
    public ListNode addTwoNumbersBetterWay(ListNode l1, ListNode l2) {

        // use to check end of loop
        boolean end_reach = false;
        // init carry value
        int carry = 0;
        Stack stack = new Stack();

        // dummy to add it
        ListNode node = new ListNode(-1);
        ListNode next = new ListNode(-1);
        int index = 0;


        // loop until the end of the list
        while (!end_reach) {
            // 1. sum each digit
            int sum = ((l1 == null) ? 0 : l1.val) + ((l2 == null) ? 0 : l2.val) + carry;
            // 2. add to array
            int mod = sum%10;

            // 3. set data
            stack.push(mod);

            // 4. Set result list directly
            ListNode temp_next = new ListNode(mod);
            if (index == 0) {
                node.val = mod;
            } else if (index == 1) {
                node.next = temp_next;
            } else {
                next.next = temp_next;
            }
            next = temp_next;

            // 4. Check carry for next cal
            carry = (sum >= 10) ? 1 : 0;

            // Condition to exit
            if( (l1 == null || (l1 != null &&l1.next == null))
              && (l2 == null || (l2 != null &&l2.next == null))
              ) {
                if (carry > 0) {
                    stack.push(1);

                    if (index == 0) {
                        node.next = new ListNode(1);
                    } else {
                        next.next = new ListNode(1);
                    }

                }
                end_reach = true;
               break;
            }

            l1 = (l1 == null) ? null : l1.next;
            l2 = (l2 == null) ? null : l2.next;
            index++;
        }
        return node;
    }






    /**
     * This is only working if given arrays are smaller number which means
     *   - If it's under Long Value type (8 Bytes) => 8 bit(1Byte) * 8 => 64 bit => 2^64 is the range
     *   - -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807
     *
     * But This question gives much bigger numbers. so need to find other solution
     *   - 1) Keep track of the carry using a variable and simulate digits-by-digits sum starting from the head of list, which contains the least-significant digit.
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {


        // 1. loop each data to get all of them (Stack)
        Stack<Integer> stack = new Stack<>();
        stack.push(l1.val);
        toStack(l1, stack);

        Stack<Integer> stack2 = new Stack<>();
        stack2.push(l2.val);
        toStack(l2, stack2);

        long first_number = toNumber(stack);
        long second_number = toNumber(stack2);


        long sum_data = first_number + second_number;




        // to array and put to stack
        // and add to linked list! then all right?
        String sum_string = String.valueOf(sum_data);

        // For reverse put the data to stack..
        Stack<Integer> stack_result = new Stack<>();
        for(char s : sum_string.toCharArray()) {
            int item = Integer.parseInt(String.valueOf(s));
            stack_result.push(item);
        }

        // Finally set the final data
        int first_item = stack_result.pop();
        ListNode return_list = new ListNode(first_item);
        ListNode next = return_list.next;

        while (stack_result.size() > 0) {
            int item = stack_result.pop();
            ListNode temp_next = new ListNode(item);


            if (next != null) {
                next.next = temp_next;
                //next.setNext(temp_next);
            } else {
                //return_list.setNext(temp_next);
                return_list.next = temp_next;
            }
            next = temp_next;

        }

        System.out.println("hey");


        return return_list;
    }

    /**
     * This is soo clean code then mine
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers_(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

}
