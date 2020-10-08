package play;

import com.jeonhwan.algorithm.sort.MergeSort;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoopTest {
    private static Logger log = LoggerFactory.getLogger(MergeSort.class);


    /**
     * Practice iteration
     *
     * Make triangle below ->
     * *****
     * ****
     * ***
     * **
     * *
     *
     * 01234
     * 0123
     * 012
     * 01
     * 0
     *
     */
    @Test
    public void triangle_star_test() {

        int length = 5;

        String line = "";
        String num_line="";

        for(int i =0; i < length; i++) {
            line = "";
            num_line = "";
            for(int j =0; j < length - i; j++) {
                line = line.concat("*");
                num_line = num_line.concat(String.valueOf(j));
                if (j+1 == length - i) {
                    log.debug("line: {}, num_line: {}", line, num_line);
                }
            }
        }
    }

    /**
     * This loop run consecutive number time of given length.
     *
     * Let say given number is 6 then
     *  It iterate -> n^2+n/2 => n * (n + 1) /2 => 6 * (6 +1) /2 => 21
     */
    @Test
    public void print_index_for_substring_dp() {

        int length = 6;

        String num_line="";

        int index = 0;
        int hey = 6 * (6 + 1) / 2;

        for(int i =0; i < length; i++) {
            num_line = "";
            for(int j =0; j < length - i; j++) {
                index++;
                num_line = num_line.concat("[").concat(String.valueOf(j)).concat("|").concat(String.valueOf(j+i)).concat("]");
                if (j+1 == length - i) {
                    log.debug("num_line: {}", num_line);
                }
            }
        }

        log.debug("done");
    }


    /**
     * print triplet combination. no duplicate,
     *   - Oky we don't have to make 순열 this is combination, no duplication allowed
     *   - loop over O(N^3) approach it's gonna work. but when it doesn't have to reach to the last node. it should be last length -2
     *   -
     */
    @Test
    public void triplet_test_brute_force() {

        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10};
        int index = 0;
        //
        for(int i =0; i < arr.length; i++) {
            for(int j =i+1; j < arr.length; j++) {
                for (int k =j+1; k < arr.length; k++) {
//                    log.debug("i: {}, j:{}, k:{}, sum:{}", i,j,k, i+j+k);
                    log.debug("i: {}, j:{}, k:{}, arr[i]: {}, arr[j]:{}, arr[k]:{}, sum:{}", i,j,k, arr[i], +arr[j], +arr[k] , arr[i]+arr[j]+arr[k]);
                    index++;
                }
            }
        }
        log.debug("index: {}", index);

    }

    //---------------------------------------------------------
    //   Simple Iteration vs Recursive compare implementation
    //---------------------------------------------------------
    // 1 -> 10
    @Test
    public void sum_test_itr() {
        int rtn =0;
        for (int i =1; i <= 10; i++) {
            rtn += i;
        }
        log.debug("rtn: {}", rtn);
    }

    @Test
    public void sum_test_recursive() {
        int rtn = sum_test_recursive(10, 1, 0);
        Assert.assertEquals(55, rtn);
    }

    /**
     * wow it's simple !
     * @param time
     * @param num
     * @param rtn
     * @return
     */
    public int sum_test_recursive(int time, int num, int rtn) {
        rtn += num;
        if (time == num) return rtn;
        return sum_test_recursive(time, num+1, rtn);
    }



}
