package exam.leetcode.medium;

import com.jeonhwan.exam.leetcode.medium.LongestPalindromicSubstring_5;
import com.jeonhwan.exam.leetcode.medium.MedianOfTwoSortedArrays_4;
import org.junit.Test;

public class LongestPalindromicSubstring_5Test {



    @Test
    public void bigOLogN_test() {
        LongestPalindromicSubstring_5 solution = new LongestPalindromicSubstring_5();


//        String s = "babad";
//        String s = "cbbd";
//        String s = "a";
//        String s = "aa";
        String s = "";


        String longest_string = solution.bigOMultiple3(s);


        System.out.println("longest: " + longest_string);
    }

}
