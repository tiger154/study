package play;

import com.jeonhwan.algorithm.sort.MergeSort;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class CombinationTest {

    private static Logger log = LoggerFactory.getLogger(MergeSort.class);


    /**
     * while I was studying of GenerateParentheses I was thinking it's similar with bit combinations
     *  they have '(', ')' and binary have '1','0' and first approach is recursive way, but also I thought
     *  It can be just normal for in for O^2 logic.
     *
     *  So tried to generate all combinations with 1,0 value and test with (,) as well.
     *  So through this I can learn 1) How to make combination with binary values with normal for
     *                              2) How to make combination with binary values with recursive
     *                              3) How to check valid parentheses with simple pattern analyzing.
     *
     *
     *  Question, from given number 'n' generate all possible binary value
     *            generate all combination sequence is required
     *    ex) 2
     *       11, 10, 00, 01
     *
     *    ex) 3
     *      111, 101, 100, 110, 000, 010, 011, 001,
     */
    @Test
    public void binary_comb_test() {
        // given 1,0 make all

        for (int i=0;i<2;i++){
            int mask = 2;
            while (mask > 0){
                if ((mask & i) == 0){
                    System.out.print("0");
                } else {
                    System.out.print("1");
                }
                mask = mask >> 1;
            }
            System.out.println();
        }
    }




    public List<int[]> generate(int n, int r) {
        List<int[]> combinations = new ArrayList<>();
        int[] combination = new int[r];

        // initialize with lowest lexicographic combination
        for (int i = 0; i < r; i++) {
            combination[i] = i;
        }

        while (combination[r - 1] < n) {
            combinations.add(combination.clone());

            // generate next combination in lexicographic order
            int t = r - 1;
            while (t != 0 && combination[t] == n - r + t) {
                t--;
            }
            combination[t]++;
            for (int i = t + 1; i < r; i++) {
                combination[i] = combination[i - 1] + 1;
            }
        }

        return combinations;
    }

    @Test
    public void gen_comb() {
        List<int[]> selection = generate(3, 2);

        log.debug("test");
    }


    /**
     * Now I understand how to generate combination of nth binary value
     *
     *  Can I make this as dynamic? so.. for is dynamic... then it works.
     */
    @Test
    public void gen_binary_3depth() {
        int child_num = 2;  // as it's binary tree, only needs 2 child
        int level = 3; // depth of level
        int[] node = new int[level];

        for (int i =0; i < child_num; i++) {
            node[0] = i;
            for (int j=0; j <child_num; j++) {
                node[1] = j;
                for (int k=0; k <child_num; k++) {
                    node[2] = k;
                    log.debug("binary value: {}", node);
                }
            }
        }
    }

    @Test
    public void gen_recursive() {

        int num = 2;
        ArrayList<int[]> result = new ArrayList<>();
        int[] comb = new int[num];

         gen_bit_comb_recursive(comb, 0, result);

         log.debug("hey");

    }


    /**
     * So need to make a tree
     *   1) Exit condition, when it reach the last level
     *   2) It records current array status
     */
    public void gen_bit_comb_recursive(int[] comb, int level, ArrayList<int[]> result) {

        // When it hit the level to generate combination.. save it.
        if(comb.length == level) {
            int[] cp_comb = comb.clone(); // clone data
            result.add(cp_comb);
        } else {

            // So here is the most important part. call all left part and right part
            // left
            comb[level] = 0;
            gen_bit_comb_recursive(comb, level+1, result);

            // right
            comb[level] = 1;
            gen_bit_comb_recursive(comb, level+1, result);
        }

    }


    public boolean balance(int[] arr) {


        return true;

    }






}
