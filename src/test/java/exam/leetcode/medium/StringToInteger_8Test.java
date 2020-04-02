package exam.leetcode.medium;

import com.jeonhwan.exam.leetcode.medium.LongestPalindromicSubstring_5;
import com.jeonhwan.exam.leetcode.medium.StringToInteger_8;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class StringToInteger_8Test {

    @Test
    public void bigON() {

        List<String> list = new ArrayList<>();

        list.add("123");
        list.add("  123");
        list.add("  -123");
        list.add("  -123word");
        list.add("hey there  -123word");
        list.add("--123word");
        list.add("- 123word");
        list.add("-91283472332");
        list.add("91283472332");
        list.add("+1");
        list.add("+-1");
        list.add("2147483646");



        StringToInteger_8 solution = new StringToInteger_8();

        for(String str :list) {
            int sum_unicode = solution.myAtoi(str);
            System.out.println("String: " +str + ", Integer: " + sum_unicode);
        }



    }



}
