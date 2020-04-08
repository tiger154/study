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
     * while (i < pattern.length && j < text.length)
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
     *  # This is killing part of this problem
     * 	3. If it's '*' then
     *
     *     // s=aab, r=c*a*b*, true
     *     1) if r[i-1] != s[j]
     *       - i++
     *       - current_status = true
     *
     * 	   2) if r[i-1] == s[j]
     * 	       (1) if it's true j++ and compare till fail. ==> inner while!
     * 	           - at the last of loop i++
     * 	           if(r[i-1] == s[j]) {
     *                  while(r[i-1] == s[j] && j < text.length) {
     * 	                    current_status = true;
     * 	                    j++;
     * 	                }
     * 	                i++;
     * 	           }
     *
     * 	   3) if r[i-1] == '.' then
     * 	       - just return true;
     *
     *
     *
     *
     *
     *  // OVER FLOW CONTROL!
     * > if pattern[i] != "*"
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
     * > else
     *
     *     abc 1
     *     a*  (overflow)
     *
     *     ab  1
     *     a*  (overflow)
     *
     *     ab  (overflow)
     *     ab* (overflow)
     *
     * 	   3) length thing
     *        (1) If end of the 'pattern' and j is not overflow => (i >= pattern.length) && (j < text.length)
     *           - return false;
     *        (2) If both of them overflow
     *           - return current_status;
     *
     *
     *
     *
     * 	   - we can solve this part as recruceive. I guess but need to imagine clearly in my head!
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


    public boolean simpleCompare(String text, String pattern) {
        // empty case return
        if (pattern.isEmpty()) return text.isEmpty();
        int pi = 0; // for pattern
        int tj = 0; // for text
        boolean current_status = false;

        // loop for pattern length
        while (pi < pattern.length() && tj < text.length()) {

            // 1. normal char
            if (pattern.charAt(pi) != '*') {
                // 1.1 comma or same char
                if (pattern.charAt(pi) == '.' || pattern.charAt(pi) == text.charAt(tj)) {
                    pi++; tj++;
                    current_status = true;
                } else {
                    pi++;
                    current_status = false;
                }
            // 2. *
            }

            // 3. length control for normal char
            if (  ( pi >= pattern.length() && pattern.charAt(pi-1) != '*' )   ||  (pi == pattern.length()-1 && pattern.charAt(pi) != '*') ) {
                // 3.1 If end of the 'pattern' and 'text' is overflow
                // ab     2 (Over flow)
                // abc    2
                if (pi == pattern.length()-1 && tj >= text.length()) {
                    return false;
                }
                // 3.2 pattern over flow && text over flow
                // ab 2 (Over flow)
                // ab 2 (Over flow)
                if(pi >= pattern.length() && tj >= text.length()) {
                    return current_status;
                }
                // 3.3 pattern over flow && text is end
                // abc  2
                // ab   2 (Over flow)
                if(pi >= pattern.length() && tj == text.length()-1) {
                    return false;
                }

            // 4. length control for *
            }

        }
        return current_status;
    }




    public boolean complexCompare(String text, String pattern) {
        // empty case return
        if (pattern.isEmpty()) return text.isEmpty();
        if (text.isEmpty() && pattern.length() == 2 && pattern.charAt(1) == '*') return true;

        int pi = 0; // for pattern
        int tj = 0; // for text
        boolean current_status = false;

        // loop for pattern length
        while (pi < pattern.length() && tj < text.length() ) {

            // 1. normal char
            if (pattern.charAt(pi) != '*') {
                // 1.1 comma or same char
                if (pattern.charAt(pi) == '.' || pattern.charAt(pi) == text.charAt(tj)) {
                    tj++;
                    current_status = true;

                // 1.2 if next value is not * then just return false
                } else if (pi+1 <= pattern.length()  &&  pattern.charAt(pi+1) != '*') {

                    return false;

                } else {
                    current_status = false;

                }
                pi++;
                // 2. *
            } else if (pattern.length() >= 2 && pattern.charAt(pi) == '*' ) {

                // 2.1 if
                if (pattern.charAt(pi-1) != text.charAt(tj) && pattern.charAt(pi-1) != '.') {
                    current_status = true;
                } else {
                    // iterate till
                    while (tj < text.length() && (pattern.charAt(pi-1) == text.charAt(tj)  || pattern.charAt(pi-1) == '.')   ) {
                        current_status = true;
                        tj++;
                    }
                }

                pi++;
            }

            // 3. length control for normal char
            if (  ( pi >= pattern.length() && pattern.charAt(pi-1) != '*' )   ||  (pi == pattern.length()-1 && pattern.charAt(pi) != '*') ) {


                // 3.1 If end of the 'pattern' and 'text' is overflow
                // ab     2 (Over flow)
                // abc    2
                if (pi == pattern.length()-1 && tj >= text.length()) {
                    return false;
                }
                // 3.2 pattern over flow && text over flow
                // ab 2 (Over flow)
                // ab 2 (Over flow)
                if(pi >= pattern.length() && tj >= text.length()) {
                    return current_status;
                }
                // 3.3 pattern over flow && text is end
                // abc  2
                // ab   2 (Over flow)
                if(pi >= pattern.length() && tj < text.length()) {
                    return false;
                }

                // 4. length control for *
            } else if (  ( pi >= pattern.length() && pattern.charAt(pi-1) == '*' )   ||  (pi == pattern.length()-1 && pattern.charAt(pi) == '*') ) {
                // 4.1 pattern is overflow and text has left to compare
                if(pi >= pattern.length() && tj < text.length()) {
                    return false;
                }
                // 4.2 if both of them over flow
                if(pi >= pattern.length() && tj >= text.length()) {
                    return current_status;
                }
            }

        }
        return current_status;
    }


    /**
     * I have some problem to think in recruceive way
     * need to practice
     * @param text
     * @param pattern
     * @return
     */
    public boolean isMatch_(String text, String pattern) {


        if (pattern.isEmpty()) {
            System.out.println("pattern is empty and text " + text);
            return text.isEmpty();
        } else {
            try {
                System.out.println("text[0]: " + text.charAt(0) + ", pattern[0]: " + pattern.charAt(0) + ", text-orgin: " + text + ", pattern-origin: " + pattern);
            } catch (Exception e) {
                System.out.println("Overflow exception~"+ ", text-orgin: " + text + ", pattern-origin: " + pattern);
            }

        }



        boolean first_match = (!text.isEmpty() &&
                (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

        if (pattern.length() >= 2 && pattern.charAt(1) == '*'){
            return (isMatch_(text, pattern.substring(2)) ||
                    (first_match && isMatch_(text.substring(1), pattern)));
        } else {
            return first_match && isMatch_(text.substring(1), pattern.substring(1));
        }
    }


    /**
     * s=aa, r=a, false
     * s=aa, r=a*, true
     * s=ab, r=.*, true
     * s=, r=.*, true
     * s=abcd, r=.*, true
     * s=abcd, r=e.*, false
     * s=aab, r=c*a*b*, true
     * s=mississippi, r=mis*is*p*, false
     */
    @Test
    public void complex_demo() {


        List<String[]> list = new ArrayList<>();
        list.add(new String[]{"aa","a","false"});
        list.add(new String[]{"aa","a*","true"});
        list.add(new String[]{"ab",".*","true"});
        list.add(new String[]{"",".*","true"});
        list.add(new String[]{"abcd",".*","true"});
        list.add(new String[]{"abcd","e.*","false"});
        list.add(new String[]{"aab","c*a*b*","true"});
        list.add(new String[]{"mississippi","mis*is*p*","false"});
        list.add(new String[]{"mississippi","mis*is*p*.","false"});
        list.add(new String[]{"mississippi","mis*is*ip*.","true"});
        list.add(new String[]{"ab",".*c","false"});
        list.add(new String[]{"aaa","a*a*","true"});
//        list.add(new String[]{"aaa","a*a","true"});



        for (String[] arr: list) {

            boolean result = complexCompare(arr[0], arr[1]);

            StringBuilder sb = new StringBuilder();
            sb.append("text: ").append(arr[0])
                    .append(", pattern: ").append(arr[1])
                    .append(", result: ").append(result)
                    .append(", expected: ").append(arr[2]);

            System.out.println(sb.toString());
        }


        System.out.println("hi there");

    }


    @Test
    public void simple_demo() {


        List<String[]> list = new ArrayList<>();
        list.add(new String[]{"abc","ab","false"});
        list.add(new String[]{"ab","ab","true"});
        list.add(new String[]{"ab","abc","false"});
        list.add(new String[]{"","abc","false"});
        list.add(new String[]{"a","","false"});
        list.add(new String[]{"","","true"});
        list.add(new String[]{"aa","a","false"});


        for (String[] arr: list) {

            boolean result = simpleCompare(arr[0], arr[1]);

            StringBuilder sb = new StringBuilder();
            sb.append("text: ").append(arr[0])
                    .append(", pattern: ").append(arr[1])
                    .append(", result: ").append(result)
                    .append(", expected: ").append(arr[2]);

            System.out.println(sb.toString());
        }


       System.out.println("hi there");

    }



    @Test
    public void rc_demo() {


        List<String[]> list = new ArrayList<>();
        //list.add(new String[]{"aaa","a*a","true"});
        list.add(new String[]{"aaa","a*b","false"});
//        list.add(new String[]{"abc","abc","true"});
//        list.add(new String[]{"abc","ab","false"});
//        list.add(new String[]{"ab","ab","true"});
//        list.add(new String[]{"ab","abc","false"});
//        list.add(new String[]{"","abc","false"});
//        list.add(new String[]{"a","","false"});
//        list.add(new String[]{"","","true"});
//        list.add(new String[]{"aa","a","false"});


        for (String[] arr: list) {

            boolean result = isMatch_(arr[0], arr[1]);

            StringBuilder sb = new StringBuilder();
            sb.append("text: ").append(arr[0])
                    .append(", pattern: ").append(arr[1])
                    .append(", result: ").append(result)
                    .append(", expected: ").append(arr[2]);

            System.out.println(sb.toString());
        }


        System.out.println("hi there");

    }



}
