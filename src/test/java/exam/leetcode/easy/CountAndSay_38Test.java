package exam.leetcode.easy;


import com.jeonhwan.exam.leetcode.easy.CountAndSay_38;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CountAndSay_38Test {

    private static Logger log = LoggerFactory.getLogger(CountAndSay_38Test.class);


    @Test
    public void solution_test1() {

        CountAndSay_38 solution =  new CountAndSay_38();

        log.debug("hi there");

        Assert.assertEquals("1", solution.first_approach(1));
        Assert.assertEquals("11", solution.first_approach(2));
        Assert.assertEquals("21", solution.first_approach(3));
        Assert.assertEquals("1211", solution.first_approach(4));
        Assert.assertEquals("111221", solution.first_approach(5));
        Assert.assertEquals("312211", solution.first_approach(6));
        Assert.assertEquals("13112221", solution.first_approach(7));
        Assert.assertEquals("1113213211", solution.first_approach(8));
        Assert.assertEquals("31131211131221", solution.first_approach(9));
        Assert.assertEquals("13211311123113112211", solution.first_approach(10));

    }


    @Test
    public void solution_all_test1() {
        CountAndSay_38 solution =  new CountAndSay_38();
        // generate all cases
        for (int i = 1; i <= 30; i++) {
            solution.first_approach(i);
        }
    }


    @Test
    public void solution_test2() {
        CountAndSay_38 solution =  new CountAndSay_38();
        log.debug("hi there");

        Assert.assertEquals("1", solution.second_approach(1));
        Assert.assertEquals("11", solution.second_approach(2));
        Assert.assertEquals("21", solution.second_approach(3));
        Assert.assertEquals("1211", solution.second_approach(4));
        Assert.assertEquals("111221", solution.second_approach(5));
        Assert.assertEquals("312211", solution.second_approach(6));
        Assert.assertEquals("13112221", solution.second_approach(7));
        Assert.assertEquals("1113213211", solution.second_approach(8));
        Assert.assertEquals("31131211131221", solution.second_approach(9));
        Assert.assertEquals("13211311123113112211", solution.second_approach(10));




    }





}
