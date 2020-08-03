package exam.leetcode.medium;

import com.jeonhwan.algorithm.sort.MergeSort;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses_22Test {
    private static Logger log = LoggerFactory.getLogger(MergeSort.class);


    /**
     * First Need to understand clearly how this recursive logic make combinations
     *   - When I practice backtracking, recursive point was one so it was easy to imagine
     *   - And this was two point for '(' and ')' so I was struggled to imagine.
     *   - Now I figure it out, it's more like binary tree structure with recursive.
     *
     *    ex) tree for given number 1
     *        - current array is reference not new assigned so, it keep changing by traverse the tree
     *        - in this example each node expression is like that: {current array}{position number}
     *        - and it traverse  When go down: left leaf, and go up: left - right - top
     *             0
     *            ↙↘
     *       (1       ))1
     *      ↙↘        ↙↘
     *   ((2  ()2    )(2  ))2
     *
     *
     *  - Time Complexity is O(n^2 * n)
     *
     *  Check the link: https://stackoverflow.com/questions/33389954/generate-all-strings-of-n-bits-assume-a0-n-1-be-an-array-of-size-n/42665086
     *
     * Second What is logic to check if it's valid parenthesis --> balance
     *   - When meet ( ++ else -- and each time check if it's minus then it's not valid wow.. wow..
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList<>();
        generateAll(new char[2 * n], 0, combinations);
        return combinations;
    }

    public void generateAll(char[] current, int pos, List<String> result) {
        if (pos == current.length) {
            if (valid(current))
                result.add(new String(current));
        } else {
            current[pos] = '(';
            generateAll(current, pos+1, result);
            current[pos] = ')';
            generateAll(current, pos+1, result);
        }
    }


    /**
     * This is awesome how to check if it's valid wow.. wow.. wow... amazing
     * @param current
     * @return
     */
    public boolean valid(char[] current) {
        int balance = 0;
        for (char c: current) {
            if (c == '(') balance++;
            else balance--;
            if (balance < 0) return false;
        }
        return (balance == 0);
    }


    @Test
    public void brute_force() {

        int number = 2;
        //List<String> rtn_list = generateParenthesis(number);

        List<String> rtn_list = generateParenthesisBacktrack(number);

        // recursive , backtrack and
        log.debug("test ");
    }


    /**
     * Its amazing approach.  I just copied and checked the logic
     * The simple logic of backtracking is magic to me
     *
     * I drew binary and how it detect wrong branch to search.
     *
     *
     *
     *
     *
     * Explanation from leetcode site below
     * Approach 2: Backtracking
     * Intuition and Algorithm
     *
     * Instead of adding '(' or ')' every time as in Approach 1, let's only add them when we know it will remain a valid sequence. We can do this by keeping track of the number of opening and closing brackets we have placed so far.
     *
     * We can start an opening bracket if we still have one (of n) left to place. And we can start a closing bracket if it would not exceed the number of opening brackets.
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesisBacktrack(int n) {
        List<String> ans = new ArrayList();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, String cur, int open, int close, int max){

        // When hit the leaf node
        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }

        // This is the condition for safe
        if (open < max)
            backtrack(ans, cur+"(", open+1, close, max);
        if (close < open)
            backtrack(ans, cur+")", open, close+1, max);
    }



}
