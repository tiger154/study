package com.jeonhwan.exam.leetcode.medium;

public class RotateImage_48 {

    /**
     * I solved totally myself but took time bit longer then it should be
     * and while debugging in my head there was bit of index calculation was wrong.
     *
     * But most part of my own Idea was similar and result I quit like compare to those answer!
     * also why assert packages don't have multi array equals -_-; so i just made my self!
     *
     * For this I visualize rotation myself, and try to find patterns.
     * And head debugging started it. I wrote down ground rules. and through my Idea (4 rectangle swap)
     *
     * I made while exit condition, core logic, what is the rule each loop one by one. index by index.
     * And I polish more and more.
     *
     * So it looks good and I can tell it's my own result!
     */
    public void first_approach(int[][] matrix) {
        // edge cases!
        if (matrix.length == 1) {
            return;
        }

        int total_numbers = matrix.length * matrix.length;  // total element
        int x,y,index,mask; x = y = index = mask = 0;
        int x_max, y_max; x_max = y_max = matrix.length-1;

        while (index * 4 < total_numbers-1) {
            // when all out line is done how do i know?
            if ( (index > 0) && (index % (x_max) == 0) ) {
                x++;  y++;  x_max--; y_max--; mask=0;
            }
            // First swap  1) y+1, x+1 - 0,0 <-> 0,length-1
            swap(matrix, x, y+mask , x+mask, y_max);
            // Second swap 2) y+1, y_max-1  - 0,0 <-> length-1,length-1
            swap(matrix, x, y+mask, x_max, y_max-mask);
            // Third swap  3) y+1, x-1 - 0,0 <-> length-1,0
            swap(matrix, x, y+mask , x_max-mask, y);

            index++;
            mask++;
        }
    }

    public void swap(int[][] matrix, int lx, int ly, int rx, int ry) {
        int temp = matrix[rx][ry];
        matrix[rx][ry] = matrix[lx][ly];
        matrix[lx][ly] = temp;
    }



    /**
     *
     * From LeetCode discussion: https://leetcode.com/problems/rotate-image/discuss/18872/A-common-method-to-rotate-the-image
     *
     * This is also quit smart Idea then mine
     *
     * It make everything really simple and elegant
     *
     * > clockwise just swap top-bottom and swap the symmetry
     * > anti-clockwise just swap left-right and swap the symmetry
     *
     * I think this kind of insight comes from experience of solving problems and math experience.
     * As If I think about rotating some matrix.. probably there is many Ideas from math
     *
     * But I think important thing is, first I need to find brute-force myself.
     * second, If interviewer gives some hint I should be able to swallow it as mine.
     *
     * That is I can tell If you are good at math is definitely good, but it's not required required, If you can take interviewers hint!
     * I don't have to be Math genius but should be able to understand what genius saying something at least.
     *
     * And based on that If you can breakdown your strategy and make sudo code and make actual code.
     * That's I can call a solution as a programmer.
     *
     *
     */
    public void second_approach(int[][] matrix) {
        int s = 0, e = matrix.length - 1;
        while(s < e){
            int[] temp = matrix[s];
            matrix[s] = matrix[e];
            matrix[e] = temp;
            s++; e--;
        }

        for(int i = 0; i < matrix.length; i++){
            for(int j = i+1; j < matrix[i].length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
