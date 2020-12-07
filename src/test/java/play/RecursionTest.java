package play;

import com.jeonhwan.algorithm.sort.MergeSort;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RecursionTest {

    private static Logger log = LoggerFactory.getLogger(RecursionTest.class);

    //---------------------------------------------------
    // Count Down
    //  - Print from n to 1.
    //  * Rule: n-1
    //---------------------------------------------------

    public int count_down_recursion(int n) {
        log.debug("count down: {}", n);
        if (n == 1) return 1;
        return count_down_recursion(n-1);
    }

    @Test
    public void count_down_recursion_test() {
        count_down_recursion(10);
    }

    //---------------------------------------------------
    // GuGu
    //   - Print all result given n from r
    //   * Rule: 1) r-1
    //---------------------------------------------------

    public void gugu(int n, int r) {
        log.debug("{} x {} = {}", n, r, n*r);
        if (r==1) return;
        gugu(n, r-1);
    }

    @Test
    public void gugu_test() {
        gugu(2,9);
    }





    //---------------------------------------------------
    // Gauss
    // Sum of number from 1 to n.
    // * Rule: 1) func(n-1) + n
    //---------------------------------------------------

    public int gause_recursion(int n) {
        if (n == 0) return 0;
        return gause_recursion(n-1) + n;
    }

    @Test
    public void gause_recursion_test() {
        Assert.assertEquals(15, gause_recursion(5));
        Assert.assertEquals(55, gause_recursion(10));
    }


    /**
     * Given n. from 1~n calculate if even number plus, if odd number multiply
     * and return in an array.
     *
     * First index return sum of even number. Second index return total multiply of odd number.
     *
     * Rule: 1) result +=n OR result*=n.
     *       2) n-1
     *
     * @param n
     * @param result
     * @return
     */
    public int gauss_2(int n, int[] result) {
        if (n == 1) return 1;
        if (n < 0) return 0;

        if (n % 2 == 0) result[0] += n;
        else result[1] *= n;

        return gauss_2(n-1, result);
    }

    @Test
    public void gause2_recursion_test() {
        int[] result = new int[]{0,1};
        gauss_2(5, result);
        log.debug("hey");
    }


    //---------------------------------------------------
    // Factorial
    // Rule: 1) n * func(n-1)
    //---------------------------------------------------

    public int factorial_recursion(int n) {

        if (n == 1) return 1;
        return n * factorial_recursion(n-1);
    }

    @Test
    public void factorial_recursion_test() {
        Assert.assertEquals(120, factorial_recursion(5));
    }








}
