package exam.leetcode.easy;

import com.jeonhwan.exam.leetcode.easy.RomanToInteger_13;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RomanToInteger_13Test {


    /**
     * 10, 100, 1000
     *
     *
     *
     * first check how big it is
     *
     * 2531 / 10 -> 253, 1 --> This is under 10  if over 5
     * 253 / 10 -> 25, 3   --> This is under 100 if over 5
     * 25 / 10 -> 2, 5     --> this is under 1000 if over 5
     *
     *
     *  So you can split it position by position
     *
     *
     *  https://www.youtube.com/watch?v=JyLrPSJNfYw
     *
     *
     *
     */
    public void IntegerToRoman(int num) {

        int[] map = new int[90];
        map['I'] = 1;
        map['V'] = 5;
        map['X'] = 10;
        map['L'] = 50;
        map['C'] = 100;
        map['D'] = 500;
        map['M'] = 1000;

        int head = num;
        int tail = 0;

        String result = "";

        // 2531

        int i = 1;
        while (head > 0) {

            tail = head%10;   // 1
            head = head / 10; // 253
            int current_num =  tail * i;


            //



            StringBuilder sb = new StringBuilder();
            sb.append("head : ").append(head)
                    .append(", tail: ").append(tail)
                    .append(", current_num: ").append(current_num);

            System.out.println(sb.toString());
            i = i * 10;
        }
    }


    @Test
    public void testman() {
        IntegerToRoman(2531);
    }



    @Test
    public void bigON() {


        List<String[]> list = new ArrayList<>();
        list.add(new String[]{"III","3"});
        list.add(new String[]{"IV","4"});
        list.add(new String[]{"IX","9"});
        list.add(new String[]{"LVIII","58"});
        list.add(new String[]{"MCMXCIV","1994"});

        RomanToInteger_13 solution = new RomanToInteger_13();

        for (String[] arr: list) {
           //int numbers = first_approach(arr[0]);
            //int numbers = second_approach(arr[0]);
            int numbers = solution.best_approach(arr[0]);
            StringBuilder sb = new StringBuilder();
            sb.append("string : ").append(arr[0])
                    .append(", numbers: ").append(numbers);

            System.out.println(sb.toString());
        }

    }



}
