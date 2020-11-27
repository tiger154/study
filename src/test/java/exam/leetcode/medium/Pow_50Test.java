package exam.leetcode.medium;

import org.junit.Assert;
import org.junit.Test;

public class Pow_50Test {



    @Test
    public void brute_force_test() {

        Assert.assertEquals(1024.00000, brute_force(2.00000, 10), 0.00001);
        Assert.assertEquals(9.26100, brute_force(2.10000, 3), 0.00001);
        Assert.assertEquals(0.25000, brute_force(2.00000, -2), 0.00001);

        Assert.assertEquals(1.00000, brute_force(0.44528, 0), 0.00001);
//        Assert.assertEquals(1024.00000, brute_force(2.00000, 10), 0.001);

    }


    /**
     * Its working but time limit exceed as expected!
     * @param x
     * @param n
     * @return
     */
    public double brute_force(double x, int n) {
        double base = x;
        int limit = (n < 0 ) ? n * -1 : n; // this is making n as positive but what im missing here...
        // edge cases
        if (n == 0) return 1;
        if (n == 1) return x;
        if (x == 1) return 1;

        for (int i = 0; i < limit-1; i++) {
            base = base * x ;
        }
        if (n < 0) return 1.0 / base;
        else return base;
    }


    @Test
    public void brute_force_test_most_voted() {

        Assert.assertEquals(1024.00000, myPow__(2.00000, 11), 0.00001);

        Assert.assertEquals(1024.00000, myPow_itr(2.00000, 10), 0.00001);



        Assert.assertEquals(9.26100, myPow_itr(2.10000, 3), 0.00001);
        Assert.assertEquals(0.25000, myPow_itr(2.00000, -2), 0.00001);

        Assert.assertEquals(1.00000, myPow_itr(0.44528, 0), 0.00001);
//        Assert.assertEquals(1024.00000, brute_force(2.00000, 10), 0.001);
    }


    /**
     * This I need to study basic math
     *   - Study from here https://www.youtube.com/watch?v=snOaKR2xgZg&ab_channel=KnowledgeCenter
     *
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (n == 0) return 1;

        if (n%2 == 0) {
            return myPow(x * x, n/2);
        } else {
            return x *  myPow(x * x, n/2);
        }
    }

    /**
     * Now For this Im gonna practice while vs recursive to check it out where is my weakness
     *
     * I didnt practice this enough (Recursive vs Loop)
     *   - Can you implement Recursive and Loop both of them?
     *
     * Gonna deep dive here  like couple of days as I need
     * @param x
     * @param n
     * @return
     */
    public double myPow_itr(double x, int n) {
        if (n == 0) return 1;
        if (x == 1) return 1;
        if (x == -1) {
            if (n % 2 == 0) return 1;
            else return -1;
        }
        if (n == Integer.MIN_VALUE) return 0;
        if (n < 0) {
            n = -n;
            x = 1/x;
        }
        double ret = 1.0;
        while (n > 0) {
            if ((n & 1) != 0) // If it's odd number, put this to side. at the end all gonna come to 1!
                ret *= x;
            x = x * x;
            n = n >> 1;
        }
        return ret;
    }


    double myPow__(double x, int n) {
        // if (!n) return 1.0;
        if (n < 0) {
            n = -(++n);
            x = 1 / x;
        } else
            n--;
        double result = x;
        while (n > 0) {
            double y = x;
            for (int i = 1; i > 0 && i <= n; i *= 2) {
                result *= y;
                y *= y;
                n -= i;
            }
        }
        return result;
    }


    // now how many time should loop?
    // what would be difference of arguments

}
