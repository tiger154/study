package exam.leetcode.medium;

import com.jeonhwan.exam.leetcode.medium.LongestPalindromicSubstring_5;
import org.junit.Test;

public class LongestPalindromicSubstring_5Test {

    @Test
    public void dpBigO2() {
        LongestPalindromicSubstring_5 solution = new LongestPalindromicSubstring_5();


//        String s = "babad";
//        String s = "cbbd";
//        String s = "a";
//        String s = "aa";
//        String s = "ac";
//        String s ="abcda";
        String s = "";


        String longest_string = solution.dpBigO2(s);


        System.out.println("longest: " + longest_string);
    }


    @Test
    public void lcsBigO3() {
        LongestPalindromicSubstring_5 solution = new LongestPalindromicSubstring_5();


//        String s = "babad";
//        String s = "cbbd";
//        String s = "a";
//        String s = "aa";
//        String s = "ac";
        String s ="abcda";
//        String s = "";


        String longest_string = solution.lcsBigO3(s);


        System.out.println("longest: " + longest_string);
    }


    @Test
    public void bigOMultiple3() {
        LongestPalindromicSubstring_5 solution = new LongestPalindromicSubstring_5();


//        String s = "babad";
//        String s = "cbbd";
//        String s = "a";
//        String s = "aa";
        String s = "ac";
//        String s = "";


        String longest_string = solution.bigOMultiple3(s);


        System.out.println("longest: " + longest_string);
    }

}
