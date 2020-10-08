package play;


import com.jeonhwan.algorithm.sort.MergeSort;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Good thing for binary search is obviously Better performance O(LogN).
 *
 *
 *
 * Given a sorted array arr[] of n elements, write a function to search a given element x in arr[].
 *
 * A simple approach is to do linear search. The time complexity of above algorithm is O(n). Another approach to perform the same task is using Binary Search.
 *
 * Binary Search: Search a sorted array by 'repeatedly dividing the search interval in half'. Begin with an interval covering the whole array.
 * If the value of the search key is less than the item in the middle of the interval, narrow the interval to the lower half. Otherwise narrow
 * it to the upper half. Repeatedly check until the value is found or the interval is empty.
 *
 * Example
 *
 *  Search 23  [2,5,8,12,16,23,38,56,72,91]
 *  23 > 16  [2,5,8,12,[16],23,38,56,72,91]
 *    - Low=0, Mid=4, Height=9
 *  23 > 16  [2,5,8,12,16,23,38,[56],72,91]
 *    - Low=5(Previous mid+1), Mid=7(low+height/2), Height=9
 *  23 < 56  [2,5,8,12,16,[23],38,56,72,91]
 *    - Low=5, Mid=5(low+height/2), Height=6(Previous mid -1)
 *
 *  What is the key logic rule here
 *
 *    if (target > mid) --> go to right part
 *       - low = mid+1, mid=low+height/2
 *    if (target < mid) --> go to left part
 *       - end = mid-1, mid=low+height/2
 *
 *  Exit condition: if middle = target or low <= high(length) of array
 *
 *  So by the condition it control mid+-1 to low or end.
 *
 *  And for now let's forget about edge condition to improve performance.
 *  And let's implement both iterate and recursive way.
 *
 */
public class BinarySearchTest {
    private static Logger log = LoggerFactory.getLogger(MergeSort.class);

    @Test
    public void binary_search_itr_test() {

        int[] arr = {2,5,8,12,16,23,38,56,72,91};

        Assert.assertEquals(0, binary_search_itr(arr, 2));
        Assert.assertEquals(1, binary_search_itr(arr, 5));
        Assert.assertEquals(2, binary_search_itr(arr, 8));
        Assert.assertEquals(3, binary_search_itr(arr, 12));
        Assert.assertEquals(4, binary_search_itr(arr, 16));
        Assert.assertEquals(5, binary_search_itr(arr, 23));
        Assert.assertEquals(6, binary_search_itr(arr, 38));
        Assert.assertEquals(7, binary_search_itr(arr, 56));
        Assert.assertEquals(8, binary_search_itr(arr, 72));
        Assert.assertEquals(9, binary_search_itr(arr, 91));

        Assert.assertEquals(-1, binary_search_itr(arr, 100));

    }


    @Test
    public void binary_search_recursive_test() {

        int[] arr = {2,5,8,12,16,23,38,56,72,91};
        int low = 0, high = arr.length-1;

        Assert.assertEquals(0, binary_search_recursive(arr, low, high,  2));
        Assert.assertEquals(1, binary_search_recursive(arr, low, high,  5));
        Assert.assertEquals(2, binary_search_recursive(arr, low, high,  8));
        Assert.assertEquals(3, binary_search_recursive(arr, low, high,  12));
        Assert.assertEquals(4, binary_search_recursive(arr, low, high,  16));
        Assert.assertEquals(5, binary_search_recursive(arr, low, high,  23));
        Assert.assertEquals(6, binary_search_recursive(arr, low, high,  38));
        Assert.assertEquals(7, binary_search_recursive(arr, low, high,  56));
        Assert.assertEquals(8, binary_search_recursive(arr, low, high,  72));
        Assert.assertEquals(9, binary_search_recursive(arr, low, high,  91));

        Assert.assertEquals(-1, binary_search_recursive(arr, low, high,  100));

    }

    /**
     * Implement with normal loop
     *
     * @param arr
     * @param target
     * @return
     */
    public int binary_search_itr(int[] arr, int target) {

        int low = 0, high = arr.length-1;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (target == arr[mid]) return mid;

            if (target > arr[mid])
                low = mid + 1;
            else
                high = mid -1;
        }
        return -1;
    }






    public static int binary_search_recursive(int[] arr, int low, int high, int target) {
        // exit condition
        if (low <= high) {

            int mid = (low + high) / 2;
            // Exit condition: when found value
            if (arr[mid] == target) return mid;
            // actual logic
            if (target > arr[mid])
                return binary_search_recursive(arr, mid+1, high, target);
            else
                return binary_search_recursive(arr, low, mid-1, target);
        }
        return -1;
    }





}
