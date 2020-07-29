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
        List<String> rtn_list = generateParenthesis(number);

        // recursive , backtrack and
        log.debug("test ");
    }

}
