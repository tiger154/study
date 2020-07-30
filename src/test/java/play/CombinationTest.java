package play;

import com.jeonhwan.algorithm.sort.MergeSort;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

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
     *
     *
     *
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



    @Test
    public void factorial_comb_test() {
        int n = 4;                  // get factorial of 4
        int r = 2;                  // If you want to get
        int[] comb = new int[n];    // length setting

        HashSet<Integer> sets = new HashSet<>();
        for (int i =0; i < n; i ++) {
            sets.add(i);
        }
        get_factorial_with_recursive(comb, 0,  r, sets);
    }


    /**
     * It should have tracking combination parameter
     * Need to have level(position) parameter
     * Im not gonna return the result of them , just print out now so it doesnt matter to have result parameter
     *
     * Exit condition is when it hit leaf node(last level node)
     *
     * Wow it's beautiful!!! small code and equal time complexity! and dynamic by parameter!
     *
     *
     * I can make more flexible :)
     *
     * comb.length = n
     * level = is current level position
     * r = limit or(need to be selected number)
     *
     */
    public void get_factorial_with_recursive(int[] comb, int current_level, int r ,HashSet<Integer> sets) {

          if (current_level == r) {
              // need to print out the combination! here
              log.debug("comb: {}", comb);
          } else {
              // iterate for given sets
              Iterator<Integer> cpsi =  sets.iterator();
              while (cpsi.hasNext()) {
                  int item = cpsi.next();
                  comb[current_level] = item;
                  HashSet<Integer> cps2 = (HashSet<Integer>) copy_get_itr(sets, item); // need to copy as it shouldn't be
                  get_factorial_with_recursive(comb, current_level+1, r ,cps2);
              }
          }
    }



    /**
     * So n! is factorial. total number would be
     *    n * (n - 1) * (n - 2) ... * n - (n-1)
     *  ex) if n is 4 it would be: 4 * 3 * 2 * 1
     *
     *  So this I can
     *
     *  Time complexity is O(n!) so exactly factorial time
     *    - I saved time through using HashSet
     *      If I didn't used it would be O(n^n) which is worst of worst.
     *
     *  Now let's generate this with recursive
     *
     */
    @Test
    public void get_factorial_with_loop() {
        // when it reach of

        int n = 4;

        // here if I make a map 1,2,3,4
        int[] comb = new int[n];

        // default set check --> It makes speed fast! don't have to look for all n time again
        HashSet<Integer> sets = new HashSet<>();
        for (int i =0; i < n; i ++) {
            sets.add(i);
        }


        // 4,3,2,1 => 24
        int level = 0;
        for(int i = 0; i < n; i++ ) {
            comb[level] = i;

            HashSet<Integer> cps2 = (HashSet<Integer>) copy_get_itr(sets, i); // need to copy as it shouldn't be
            Iterator<Integer> cpsi2 =  cps2.iterator();

            while (cpsi2.hasNext()) {
                int item2 = cpsi2.next();
                comb[level+1] = item2;

                HashSet<Integer> cps3 = (HashSet<Integer>) copy_get_itr(cps2, item2);
                Iterator<Integer> cpsi3 =  cps3.iterator();

                while (cpsi3.hasNext()) {
                    int item3 = cpsi3.next();
                    comb[level+2] = item3;

                    HashSet<Integer> cps4 = (HashSet<Integer>) copy_get_itr(cps3, item3);
                    Iterator<Integer> cpsi4 =  cps4.iterator();

                    while (cpsi4.hasNext()) {
                        comb[level+3] = cpsi4.next();
                        log.debug("comb: {}", comb);
                    }
                }
            }
        }
    }



    public HashSet<?> copy_get_itr(HashSet<?> sets, int remove_value) {
        HashSet<?> cps = (HashSet<?>) sets.clone();
        cps.remove(remove_value);
        return cps;
    }


    /**
     * Study for random question to generate combinations
     */
    class Focus {
        String focus;
        List<String> values;

        public Focus(String focus, String... values) {
            this.focus = focus;
            this.values = Arrays.asList(values);
        }
    }


    private void CreateCombinations(List<Focus> focuses, int index, String[] values) {
        Focus focus = focuses.get(index);
        for (String v : focus.values) {
            values[index] = v;
            if (index < focuses.size() - 1) {
                // there is at least one other focus
                CreateCombinations(focuses, index+1, values);
            } else {
                // all values pinned down
                StringBuilder sb = new StringBuilder(values[0]);
                for (int i = 1; i < values.length; ++i) {
                    sb.append(" ").append(values[i]);
                }
                // now do whatever you like to do with sb.toString()...
            }
        }
    }

    @Test
    public void randomcomb() {
        List<Focus> focuses = new ArrayList<Focus>();
        focuses.add(new Focus("Focus 1", "09", "14", "13", "12"));
        focuses.add(new Focus("Focus 2", "94", "92"));
        focuses.add(new Focus("Focus 3", "A", "B"));

        String[] values = new String[focuses.size()];
        CreateCombinations(focuses, 0, values);

        log.debug("hey");
    }


}
