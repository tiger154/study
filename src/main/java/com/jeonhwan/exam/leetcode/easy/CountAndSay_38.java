package com.jeonhwan.exam.leetcode.easy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CountAndSay_38 {
    private static Logger log = LoggerFactory.getLogger(CountAndSay_38.class);

    /**
     * Implemented myself
     *   1. Understanding the problem took some time
     *     - I couldn't understand from the description, but after I checked discussion section of sequence I understood what is the problem.
     *     - link: https://leetcode.com/problems/count-and-say/discuss/16015/Please-change-the-misleading-description
     *
     *   2. I wrote down sequence myself first from 1th to 10th expected result
     *   3. Just brought simple for loop idea and implemented it (passed but not great, so gonna try other way as well)
     *     - Runtime: 15 ms, faster than 28.21% of Java online submissions for Count and Say.
     *
     * @param n
     * @return
     */
    public String first_approach(int n) {

        String text = "1";
        String read_text = "";

        // Edge case just return right away
        if (n <= 0) return "-1";
        if (n == 1) return text;

        // loop nth-1 time
        for (int i = 0; i < n-1; i++) {

            Character prev_text = text.charAt(0);
            int prev_count = 0;
            // loop length of the text
            for (int j =0; j < text.length(); j++) {

                if (prev_text.equals(text.charAt(j))) {
                    prev_count++;
                    if (j == text.length()-1) read_text += (Integer.toString(prev_count) + prev_text);

                } else {
                    read_text += (Integer.toString(prev_count) + prev_text);

                    prev_text = text.charAt(j);
                    prev_count = 1;

                    if (j == text.length()-1) read_text += (Integer.toString(prev_count) + prev_text);
                }
            }
            text = read_text;
            read_text = "";
        }

        log.debug("text: {}", text);
        return text;
    }


    /**
     * I just changed to use StringBuilder which is 5 times faster then normal string concatenation.
     *   - Runtime: 3 ms, faster than 48.18% of Java online submissions for Count and Say.
     *
     * @param n
     * @return
     */
    public String second_approach(int n) {

        String text = "1";
        StringBuilder builder = new StringBuilder();

        // Edge case just return right away
        if (n <= 0) return "-1";
        if (n == 1) return text;

        // loop nth-1 time
        for (int i = 0; i < n-1; i++) {

            Character prev_text = text.charAt(0);
            int prev_count = 0;
            // loop length of the text
            for (int j =0; j < text.length(); j++) {

                if (prev_text.equals(text.charAt(j))) {
                    prev_count++;
                    if (j == text.length()-1) builder.append(prev_count).append(prev_text);

                } else {
                    builder.append(prev_count).append(prev_text);

                    prev_text = text.charAt(j);
                    prev_count = 1;

                    if (j == text.length()-1) builder.append(prev_count).append(prev_text);

                }
            }
            text = builder.toString();
            builder = new StringBuilder();

        }

        log.debug("text: {}", text);
        return text;
    }
}
