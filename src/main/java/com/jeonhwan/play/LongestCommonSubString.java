package com.jeonhwan.play;

public class LongestCommonSubString {
    public LongestCommonSubString() {
    }


    /**
     *
     * Take a string length n=4, say: "ABCD"
     *
     * The sub-strings of the above are (by length):
     *
     * 1 character: A,B,C,D (4 sub-strings)
     * 2 character: AB,BC,CD, (3 sub-strings)
     * 3 character: ABC,BCD (2 sub-strings)
     * 4 character: ABCD (1 sub-string)
     * Totaling the numbers yields: 1+2+3+4 = 10.
     *
     * So, to generalize, the number of possible sub-strings is the sum of all integers from 1 to n.
     * This sum is calculated using the formula (n^2 + n) / 2 (see here: Sum of Consecutive Numbers)
     *
     *    (n^2 + n) / 2 => n * (n + 1) / 2
     *
     * - https://stackoverflow.com/questions/24901537/how-many-substrings-of-a-string
     *
     * @param str
     * @return
     */
    public int getTotalSubstringCount(String str) {
        int n = str.length();
        return n * (n + 1) / 2;
    }


    /**
     * 1) Solution
     *   - Big O notation: O(N^2)
     *   - Use metrics to find out -> When we finished to draw this metrics, we can see what is the longest as well.
     *   - Make array A to row, make array B to fields
     *   -
     *
     * 2) pseudo code
     *  - int longest = 0
     *  -
     *  - for i in A loop
     *     for j in B loop
     *        if(A[i-1][j-1] > 0)
     *          A[i][j] = A[i-1][j-1] + 1;
     *          // set count
     *          longest = (longest < A[i][j]) ?  A[i][j] : longest;
     *          // set chars
     *        else
     *          A[i][j] = 0;
     *
     *
     *
     * @param a
     * @param b
     * @return
     */
    public int findLongestCommonSubString(char[] a, char[] b) {

        int longest = 0;
        int longest_last_index = a.length;
        // 1. metrics to draw
        int[][] metrics = new int[a.length][b.length];

        // 2. loop to make a metrics
        for (int i = 0; i < a.length; i++) {

            for (int j = 0; j < b.length; j++) {

                // 3.1 If value is same
                 if(a[i] == b[j]) {
                     // 3.2 If it's not first row or field {0,j}, {i,0}
                     if (i > 0 && j > 0) {
                         // 3.3 Set data with sum of [i-1][j-1]
                         metrics[i][j] =  metrics[i-1][j-1] + 1;
                         // 3.3 set longest data
                         if(longest < metrics[i][j]) {
                             longest = metrics[i][j];
                             longest_last_index = i;
                         }

                     // 3.4 If it's first row or field
                     } else {
                         metrics[i][j] =  1;
                     }
                 // 3.5 not matched then zero
                 } else {
                     metrics[i][j] = 0;
                 }
            }
        }

        String a_string = a.toString();

        a_string.substring(longest_last_index - longest, longest_last_index);

        return longest;
    }

}
