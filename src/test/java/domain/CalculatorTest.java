package domain;

import com.jeonhwan.domain.Calculator;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void sum_one_one_two() {
        // given
       Calculator calculator = new Calculator();
       // act
       int result = calculator.sum(1,1);
       // assert
       assertEquals(2, result);
    }

    @Test
    public void minus_one_one_zero() {
        // given
        Calculator calculator = new Calculator();
        // act
        int result = calculator.minus(1,1);
        // assert
        assertEquals(0, result);
    }
}
