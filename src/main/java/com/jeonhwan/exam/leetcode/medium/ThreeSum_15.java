package com.jeonhwan.exam.leetcode.medium;

import java.util.*;

public class ThreeSum_15 {



    /**
     * O(N^2)
     *
     *    - Lets check this https://github.com/eMahtab/three-sum and prepare myself
     *    - Idea
     *    - Pin an element, and find two elements When find element two we use two pointer strategy
     *    - Compare Index + low + high is zero if over zero it means we need smaller value so high--, vice versa
     *    - In second loop we keep look for cases into middle point(low<high).
     *    - Check duplicate each loop start
     *    - As it's sorted we can skip if same value for each side(left, right)
     *
     *     - Note: I was confused how to make all possible combination first (bruteforce)
     *             I didn't come up simple Idea like Pin one element, and use two pointer strategy
     * @param nums
     * @return
     */
    public List<List<Integer>> bigO2Square(int[] nums) {

        Arrays.sort(nums);

        ArrayList<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length-2; i++) {
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
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;    // start++
                    k--;   // end--
                }
            }
        }

        return result;


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
}
