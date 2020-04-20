package exam.leetcode.medium;

import com.jeonhwan.exam.leetcode.medium.ContainerWithMostWater_11;
import org.junit.Test;

import java.util.Arrays;

public class ContainerWithMostWater_11Test {

    /**
     * Easy way loop O(n^2)
     */
    @Test
    public void bigON_test() {
        //[1,8,6,2,5,4,8,3,7]
        // [14,0,12,3,8,3,13,5,14,8]
        //int[] given = {14,0,12,3,8,3,13,5,14,8};
        int[] given = {1,8,6,2,5,4,8,3,7};


        ContainerWithMostWater_11 solution =  new ContainerWithMostWater_11();

        int max = solution.bigON(given);


        System.out.println("max value is: " + max);

    }


    /**
     * Easy way loop O(n^2)
     */
    @Test
    public void brute_force() {
        //[1,8,6,2,5,4,8,3,7]
        // [14,0,12,3,8,3,13,5,14,8]
        int[] given = {14,0,12,3,8,3,13,5,14,8};
        //int[] given = {1,8,6,2,5,4,8,3,7};


        ContainerWithMostWater_11 solution =  new ContainerWithMostWater_11();
       int max = solution.bigONSquare(given);


       System.out.println("max value is: " + max);

    }




}
