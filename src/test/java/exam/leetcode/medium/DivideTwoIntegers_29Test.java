package exam.leetcode.medium;

import com.jeonhwan.algorithm.sort.MergeSort;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
 *
 * Return the quotient after dividing dividend by divisor.
 *
 * The integer division should truncate toward zero, which means losing its fractional part. For example, truncate(8.345) = 8 and truncate(-2.7335) = -2.
 *
 * Example 1:
 *
 * Input: dividend = 10, divisor = 3
 * Output: 3
 * Explanation: 10/3 = truncate(3.33333..) = 3.
 * Example 2:
 *
 * Input: dividend = 7, divisor = -3
 * Output: -2
 * Explanation: 7/-3 = truncate(-2.33333..) = -2.
 * Note:
 *
 * Both dividend and divisor will be 32-bit signed integers.
 * The divisor will never be 0.
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 231 − 1 when the division result overflows.
 * Accepted
 */
public class DivideTwoIntegers_29Test {
    private static Logger log = LoggerFactory.getLogger(MergeSort.class);



    @Test
    public void solution_test1() {
        int dividend = 10,  divisor = 3;

        int result = first_approach(10, 3);

        log.debug("result, {}", result);

    }


    /**
     * lets do subtract as much it can
     * @param dividend
     * @param divisor
     * @return
     */
    public int first_approach(int dividend, int divisor) {
        int count = 0;
        while (dividend >= divisor) {
            dividend = dividend - divisor;
            count++;
        }
        return count;
    }

    /**
     *   1) multiply => shift(left)
     *      100 << 1 = 100 * 2^1 = 100 * 2
     *      100 << 2 = 100 * 2^2 = 100 * 4
     *      100 << 3 = 100 * 2^3 = 100 * 8
     *      100 << 4 = 100 * 2^4 = 100 * 16
     */
    @Test
    public void bit_operator_multiply() {
        Assert.assertEquals(200, 100 << 1);
        Assert.assertEquals(400, 100 << 2);
        Assert.assertEquals(800, 100 << 3);
        Assert.assertEquals(1600, 100 << 4);
    }

    /**
     *   2) divide  => shift(right)
     *      100 >> 4 = 100 * 1/2^4 = 100 * 1/16 = 6
     *      100 >> 4 = 100 * 1/2^3 = 100 * 1/8 = 12  ==> Integer value calculation
     *      100 >> 4 = 100 * 1/2^2 = 100 * 1/4 = 25
     *      100 >> 4 = 100 * 1/2^1 = 100 * 1/2 = 50
     */
    @Test
    public void bit_operator_divide() {
        Assert.assertEquals(50, 100 >> 1);
        Assert.assertEquals(25, 100 >> 2);
        Assert.assertEquals(12, 100 >> 3);
        Assert.assertEquals(6, 100 >> 4);
    }
}
