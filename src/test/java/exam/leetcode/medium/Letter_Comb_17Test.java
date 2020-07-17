package exam.leetcode.medium;

import com.jeonhwan.exam.leetcode.medium.Letter_Comb_17;
import com.jeonhwan.exam.leetcode.medium.ThreeSum_15;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Letter_Comb_17Test {


    /**
     * Combination: Unique, Order of outcomes doesn't matter
     * <p>
     * Fomular: nCr => n! / r! * (n-r)!   => 6! / 2! * (6-2)!
     * n: Total number of items
     * r: represents the number of items being chosen at a time.
     * <p>
     * <p>
     * <p>
     * I thought it's general combination problem. but it's not.
     * Each number hold 3 and can't make combination itself
     * ex) if choose number 2(a,b,c), 3(d,e,f).
     * - ab is not possible.(X)
     * - ad is possible     (O)
     * <p>
     * So then it's smaller and easier and faster then normal combination.
     * <p>
     * We can think about a tree structure, If we given  2(a,b,c), 3(d,e,f), 4(h,i,j)
     * It looks like below.  each level we just multiply of length in this case 3 * 3 * 3 = 27
     * <p>
     * 3             a                       b                        c
     * |                       |                        |
     * --------------          --------------          --------------
     * 3       d      e      f         d      e      f         d      e      f
     * |      |      |         |      |      |         |      |      |
     * -----  -----  -----     -----  -----  -----     -----  -----  -----
     * 3    g h i  g h i  g h i     g h i  g h i  g h i      g h i  g h i  g h i
     * <p>
     * adg,adh,adi             bdg, bdh, bdi            cdg, cdh, cdi
     * aeg,aeh,aei             beg, beh, bei             ceg, ceh, cei
     * afg,afh,ahi             bfg, bfh, bfi            cfg, cfh, cfi
     * <p>
     * 9                         9                    9               = 27
     * <p>
     * <p>
     * And we can use Backtracking (https://thd0011.tistory.com/19)
     * <p>
     * <p>
     * But this is not backtracking I guess. This is just DFS
     */


    @Test
    public void triplet_test_brute_force() {


        String digit = "23";

        List<String> combinations = letterCombinations(digit);

        System.out.println("hey");
    }


    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    List<String> output = new ArrayList<>();

    public void backtrack(String combination, String next_digits) {
        // if there is no more digits to check
        if (next_digits.length() == 0) {
            // the combination is done
            output.add(combination);
        }
        // if there are still digits to check
        else {
            // iterate over all letters which map
            // the next available digit
            String digit = next_digits.substring(0, 1);
            String letters = phone.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = phone.get(digit).substring(i, i + 1);
                // append the current letter to the combination
                // and proceed to the next digits
                backtrack(combination + letter, next_digits.substring(1));
            }
        }
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() != 0)
            backtrack("", digits);
        return output;
    }


    @Test
    public void mySolution() {

        Letter_Comb_17 letter_comb_17 = new Letter_Comb_17();

        letter_comb_17.backtrack("23");

        List<String> result = letter_comb_17.getCombinations();
    }


}