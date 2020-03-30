package exam.leetcode.easy;

import com.jeonhwan.exam.leetcode.easy.ReverseInteger;
import com.jeonhwan.exam.leetcode.easy.TwoSum;
import org.junit.Test;

import java.util.LinkedList;

public class ReversedIntegerTest {

    @Test
    public void bigONWithSimpleMath() {

        ReverseInteger solution = new ReverseInteger();
        int x = 123;
        //int x = -123;
        //int x = 120;
        //int x = 1463847413; // it must return 0 as over flow

        int reversed = solution.bigONWithSimpleMath(x);
        System.out.println("original: " + x  + ", reversed: " + reversed );
    }


    @Test
    public void bigONwithStringBuilder() {

        ReverseInteger solution = new ReverseInteger();
        //int x = 123;
        int x = -123;
        //int x = 120;
        //int x = 1463847413; // it must return 0 as over flow

        int reversed = solution.bigONwithStringBuilder(x);
        int reversed2 = solution.bigONwithoutStringBuilder(x);
        System.out.println("hey");
    }




}
