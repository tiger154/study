package exam.backjune;

import com.jeonhwan.exam.backjune.Order2750;
import helper.DataGenerator;
import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

public class Order2750Test {

   @Test
   public void random_number_test() {
      // random array
       for (int i=0; i < 10; i++) {
           int[] input_arr = DataGenerator.randomRangedInts(1, 5);
           int[] temp = Arrays.copyOf(input_arr, input_arr.length);
           int[] result_arr = Order2750.SelectionOrder(input_arr.length, input_arr);
           System.out.println("input_data:" + Arrays.toString(temp) + ", result_data: " + Arrays.toString(result_arr));
       }
   }
}
