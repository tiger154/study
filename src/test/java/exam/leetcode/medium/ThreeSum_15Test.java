package exam.leetcode.medium;

import com.jeonhwan.exam.leetcode.medium.ThreeSum_15;
import org.junit.Test;

import java.util.*;

public class ThreeSum_15Test {


    @Test
    public void triplet_test_brute_force() {


//        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10};
       // int[] arr = new int[]{-1, 0, 1, 2, -1, -4};
        int[] arr = new int[]{0,0,0,0};
        //int[] arr = new int[]{-25, -10, -7, -3, 2, 4, 8, 10};
        //-25 -10 -7 -3 2 4 8 10
//        int[] arr = new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        //int[] arr = new int[]{9,14,0,-8,10,0,2,9,-8,13,-3,1,10,-13,4,3,-3,-11,8,-13,-4,-6,5,-10,-14,0,3,-9,-9,-7,-11,8,-8,-4,-15,9,11,3,3,-11,-7,7,5,-12,1,-14,-1,13,-9,-8,7,2,-6,-11,-1,-5,-4,-13,-7,2,-13,-2,-5,-6,9,-12,10,-2,-2,-10,2,6,4,14,2,-10,-15,-14,10,-9,-15,-6,0,-6,-2,14,-3,9,8,-3,-12,10,2,-9,11,-3,-6,-2,10,7,3,-11,-10,-8,-12,-1};

        // [9,14,0,-8,10,0,2,9,-8,13,-3,1,10,-13,4,3,-3,-11,8,-13,-4,-6,5,-10,-14,0,3,-9,-9,-7,-11,8,-8,-4,-15,9,11,3,3,-11,-7,7,5,-12,1,-14,-1,13,-9,-8,7,2,-6,-11,-1,-5,-4,-13,-7,2,-13,-2,-5,-6,9,-12,10,-2,-2,-10,2,6,4,14,2,-10,-15,-14,10,-9,-15,-6,0,-6,-2,14,-3,9,8,-3,-12,10,2,-9,11,-3,-6,-2,10,7,3,-11,-10,-8,-12,-1]

        //
// [0,0,0,0]

        //List<List<Integer>> matched = triplet_test_brute_force(arr);

        ThreeSum_15 threeSum_15 = new ThreeSum_15();
        List<List<Integer>> matched = threeSum_15.bigO2Square(arr);

        System.out.println("hey");
    }







}