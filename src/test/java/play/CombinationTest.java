package play;

import com.jeonhwan.algorithm.sort.MergeSort;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 *  https://www.cs.sfu.ca/~ggbaker/zju/math/perm-comb-more.html#:~:text=If%20we%20are%20selecting%20an,%3D6%20and%20n%3D3.
 *
 * Basic formula
 *
 * 1) Permutation, Repetition(No)  : nPr
 * 2) Permutation, Repetition(Yes) : n^r
 * 3) Combination, Repetition(No)  : nCr
 * 4) Combination, Repetition(Yes) : n+r-1Cr
 *
 *
 * Generate all Combination length, Repetition(No) Σ nCr :  2^n
 *
 */
public class CombinationTest {

    private static Logger log = LoggerFactory.getLogger(CombinationTest.class);


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


    //--------------------------------------------------------
    // Three different algorithm for combination
    //  link : https://shoark7.github.io/programming/algorithm/3-ways-to-get-binomial-coefficients#:~:text=%EC%9D%B4%ED%95%AD%EA%B3%84%EC%88%98(Binomial%20Coefficient)%EB%8A%94,%EB%A7%8C%EC%9D%B4%20%EC%9E%88%EA%B8%B0%20%EB%95%8C%EB%AC%B8%EC%9D%B4%EB%8B%A4.
    //  link : https://shoark7.github.io/programming/algorithm/how-i-approach-algorithm-from-my-way
    //--------------------------------------------------------


    // 1. Basic Using factorial=> n! / (n-k)! / k!
    public int factorial(int n) {
        if (n <= 1) return 1;
        int multiply = n;
        for (int i = n-1 ; i > 0; i--) {
            multiply = multiply * i;
        }
        return multiply;
    }

    public int bino_coef_factorial(int n, int r) {
        return factorial(n) / factorial(r) / factorial(n-r);
    }

    @Test
    public void bino_test() {
        Assert.assertEquals(5, bino_coef_factorial(5,1));
        Assert.assertEquals(10, bino_coef_factorial(5,2));
        Assert.assertEquals(10, bino_coef_factorial(5,3));
        Assert.assertEquals(5, bino_coef_factorial(5,4));
        Assert.assertEquals(1, bino_coef_factorial(5,5));
    }


    @Test
    public void factorial_test() {
        Assert.assertEquals(1, factorial(0));
        Assert.assertEquals(1, factorial(1));
        Assert.assertEquals(2, factorial(2));
        Assert.assertEquals(6, factorial(3));
        Assert.assertEquals(24, factorial(4));
        Assert.assertEquals(120, factorial(5));
    }

    // 2. Using 2 Concept together
    // Given n,k if k is 0 or n == k is same then result is always '1'
    // And
    public int bino_coef(int n, int k) {
        // if k == 0 or n == k same then return 1
        if (k == 0 || n == k) {
            return 1;
        }
        // formula is
         return bino_coef(n-1, k-1) + bino_coef(n-1, k);
    }

    @Test
    public void bino_coef_test() {
        Assert.assertEquals(5, bino_coef(5,1));
        Assert.assertEquals(10, bino_coef(5,2));
        Assert.assertEquals(10, bino_coef(5,3));
        Assert.assertEquals(5, bino_coef(5,4));
        Assert.assertEquals(1, bino_coef(5,5));
    }


    @Test
    public void bino_coef_memo_test() {


        int n = 5;
        int k = 3;
        int[][] memo = new int[n+1][n+1];

        Assert.assertEquals(5, bino_coef_memo(5,1, memo));
        Assert.assertEquals(10, bino_coef_memo(5,2, memo));
        Assert.assertEquals(10, bino_coef_memo(5,3, memo));
        Assert.assertEquals(5, bino_coef_memo(5,4, memo));
        Assert.assertEquals(1, bino_coef_memo(5,5, memo));


    }



    public int bino_coef_memo(int n, int k, int[][] memo) {
        // if k == 0 or n == k same then return 1

        if (memo[n][k] > 0) return memo[n][k];

        if (k == 0 || n == k) {
            return 1;
        }
        // formula is
        return memo[n][k] = bino_coef(n-1, k-1) + bino_coef(n-1, k);
    }


    @Test
    public void per_test() {


        List<Integer> current = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        int[] arr = {1,2,3,4,5,6,7,8,9};
        permutation(3, arr, current, result, new boolean[arr.length]);
        log.debug("hey");
    }

    @Test
    public void comb_test() {


        List<Integer> current = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        int[] arr = {1,2,3};
        permutation(3, arr, current, result, new boolean[arr.length]);
        log.debug("hey");
    }


    public void permutation(int r, int[] arr, List<Integer> current, List<List<Integer>> result , boolean[] used) {
        if ( r == current.size()) {
            // stop
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i = 0; i < arr.length; i++)  {

            if (used[i]) continue;

            used[i] = true;
            current.add(arr[i]);

            permutation(r, arr, current, result, used);

            used[i] = false;
            current.remove(current.size()-1); // backtrack

        }
    }


    @Test
    public void get_all_substring_test() {

        //get_all_substring("abc");
        Assert.assertEquals("wke", longest_substring("pwwkew"));
        Assert.assertEquals("abc", longest_substring("abcabcbb"));
        Assert.assertEquals("b", longest_substring("bbbbb"));


    }

    /**
     * Idea: brute_force
     *
     *   - 1) Generating all substring (inner for loop)
     *   - 2) Check if its valid substring(No duplicate allowed)
     *   - 3) Compare Max substring each time and replace it if needed it
     *
     *
     * @return
     */
    public int longest_substring(String s) {
        // Edge cases
        if (s.length() == 0) return 0;
        if (s.length() == 1) return 1;

        // 1. Generate all with for loopo
        String max_sub_str = s.substring(0,1);

        for (int i=0; i <s.length(); i++) {
            for (int j=i+1; j <= s.length(); j++) {
                String substr = s.substring(i, j);
                // 2. Check if its valid substring(No duplicate allowed)
                if (!is_duplicate_exist(substr)) {
                    // 3. Compare Max substring each time and replace it if needed it
                    if (max_sub_str.length() < substr.length()) max_sub_str = substr;
                }
                //log.debug("substring print: {}", substr);
            }
        }
        return max_sub_str.length();
    }


    @Test
    public void test_dup() {
        Assert.assertFalse(is_duplicate_exist("p"));
        Assert.assertFalse(is_duplicate_exist("pw"));
        Assert.assertTrue(is_duplicate_exist("pww"));
        Assert.assertTrue(is_duplicate_exist("pwwk"));
        Assert.assertTrue(is_duplicate_exist("pwwke"));

        Assert.assertTrue(is_duplicate_exist("pwkwe"));

    }


    /**
     * Comparing sequence manner
     * @param s
     * @return
     */
    public boolean is_duplicate_exist(String s) {
        if (s.length() <= 1) return false;
        Set<Character> set = new HashSet<>();
        for (Character chr : s.toCharArray()) set.add(chr);
        return (set.size() != s.length() );
    }

    /**
     * Comparing sequence manner
     * @param s
     * @return
     */
    public boolean is_duplicate_exist_sequence(String s) {
        if (s.length() <= 1) return false;

        Set<Character> set = new HashSet<>();
        Character prev_chr = null;

        for (Character chr : s.toCharArray()) {
            // If first just skip it
            if (prev_chr == null && prev_chr == chr) return true;
            // swap
            set.add(chr);
            prev_chr = chr;
        }
        return (set.size() != s.length() );
    }


}
