package play;

import exam.leetcode.easy.ValidAnagram_242Test;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BitTest {

    private static Logger log = LoggerFactory.getLogger(BitTest.class);
    /**
     * def diff(n, d):
     *     return n & ~(1 << d)
     *
     * 2 notation
     *
     *  It's only works if there is an intersection
     */
    @Test
    public void minusWithBit2() {

        // make
        int n = 32; //
        int nth = 3;

       int result = n & ~(1 << nth);

       System.out.println(Integer.toBinaryString(result));
    }

    /**
     * 10 notation
     */
    @Test
    public void minusWithBit10() {
        // make
        int n = 32; //
        int nth = 3;
        int result = n - (1 << nth);
        System.out.println("10진수:" + result + ", 2진수: " + Integer.toBinaryString(result));
    }


    /**
     * OR | => Union operator 합집합
     */
    @Test
    public void groupOr() {
        // make
        int a = 15; //
        int b = 2;
        int ab =  a|b;
        System.out.println("10진수:" + ab + ", 2진수: " + Integer.toBinaryString(ab));
    }

    /**
     * Intersection & => operator 교집합
     */
    @Test
    public void groupAnd() {
        // make
        int a = 15; //
        int b = 2;
        int ab =  a & b;
        System.out.println("10진수:" + ab + ", 2진수: " + Integer.toBinaryString(ab));
    }

    /**
     * XOR ^ => minus 차집합
     */
    @Test
    public void groupXor() {
        // make
        int a = 15; //
        int b = 2;
        int ab =  a ^ b;
        System.out.println("10진수:" + ab + ", 2진수: " + Integer.toBinaryString(ab));
    }


    /**
     *
     * 1) 3 = 1 + 2
     * 2) 3 ^ 1 = 2
     * 3) 3 ^ 2 = 1
     * 4) 2 & 1 = 0
     *
     * 4 = 2 + 2
     * 0100 = 0010 + 0010
     * 0100 ^ 0010 = 0110
     * 0100 ^ 0010 = 0110
     * 0110 & 0110 = 0110
     *
     * 5 = 3 + 2
     * 0101 = 0011 + 0010
     * 0101 ^ 0011 = 0110
     * 0101 ^ 0010 = 0111
     * 0110 & 0111 = 0110
     *
     *
     *  (difference) (intersection) (difference) > 0
     *
     * @param x
     * @param y
     * @return
     */
    public static int addExact(int x, int y) {
        int r = x + y;

        if (((x ^ r) & (y ^ r)) < 0) {
            throw new ArithmeticException("int overflow");
        }
        return r;
    }

    @Test
    public void testAdd() {
        int result = addExact(3,2);
        System.out.println("10진수:" + result + ", 2진수: " + Integer.toBinaryString(result));
    }

    @Test
    public void pow_positive_base21_exponent3_test() {
        int base = 3;           // base of the logarithm
        int exponent = 3;     // exponent times
        // shift calculate 10 times test
        for (int i = 0; i < exponent-1; i++) {
            base = base << 1;  // it means 2 times of base...
        }
        log.debug("result!");
    }

    @Test
    public void pow_positive_base2_exponent2_test() {
        int base = 2;           // base of the logarithm
        int exponent = 10;     // exponent times
        // shift calculate 10 times test
        for (int i = 0; i < exponent-1; i++) {
            base = base << 1;
        }
        log.debug("result!");
    }

    @Test
    public void pow_negative_base2_exponent2_test() {
        int base = 2;           // base of the logarithm
        int exponent = 2;     // exponent times
        // /1/2^2
        // shift calculate 10 times test
        for (int i = 0; i < exponent-1; i++) {
            base = base << 1;
        }
        // so this i can use for...
        double rtn =  1.0 / base;
        log.debug("result!: {}", rtn);
    }



    public double pow(double x, int n) {

        // so double is not allowed to have shift okay

        // if its int then easy just do it

        // if its not then... seperate



        return 0;
    }

}
