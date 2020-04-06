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
     * ############################################
     *
     * pattern = rule
     * text = string
     * // if no rule return true if s is empty
     * if r.length == 0 then return s.isEmpty();
     *
     *
     * // iterate for r length => we can block overflow here! yes
     * while (i < pattern.length)
     *
     *
     *  1. If it's not * =>  if pattern[i] != "*"
     *
     *       1) if pattern[i] == '.' then
     *          -  j++, i++
     *
     *       2) else if && pattern[i] == text[j]
     *           - if its true, j++, i++
     *           - current_status = true;
     *          else
     *           - i++
     *           - current_status = false;
     *
     *
     *
     *       // If overflow of R
     *
     * 	  // If end of the 'r' is overflow
     *       abc    2
     *       ab     2(Over flow)
     *
     *       ab     2(Over flow)
     *       ab     2(Over flow)
     *
     *    // If end of the r is not but s is overflow
     *       ab     2(Over flow)
     *       abc    2
     *
     *       3) If end of the 'pattern' and 'text' is overflow  (i == pattern.length-1) && (j >= text.length)
     *          - then return false
     *
     *       4) over flow of 'pattern' (i >= pattern.length)
     *
     *         2) if j is overflow of 'text' then return current status
     * 	         - if (j >= text.length) return current_status;
     *
     * 	       1) if j is end of 'text' then return false
     * 	         - if (j == text.length -1) return false;
     *
     *
     *       continue;
     *
     *
     *
     *
     *     # This is killing part of this problem
     * 	3. If it's '*' then
     *
     *     // s=aab, r=c*a*b*, true
     *     1) if r[i-1] != s[j]
     *       - i++
     *       - current_status = true
     *       - break;
     *
     * 	   2) if r[i-1] == s[j]
     * 	       (1) if it's true j++ and compare till fail. ==> inner while!
     * 	           - at the moment fail increase i++
     *
     * 	   3) if r[i-1] == '.' then
     * 	       - just return true;
     *
     *
     * 	   3) length thing
     *
     *
     * 	   - we can solve this part as recruceive. I guess but need to imagine clearly in my head!     *
     *
     *
     * 	* when ever it matche current_status=true if not false
     *
     * end while
     *
     *
     * return current_status;
     *
     *
     *
     *
     *
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
