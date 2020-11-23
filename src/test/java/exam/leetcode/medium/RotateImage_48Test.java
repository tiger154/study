package exam.leetcode.medium;

import com.jeonhwan.exam.leetcode.medium.RotateImage_48;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import static org.junit.Assert.*;


public class RotateImage_48Test {
    private static Logger log = LoggerFactory.getLogger(RotateImage_48Test.class);



    @Test
    public void rotate_matrix_test() {

        RotateImage_48 solution = new RotateImage_48();


        int [][] matrix = new int[][]{{1}};
        solution.first_approach(matrix);
        multi_array_assert(new int[][]{{1}} , matrix);
        log.debug("arr: {}", Arrays.deepToString(matrix));

        matrix = new int[][]{{1,2},{3,4}};
        solution.first_approach((matrix));
        multi_array_assert(new int[][]{{3,1},{4,2}} , matrix);
        log.debug("arr: {}", Arrays.deepToString(matrix));

        matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        solution.first_approach((matrix));
        multi_array_assert(new int[][]{{7,4,1},{8,5,2},{9,6,3}} , matrix);
        log.debug("arr: {}", Arrays.deepToString(matrix));

        matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        solution.first_approach((matrix));
        multi_array_assert(new int[][]{{13,9,5,1},{14,10,6,2},{15,11,7,3},{16,12,8,4}} , matrix);
        log.debug("arr: {}", Arrays.deepToString(matrix));

        matrix = new int[][]{{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        solution.first_approach((matrix));
        multi_array_assert(new int[][]{{21,16,11,6,1},{22,17,12,7,2},{23,18,13,8,3},{24,19,14,9,4},{25,20,15,10,5}} , matrix);
        log.debug("arr: {}", Arrays.deepToString(matrix));

        matrix = new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        solution.first_approach((matrix));
        multi_array_assert(new int[][]{{15,13,2,5},{14,3,4,1},{12,6,8,9},{16,7,10,11}} , matrix);
        log.debug("arr: {}", Arrays.deepToString(matrix));
    }


    public void multi_array_assert(int[][] expecteds, int[][] actuals) {
        for (int i =0; i < expecteds.length; i++) {
           assertArrayEquals(expecteds[i], actuals[i]);
        }
    }


    @Test
    public void swap_matrix_test() {
        RotateImage_48 solution = new RotateImage_48();
        int [][] matrix = new int[][]{{1,2},{3,4}};
        solution.swap(matrix, 0,0, 0, 1);
        log.debug("arr: {}", Arrays.deepToString(matrix));
    }




    @Test
    public void rotate_test_2() {
        RotateImage_48 solution = new RotateImage_48();
        int[][] matrix = new int[][]{{1,2},{3,4}};
        solution.second_approach(matrix);
    }

    public void rotate_(int[][] matrix) {
        int s = 0, e = matrix.length - 1;
        while(s < e){
            int[] temp = matrix[s];
            matrix[s] = matrix[e];
            matrix[e] = temp;
            s++; e--;
        }

        for(int i = 0; i < matrix.length; i++){
            for(int j = i+1; j < matrix[i].length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

}
