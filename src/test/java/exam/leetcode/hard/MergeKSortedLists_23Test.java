package exam.leetcode.hard;

import com.jeonhwan.algorithm.sort.MergeSort;
import com.jeonhwan.exam.leetcode.hard.MedianOfTwoSortedArrays_4;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MergeKSortedLists_23Test {

    private static Logger log = LoggerFactory.getLogger(MergeSort.class);


    /**
     * using merge sort way but check 3
     * O(n)
     *
     * given array a,b,c
     * index i,j,k
     * result array d
     *
     * loop till end of two of them is done.
     * get min(min(a,b),c)
     *
     * increase min index and set to d.
     *
     * How to get min linked list
     *   - Simple smallest and foreach k time each index, So every time at least need to check k time
     *
     *   let say 2 array has two item
     *
     *
     * last_array = null;
     *
     * while(true) {
     *
     *    1. exit when only one array left
     *
     *
     *     - current_smallest = a
     *    2. for(item : k) k time {
     *        if(item.val < a) {
     *            current_smallest = item
     *            item = item.next
     *        }
     *    }
     *
     *    3. Add smallest node
     *      d.next = current_smallest.val;
     *
     * }
     *
     * // left data insert
     * if(last_array is not null) {
     *     d.next = last_array
     * }
     *
     * then it's gonna work
     *
     *
     */
    @Test
    public void first_approach() {

        // lets make 3 array merge!

        log.debug("test for fun programming");

    }


    /**
     *  It's interesting
     *    1) traverse all elements -> to an array
     *    2) sort
     *    3) make new list
     *
     */
    public void brute_force() {

    }


}
