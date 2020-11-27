package play;

import org.junit.Assert;
import org.junit.Test;

public class PrimitiveTypesTest {


    @Test
    public void simple_multiply_test() {

        Assert.assertEquals(156, simple_multiply(12, 13));

        Assert.assertEquals(16605, simple_multiply(123, 135));


    }

    /**
     * I just made this function after I read '6.3 MULTIPLY TWO ARBITRARY-PRECISION INTEGERS' from CLRS
     *
     * Quote
     * "For example, when multiplying 123 with 987, we would form 7 X 123 = 861, then
     * we would form 8 X 123 X 10 = 9840, which we would add to 861 to get 10701. Then
     * we would form 9 X 123 X 100 = 110700, which we would add to 10701 to get the final
     * result 121401"
     *
     * For the fun test I just implement above right away.
     * Book use array, but I just use a int for quick test.
     *
     * @param left
     * @param right
     * @return
     */
    public int simple_multiply(int left, int right) {

        int limit = String.valueOf(right).length();
        int result = 0;
        int index = 0;
        int m = 1;

        while (index < limit) {

            int tail = right % 10;                              // get tail
            right = right / 10;                                 // get top

            int temp = left * tail * m;
            result = result + temp;

            m = m * 10;
            index++;

        }

        return result;
    }

}
