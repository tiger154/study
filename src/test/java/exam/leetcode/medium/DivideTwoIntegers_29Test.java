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
        int result = first_approach(dividend, divisor);
        log.debug("result, {}", result);
        Assert.assertEquals(3, result);
    }

    @Test
    public void solution_test2() {
        int dividend = 7,  divisor = -3;
        int result = first_approach(dividend, divisor);
        log.debug("result, {}", result);
        Assert.assertEquals(-2, result);
    }

    @Test
    public void solution_test3() {
        int dividend = -2147483648,  divisor = 1;
        int result = first_approach(dividend, divisor);
        log.debug("result, {}", result);
        Assert.assertEquals(-2147483648, result);
    }

    @Test
    public void solution_test4() {
        int dividend = 10,  divisor = 2;
        int result = second_approach_by_YuleiLi(dividend, divisor);
        log.debug("result, {}", result);
        Assert.assertEquals(5, result);
    }

    /**
     * lets do subtract as much it can
     * @param dividend
     * @param divisor
     * @return
     */
    public int first_approach(int dividend, int divisor) {
        int count = 0;
        int big_dividend = 0;
        int big_dividend_mod = 0;

        // what would be the case of over flow?
        if (divisor == -1 && dividend == Integer.MIN_VALUE) return Integer.MAX_VALUE;

        if (dividend == Integer.MIN_VALUE) {
            big_dividend = dividend / 10;
            big_dividend_mod = dividend % 10;
        }

        int temp_dividend = Math.abs(dividend);
        int temp_divisor = Math.abs(divisor);

        while (temp_dividend >= temp_divisor) {
            temp_dividend = temp_dividend - temp_divisor;
            count++;
            // overflow check
            if (count >= Integer.MAX_VALUE-1) return Integer.MAX_VALUE;
        }

        return (dividend >= 0 && divisor >= 0) || (dividend <= 0 && divisor <= 0) ? count : -count;
    }


    /**
     *
     * @param dividend
     * @param divisor
     * @return
     */
    public int second_approach_by_YuleiLi(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        boolean neg = dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0;
        if(dividend > 0)
            dividend = -dividend;
        if(divisor > 0)
            divisor = -divisor;
        int res = 0;
        while(divisor >= dividend){
            int count = 1;
            int newDivisor = divisor;
            while(newDivisor >= dividend - newDivisor){
                newDivisor <<= 1;
                count <<= 1;
            }
            dividend -= newDivisor;
            res += count;
        }
        if(neg)
            res = ~res + 1;
        return res;
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


    @Test
    public void bit_divide() {
        int r1 = 9 >> 1;
        int r2 = r1 >> 1;

        log.debug("hahaha");
    }
}
