package exam.leetcode.medium;


import com.jeonhwan.algorithm.sort.MergeSort;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class ValidSudokuTest {
    private static Logger log = LoggerFactory.getLogger(ValidSudokuTest.class);


    @Test
    public void solution_test1() {

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

        Assert.assertTrue(first_approach(board1));


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

        Assert.assertFalse(first_approach(board2));

        log.debug("first solution test is done!");

    }



    @Test
    public void solution_test2() {
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

        Assert.assertFalse(first_approach(board1));

    }


    /**
     * brute force
     *
     *  1) small block checker with map: block_map
     *    - If given value x(row index), we can check one block(3*3)
     *      isValidNumForBlock(x,x)
     *      isValidNumForBlock(x,x+1)
     *      isValidNumForBlock(x,x+2)
     *      isValidNumForBlock(x+1,x)
     *      isValidNumForBlock(x+1,x+1)
     *      isValidNumForBlock(x+1,x+2)
     *      isValidNumForBlock(x+2,x)
     *      isValidNumForBlock(x+2,x+1)
     *      isValidNumForBlock(x+2,x+2)
     *
     *  2) row check with map : row_map
     *     - when look for sdoku block, it look for top - right - down and repeat. each block has 3 partial row.
     *     - So we need 3 map for tracking List<Map> and when keep compare till it hit right most block int the map.
     *     - and refresh(clean) the map for next check
     *
     *
     *  3) Column check with map
     *     - as it go through from top - right - down order, we need to track each column's duplication
     *     - So Need 9 map for tracking List<Map> and each column's index gonna be key (0~8)
     *     - When block checker hit key's index(Y point which means right point number), check with map. then we can see if there is duplication
     *
     *
     *  4) sudo code
     *
     *    Loop 3 times(row) --> a sdoku block is 3*3, so when 1 row hit, we gonna check 1*3 row
     *
     *      1) Row check > Loop 9 times(all columns of this row)
     *        - we can check
     *      2) Block check > Loop 3 times
     *         2.1) Each Block check > loop 9 times
     *
     *
     *
     *
     *  Time Complexity is O(N)!
     *   - It look for sudoku block from top - left - right - down.
     *   - When it hit a column it check 1) row 2) column 3) sudoku block unique with Map so checking time is only O(1)
     *   - It loops only board size which is for now 81. So we can also say O(81)
     *
     *    > Runtime: 2 ms, faster than 85.53% of Java online submissions for Valid Sudoku.
     *
     *  Need to check others solution, and compare and if possible implement as well with new approach :)
     *
     * @param board
     * @return
     */
    public boolean first_approach(char[][] board) {

        int block_size = 3;
        int col_size = block_size * block_size;

        List<HashMap<Character,Character>> col_map_list =  generate_map_list(col_size); // size must be block_size * block_size : 9


        // draw all block
        // Here we just point each sdoku block start point(left,top)
        // 00,03,06
        // 30,33,36
        // 60,63,66
        // When it hits each start point, we look sdoku block based on the start point information
        for (int i = 0; i < block_size; i++ ) {

            // 1. row check, lets skip for now

            // 2. block check.
            int x = i * block_size;
            // row map list with generate
            List<HashMap<Character,Character>> row_map_list = generate_map_list(block_size);

            for (int j = 0; j < block_size; j++) {
                int y = j * block_size;
                Map<Character, Character> block_map = new HashMap<>(); // It should be clean before check each block
                if (!block_check(board, block_map, row_map_list, col_map_list , x, y, block_size)) {
                    return false;
                }
            }
        }

       return true;
    }

    /**
     * Generate fixed size list and init data
     * @param size
     * @return
     */
    public List<HashMap<Character, Character>> generate_map_list(int size) {
        List<HashMap<Character,Character>> map_list =  new ArrayList<HashMap<Character, Character>>(size){{
            for (int i = 0; i < size; i++) {
                add(new HashMap<>());
            }
        }};
        return map_list;
    }


    /**
     * Map unique checker
     * @param val
     * @param block_map
     * @return
     */
    public boolean isValidMap(char val, Map<Character, Character> block_map) {
        Character rtn = block_map.put(val, val);
        return (rtn == null || val != rtn);
    }

    /**
     * Sudoku block checker
     *
     * @param board
     * @param block_map
     * @param row_map_list
     * @param col_map_list
     * @param x
     * @param y
     * @param block_size
     * @return
     */
    public boolean block_check(char[][] board, Map<Character, Character> block_map, List<HashMap<Character, Character>> row_map_list, List<HashMap<Character, Character>> col_map_list ,int x,  int y, int block_size ) {

        // drawing(look for) sdoku block block_size * block_size
        for (int i = x; i < (x + block_size); i++) {
            for (int j = y; j < (y + block_size) ; j++) {
                log.debug("i,j: {},{}", i, j);
                if (board[i][j] == '.') continue;

                // 1) check if row valid
                int row_index = i % block_size;  // simple math trick can make save spaces! It just keep 'block_size' max :)
                if (!isValidMap(board[i][j], row_map_list.get(row_index))) return false;   // first - row check

                // 2) check if column valid
                if (!isValidMap(board[i][j], col_map_list.get(j))) return false;   // second - column check

                // 3) check block valid
                if (!isValidMap(board[i][j], block_map)) return false;     // third - sudoku block check
            }
        }
        return true;
    }





    @Test
    public void simple_loop_test1() {

        int x = 0;
        int block_start_pointer = 3;
        int block_size = 3;

        block_check(null, null,null, null, 3, 6, 3);


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
