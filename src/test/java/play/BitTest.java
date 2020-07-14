package play;

import org.junit.Test;

public class BitTest {


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
}
