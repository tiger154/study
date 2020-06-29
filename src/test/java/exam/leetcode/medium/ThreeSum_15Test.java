package exam.leetcode.medium;

import org.junit.Test;

import java.util.*;

public class ThreeSum_15Test {


    @Test
    public void triplet_test_brute_force() {


//        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10};
       // int[] arr = new int[]{-1, 0, 1, 2, -1, -4};
        int[] arr = new int[]{0,0,0,0};
//        int[] arr = new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        //int[] arr = new int[]{9,14,0,-8,10,0,2,9,-8,13,-3,1,10,-13,4,3,-3,-11,8,-13,-4,-6,5,-10,-14,0,3,-9,-9,-7,-11,8,-8,-4,-15,9,11,3,3,-11,-7,7,5,-12,1,-14,-1,13,-9,-8,7,2,-6,-11,-1,-5,-4,-13,-7,2,-13,-2,-5,-6,9,-12,10,-2,-2,-10,2,6,4,14,2,-10,-15,-14,10,-9,-15,-6,0,-6,-2,14,-3,9,8,-3,-12,10,2,-9,11,-3,-6,-2,10,7,3,-11,-10,-8,-12,-1};

        // [9,14,0,-8,10,0,2,9,-8,13,-3,1,10,-13,4,3,-3,-11,8,-13,-4,-6,5,-10,-14,0,3,-9,-9,-7,-11,8,-8,-4,-15,9,11,3,3,-11,-7,7,5,-12,1,-14,-1,13,-9,-8,7,2,-6,-11,-1,-5,-4,-13,-7,2,-13,-2,-5,-6,9,-12,10,-2,-2,-10,2,6,4,14,2,-10,-15,-14,10,-9,-15,-6,0,-6,-2,14,-3,9,8,-3,-12,10,2,-9,11,-3,-6,-2,10,7,3,-11,-10,-8,-12,-1]

        //
// [0,0,0,0]

        List<List<Integer>> matched = triplet_test_brute_force(arr);

        System.out.println("hey");
    }


    /**
     *
     * O(N^3)
     *  - To me it's important to imagine brute-force first myself.
     *  - I was confused if I can get all combination with-in loop 3 times. So I draw each element and each loop myself
     *    And Yes it can take all possible combinations.
     *  - For unique check I use Set, but probably this is not a good approach.
     *  - It passed most of cases, but blocked by Time Limit Exceeded
     *
     *  - Now Need to study to make it O(N^2) with two pointers.
     *
     * @param arr
     * @return
     */
    public List<List<Integer>> triplet_test_brute_force(int[] arr) {
        Set<String> unique_keys = new HashSet<>();
        List<List<Integer>> matched_list = new ArrayList<>();
//        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10};
        // int[] arr = new int[]{-1, 0, 1, 2, -1, -4};
        int index = 0;
        // need to get unique then sort the data. and... N^2 or N2log
        // we can sort it means we can check duplication...
        // -4 -1 0 1 2
        Arrays.sort(arr);


        for(int i =0; i < arr.length; i++) {

            // Remove duplication for unique value
            if (i > 0 && arr[i] == arr[i-1]) { continue; }

            for(int j =i+1; j < arr.length; j++) {

                int ij = arr[i] + arr[j];
                for (int k =j+1; k < arr.length; k++) {

                    // Check if all sum values is zero! then... insert that index.

                    boolean is_exist = unique_keys.contains(String.format("%s%s%s", arr[i], arr[j], arr[k]));

                    if(ij + arr[k] == 0 && !is_exist) {
                        // Create triplet list
                        List<Integer> matched_triplet  = new ArrayList<Integer>();
                        matched_triplet.add(arr[i]);
                        matched_triplet.add(arr[j]);
                        matched_triplet.add(arr[k]);
                        // Add triplet
                        matched_list.add(matched_triplet);
                        unique_keys.add(String.format("%s%s%s", arr[i], arr[j], arr[k]));
                    }
//                    log.debug("i: {}, j:{}, k:{}, sum:{}", i,j,k, i+j+k);
//                    log.debug("i: {}, j:{}, k:{}, arr[i]: {}, arr[j]:{}, arr[k]:{}, sum:{}", i,j,k, arr[i], +arr[j], +arr[k] , arr[i]+arr[j]+arr[k]);

                    index++;
                }
            }
        }


        return matched_list;
    }


    /**
     * O(N^2)
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        ArrayList<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            while (j < k) {
                if (k < nums.length - 1 && nums[k] == nums[k + 1]) {
                    k--;
                    continue;
                }

                if (nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                } else {
                    ArrayList<Integer> l = new ArrayList<>();
                    l.add(nums[i]);
                    l.add(nums[j]);
                    l.add(nums[k]);
                    result.add(l);
                    j++;
                    k--;
                }
            }
        }

        return result;
    }

}
