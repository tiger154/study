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
        int dividend = -2147483648,  divisor = 2;
        int result = first_approach(dividend, divisor);
        log.debug("result, {}", result);
        Assert.assertEquals(-1073741824, result);
    }

    @Test
    public void solution_test5() {
        int dividend = 10,  divisor = 1;
        int result = third_approach_by_YuleiLi(dividend, divisor);
        log.debug("result, {}", result);
        Assert.assertEquals(10, result);
    }

    @Test
    public void solution_test6() {
        int dividend = Integer.MIN_VALUE,  divisor = -3;
        int result = fourth_approach_by_YuleiLi(dividend, divisor);
        log.debug("result, {}", result);
        Assert.assertEquals(715827882, result);
    }

    @Test
    public void solution_test7() {
        int dividend = -1010369383,  divisor = -2147483648;
        int result = fourth_approach_by_YuleiLi(dividend, divisor);
        log.debug("result, {}", result);
        Assert.assertEquals(715827882, result);
    }


    /**
     * Lets do subtract as much it can.
     *
     * Its working but worst case would be really slow such as
     *  ex) Integer.MIN_VALUE / 2 then, need to compute 1,073,741,824 times.
     *
     * Using minus operator is really slow compare to bit operator.
     *  > Runtime: 2795 ms, faster than 5.01% of Java online submissions for Divide Two Integers.
     *  * If we use bit operator it can be 1ms which means almost 3000 times faster.
     *
     *
     *
     * @param dividend
     * @param divisor
     * @return
     */
    public int first_approach(int dividend, int divisor) {
        int count = 0;
        // what would be the case of over flow?
        if (divisor == -1 && dividend == Integer.MIN_VALUE) return Integer.MAX_VALUE;


        int temp_dividend = (dividend > 0) ? -dividend : dividend;
        int temp_divisor = (divisor > 0) ? -divisor: divisor;

        while (temp_dividend <= temp_divisor) {
            temp_dividend = temp_dividend - temp_divisor;
            count++;
//            // overflow check
//            if (count >= Integer.MAX_VALUE-1) return Integer.MAX_VALUE;
        }

        return (dividend >= 0 && divisor >= 0) || (dividend <= 0 && divisor <= 0) ? count : -count;
    }


    /**
     * Similar approach but using bit operator.
     *
     *
     *
     * @param dividend
     * @param divisor
     * @return
     */
    public int second_approach(int dividend, int divisor) {

        return 0;
    }


    /**
     *
     * using bit operator make huge difference as O(logN)
     *   ref: https://youtu.be/V20qmx_l2-4
     *
     * Study point here
     *   1) 1's Complement
     *   2) 2's Complement
     *   3) bit shift operator (left, right)
     *     - left : multiply by two
     *     - right : divide by two
     *
     *  Also interesting part this solution is it convert all positive value to negative.
     *  It's quit clever I think it's cover edge case when we try to convert Integer.MIN_VALUE to positive
     *  as it's overflow case.
     *
     *
     *  Signed Integer data range is -2^31 ~ +2^31-1
     *  And if you carefully check, negative data has one more value.
     *
     *  So if you try to convert to -2^31 to positive it's clearly overflow.
     *
     *
     *
     *
     * Made blog post about it: https://blog.naver.com/junhwen/222108250400
     *
     * @param dividend
     * @param divisor
     * @return
     */
    public int third_approach_by_YuleiLi(int dividend, int divisor) {
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
            // So what is the purpose for this?
            // It can happen..till max 31 times?
            while(newDivisor >= dividend - newDivisor){
                newDivisor <<= 1; // This is interesting part. its same with subtract(dividend - divisor)
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
     * Base is same with third approach.
     *  1. Convert to all positive value
     *     - Math.abs
     *
     *  2. But tried bit difference to handle edge case
     *
     *   1) Basic edge case
     *     - First Convert to all negative if positive
     *    (1) If dividend equal divisor return 1 or -1 by negative detect
     *    (2) If divisor is bigger then dividend return 0 directly
     *
     *   2) When dividend is MIN_VALUE
     *    (1) make it +1 and convert to positive
     *    (2) At the end if final mod is same with divisor then add +1 on result(quotient)
     *
     *  It's ugly then third approach, but meaningful to see deeply myself
     *  I can see clean code and dirty code
     *  I can see negative calculation would have strong power to make clean code
     *
     *
     *
     *
     * @param dividend
     * @param divisor
     * @return
     */
    public int fourth_approach_by_YuleiLi(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        boolean neg = dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0;

        // if divisor is bigger then dividend just return 0
        // need to check edge cases, lets make all to negative as negative can have one bigger value

        int n_dividend = (dividend > 0) ? -dividend: dividend;
        int n_divisor  = (divisor > 0)  ? -divisor: divisor;

        if (n_dividend == n_divisor) return (neg) ? -1 : 1;
        if (n_dividend > n_divisor) return 0;


        boolean min_v = false;
        // let's think about the edge case make + 1
        if  (Integer.MIN_VALUE == dividend) {
            min_v = true;
            dividend = dividend + 1;
        }

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);


        int res = 0;
        int newDivisor = 0;
        int tempDividend = dividend;

        while(dividend >= divisor){
            int count = 1;
            newDivisor = divisor;
            // So what is the purpose for this?
            // It can happen..till max 31 times?
            while(newDivisor <= dividend - newDivisor){
                newDivisor <<= 1; // This is interesting part. its better performance then (dividend - divisor)
                count <<= 1;
            }
            dividend -= newDivisor;
            res += count;
        }

        // if it's edge case and mod is equal or smaller then the divisor + 1
        int mod = dividend + 1;
        res = (min_v == true && mod > 0 && mod == divisor) ? res + 1 : res;


        // use 2's Complement
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
