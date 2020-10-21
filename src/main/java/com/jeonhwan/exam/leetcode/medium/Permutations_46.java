package com.jeonhwan.exam.leetcode.medium;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Permutations_46 {

    private static Logger log = LoggerFactory.getLogger(Permutations_46.class);


    public List<List<Integer>> first_solution(int[] nums) {

        // make as a string
        StringBuilder builder = new StringBuilder();
        for (int item: nums) builder.append(item);

        List<List<Integer>> final_list = new ArrayList<>();
        first_solution_("", builder.toString(), final_list, 0, nums.length);

        return final_list;

    }


    public List<List<Integer>> first_solution_(String left, String right, List<List<Integer>> final_list, int level, int r) {

        // edge cases
        if (left.isEmpty() && right.isEmpty()) return null;

        // we can control this as 'r'
        if (left.length() == r) {
            final_list.add(convertFromString(left));
            return final_list;
        }

        for (int i = 0; i < right.length(); i++) {
            // get left part
            String left_temp = left + right.charAt(i);
            // get right part
            String right_temp = ((i > 0) ? right.substring(0,i) : "") + right.substring(i+1);

            first_solution_(left_temp, right_temp, final_list, level+1, r);

            log.debug("hey");

        }

        return final_list;
    }

    public List<Integer> convertFromString(String str) {
        List<Integer> list = new ArrayList<>();
        for (Character chr : str.toCharArray()) {
            list.add( Character.getNumericValue(chr));
        }
        return list;
    }
    public List<Integer> convertFromIntArr(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int item : arr) {
            list.add(item);
        }
        return list;
    }

    public List<List<Integer>> second_solution(int[] nums) {

        // make as a string
        List<List<Integer>> final_list = new ArrayList<>();
        List<Integer> left = new ArrayList<>();
        List<Integer> right = convertFromIntArr(nums);

        second_solution_(left, right, final_list, 0, nums.length);


        return final_list;

    }


    /**
     * It's think each operation it need left, right argument
     * Right argument is looped
     *   Each time left argument concat => left + right(0)
     *   Each time right argument delete 'i' index
     *   Call Recursive call (left+right(0), right)
     *
     * When left's length is r's length then put to final list.
     *
     * This is not backtrack but some very similar, And I need to know this tiny difference
     *
     * I thought this as I know factorial formula, first I draw tree structure for test case [1,2,3]
     * And struggled to figure out to make sudo code.
     *  1) Thinking as recursive way was tricky to me.
     *     - Where to put return code
     *     - Argument binding to exist variable which makes some weird behave lol -> It must be new value but I didn't
     *  2) And I just decide let's think about just make a simple echo(forget about better data structure) for while.
     *     - And It gave me more clear algorithm structure(I mean big picture)
     *  3) I was hesitating using String or Array or List structure
     *        And I made with String first -> I thought array manipulation is complex.(which is not lol)
     *        But on TestCase test with 'negative value' break everything lol. -1 -> '-1' count as two characters!
     *
     *
     * But When I draw with arguments difference each operations, I found a pattern like left,right pattern I called.
     * I think This looks better then normal backtracking solution let see
     *
     *
     *
     * [], [123]                => left is [], right is [123]
     * [1], [23]                => left is [1], right is [23]
     *      [12] [3]            => left is [12], right is [3]
     *            [123] []      => left is [123], right is [], left's length is 3 so put to final list
     *      [13] [2]            => left is [13], right is [2]
     *            [132] []      => left is [132], right is [], left's length is 3 so put to final list
     *
     *
     *
     *
     * @param left
     * @param right
     * @param final_list
     * @param level
     * @param r
     * @return
     */
    public List<List<Integer>> second_solution_(List<Integer> left, List<Integer> right, List<List<Integer>> final_list, int level, int r) {

        // edge cases
        if (left.size() == 0 && right.size() == 0) return null;

        // we can control this as 'r'
        if (left.size() == r) {
            final_list.add(left);
            return final_list;
        }

        for (int i = 0; i < right.size(); i++) {
            // get left part

            List<Integer> left_temp = new ArrayList<>(left);  // O(1) time
            left_temp.add(right.get(i));

            // get right part
            List<Integer> right_temp = new ArrayList<>(right);   // O(N) time? so its => O(N! * N)
            right_temp.remove(i);

            second_solution_(left_temp, right_temp, final_list, level+1, r);

            //log.debug("hey");

        }

        return final_list;
    }
}
