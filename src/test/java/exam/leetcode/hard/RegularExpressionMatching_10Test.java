package exam.leetcode.hard;

import com.jeonhwan.exam.leetcode.medium.StringToInteger_8;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class RegularExpressionMatching_10Test {


    /**
     * Sequence and Combination => N.length * N.length - 1 .... * N.length - (N.length - 1)
     *
     *
     * Brute force approach First myself!
     *   - This is important to build my own way to solve a problem
     *   1) Try to understand problem deeply
     *   2) Define input and output around 10th(depend on problem)
     *   3) Define rules what I come up first
     *   4) Debug in my head and edit the rules or add new.
     *
     *   - If I understand problem almost and If I know input/output (clearly), probably I can solve most problems
     *   - If it's to much getting dirty(while writing code) there are strong chance 'some math trick' or 'dp programming way' or 'basic computer sciences'.
     *
     * ## sample input output
     *
     * s=aa, r=a, false
     * s=aa, r=a*, true
     * s=ab, r=.*, true
     * s=, r=.*, true
     * s=abcd, r=.*, true
     * s=abcd, r=e.*, false
     * s=aab, r=c*a*b*, true
     * s=mississippi, r=mis*is*p*, false
     *
     *
     * ## Window sliding approach
     *
     *
     * r = rule
     * s = string
     * current_status = fasle;
     * i=0; // for r index
     * j=0; // for j index
     *
     *
     * while until the end of 'r'.length
     *
     *     1. If it's not * or . then
     *       1) compare => r[i] == s[j]
     *       - if its true, j++, i++
     *       2) if [i+1] == * then
     *         (1) if i == s.length -1 then
     *            break;
     *
     *
     * 	2. If end of the 'r'
     * 	      1) if no more 's' then return true
     * 	      2) if not return false
     *
     *
     *     # This is killing part of this problem
     * 	3. If it's '*' then
     *
     * 	   1) compare r[i-1] == s[j]
     * 	       (1) if it's true j++ and compare till fail. ==> inner while!
     * 	           - at the moment fail increase i++
     *
     * 	   2) if r[i-1] == '.' then
     * 	       - just return true;
     *
     * 	   - we can solve this part as recruceive. I guess but need to imagine clearly in my head!
     *
     * 	4. If it's '.' then
     * 	   1) increase i++, j++
     *
     *
     * 	* when ever it matche current_status=true if not false
     *
     *
     * end while
     *
     *
     * return current_status;
     *
     *
     */
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
