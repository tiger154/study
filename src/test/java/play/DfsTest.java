package play;

import com.jeonhwan.algorithm.sort.MergeSort;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DfsTest {

    private static Logger log = LoggerFactory.getLogger(DfsTest.class);


    @Test
    public void dfs_test() {

        int[] arr = {1,2,3};

        dfs(0, new int[arr.length], new boolean[arr.length], arr);

    }


    /**
     *
     * Idea : Make a binary tree depth is (N +1)
     *
     *        First Recursive always put true of N level
     *
     *        exit if n == arr.length and print of arr by used[n] == true only
     *
     *        1) Level Index make as true used[n] = true
     *        2) f(n+1, used, arr)
     *        3) Backtrack:
     *           - used[n] = false
     *        4) f(n+1, used, arr)
     *
     *
     *
     *
     *
     *
     *
     * @param n
     * @param result
     * @param visit
     * @param arr
     */
    public void dfs(int n, int[] result, boolean[] visit, int arr[]) {

        if (n == result.length) {
            for (int i =0; i < visit.length; i++) {
                if (visit[i]) {
                    System.out.print(arr[i]);
                }
            }
            System.out.println();
        } else {
            System.out.println("depth : " + n);

            visit[n] = true;
            result[n] = arr[n];
            dfs(n+1, result, visit, arr);
            visit[n] = false;
            dfs(n+1, result, visit, arr);

        }


    }



}
