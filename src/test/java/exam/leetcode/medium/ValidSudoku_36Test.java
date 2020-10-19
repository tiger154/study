package exam.leetcode.medium;


import com.jeonhwan.exam.leetcode.medium.ValidSudoku_36;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class ValidSudoku_36Test {
    private static Logger log = LoggerFactory.getLogger(ValidSudoku_36Test.class);


    @Test
    public void solution_test1() {

        ValidSudoku_36 solution = new ValidSudoku_36();

        char[][] board1 = {
                  {'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        Assert.assertTrue(solution.first_approach(board1));



        char[][] board2 = {
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        Assert.assertFalse(solution.first_approach(board2));

        log.debug("first solution test is done!");

    }



    @Test
    public void solution_test2() {
        ValidSudoku_36 solution = new ValidSudoku_36();
        char[][] board1 = {
          {'.','.','4','.','.','.','6','3','.'}
         ,{'.','.','.','.','.','.','.','.','.'}
         ,{'5','.','.','.','.','.','.','9','.'}
         ,{'.','.','.','5','6','.','.','.','.'}
         ,{'4','.','3','.','.','.','.','.','1'}
         ,{'.','.','.','7','.','.','.','.','.'}
         ,{'.','.','.','5','.','.','.','.','.'}
         ,{'.','.','.','.','.','.','.','.','.'}
         ,{'.','.','.','.','.','.','.','.','.'}
        };

        Assert.assertFalse(solution.first_approach(board1));

    }





    /**
     * It draws sudoku block based search
     *
     */
    @Test
    public void print_sudoku_start_points() {

        int block_size = 3;
        int block_size_limit = block_size * block_size;

        // 1. draw each sudoku box start point (9times)
        for (int i = 0; i < block_size_limit; i= i+block_size) {
            for (int j = 0; j < block_size_limit; j= j+block_size) {

                log.debug("box start point! i,j: {},{}", i,j);

                // draw each sudoku box's detail(9 times)
                for (int x = i; x < (i+block_size); x++) {
                    for (int y = j; y < (j+block_size); y++) {
                        log.debug("sudoku box x,y: {}, {}", x, y);

                        // Here we can add check logic with Map
                        // 1) Sudoku block check
                        // 2) Row check
                        // 3) Col check
                        // When ever return false from those condition, it directly return false!
                    }
                }
            }
        }
    }

    @Test
    public void simple_loop_test1() {
        ValidSudoku_36 solution = new ValidSudoku_36();
        int x = 0;
        int block_start_pointer = 3;
        int block_size = 3;

        solution.block_check(null, null,null, null, 3, 6, 3);


    }

    /**
     * to print out block size
     */
    @Test
    public void simple_loop_test() {
        int x = 0;
        int y = 0;
        int block_size = 3;


        for (int i = x; i < (x + block_size); i++) {
            for (int j = y; j < (y + block_size) ; j++) {
                log.debug("i,j: {},{}", i, j);
            }
        }
    }


    public boolean block_check(int x,  int y, int block_size ) {
        // run block_size * block_size
        for (int i = x; i < (x + block_size); i++) {
            for (int j = y; j < (y + block_size); j++) {
                log.debug("i,j: {},{}", i, j);
            }
        }
        return true;
    }


    @Test
    public void draw_all_block_test() {

        int block_size = 3;
        // draw all..
        for (int i = 0; i < block_size; i++ ) {
            int x = i * block_size;
            for (int j = 0; j < block_size; j++) {
                int y = j * block_size;
                 block_check( x, y, block_size);
            }
        }
    }







}
