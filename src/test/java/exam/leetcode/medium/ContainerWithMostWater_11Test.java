package exam.leetcode.medium;

import org.junit.Test;

import java.util.Arrays;

public class ContainerWithMostWater_11Test {


    /**
     * Easy way loop O(n^2)
     */
    @Test
    public void brute_force() {
        //[1,8,6,2,5,4,8,3,7]
        // [14,0,12,3,8,3,13,5,14,8]
        int[] given = {14,0,12,3,8,3,13,5,14,8};
        //int[] given = {1,8,6,2,5,4,8,3,7};



       int max = getMostWater(given);


       System.out.println("max value is: " + max);

    }


    /**
     * we can do memo as well
     *  - if x y is same in memo then skip calculation
     * @param height
     * @return
     */
    public int getMostWater(int[] height) {

        int max = 0;


        for (int i =0; i < height.length; i++) {

            for (int j = i+1; j < height.length; j++) {

                // 1. get important vars
                int width = j - i;
                int smaller = (height[i] > height[j]) ? height[j] : height[i];

                // 3. CHECK
                if (max < width * smaller) {
                    max = width * smaller;
                }

                //System.out.println(" i(" + i  + ") * j(" + j  + ") = " + (height[i]*height[j]) + ", check width(" + width  + ") * smaller(" + smaller  + ") = " + (width*smaller));
            }

        }

        return max;
    }




}
