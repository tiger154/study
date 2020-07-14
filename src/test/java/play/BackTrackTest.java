package play;

import com.jeonhwan.algorithm.sort.MergeSort;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class BackTrackTest {
    private static Logger log = LoggerFactory.getLogger(MergeSort.class);


    /**
     * Make data structure let say there is a grid 4*4
     * And find exit or Queen spot
     *  1) How to make a grid? I think a table would be perfect fit
     *     so... an list of hashmap? or... linked list
     *
     *
     *
     *  1. Make maze problem first
     *    - Make maze with table
     *
     *
     *   This is a sample maze (map)
     *      0 1 1 1 1 0
     *      1 1 0 0 0 0
     *      0 1 0 0 1 2 --> exit
     *      0 1 1 0 1 0
     *      0 1 0 0 1 0
     *      0 1 1 1 1 0
     *
     *   Direction is only up/down/left/right not diagonal (later version may i add this as well)
     *
     *   we give this
     *
     *   0 : wall
     *   1 : path >> we can give any path as a start point
     *   2 : exit
     *
     *   2. Make puzzle problem second
     *
     */

    @Test
    public void test_backtrack() {

        // 1. maz map for test
        int maze[][] = {
                 {0,1,1,1,1,0}
                ,{1,1,0,1,0,0}
                ,{0,1,0,0,1,2}
                ,{0,1,1,0,1,0}
                ,{0,1,0,0,1,0}
                ,{1,1,1,1,1,0}
        };

        // create visited array
        int visited[][] = new int[maze[0].length][maze.length];
        int result[][] = new int[maze[0].length][maze.length];


        List<HashMap<String, Object>> paths = new ArrayList<>();


        // x is row, y is column
       int[][] rows = solveMaze(maze, 1, 0, visited, result, paths);


       for (int[] row : rows) {
           log.debug("row: {}", row);
       }

        for (HashMap<String, Object> table : paths) {
            log.debug("index: {}", table.get("has_exit"));
            for (int[] path : (int[][])table.get("path")) {
                log.debug("path-row: {}", path);
            }
        }



       log.debug("hey");
    }


    public int[][] solveMaze(int[][] maze, int row, int col, int[][] visited, int[][] result, List<HashMap<String, Object>> paths) {


        // we need to have visited area. as map
        // so


        // pseudo code
        // 1. start from the start point

        // 2. Set exit condition
        //    - 2.1 over flow of direction top/bottom/left/right



        //    - 2.2 When hit the exit   --> value == 2
        //    - 2.3 when it's not path  --> value == 1

        // if there is no where to go...
//        if() {
//
//        }


        if (isSafe(maze, row, col, visited, result, paths)) {
            visited[row][col] = 1;
            result[row][col] = 1;

            Map<String, Boolean> direction_map = new HashMap<>();
            direction_map.put("top",false);
            direction_map.put("right",false);
            direction_map.put("down",false);
            direction_map.put("left",false);


            log.debug("visited x: {}, y: {} point", row, col);

            // 3. loop 4 direction or just write down by order
            // Move to Top
            if(isSafe(maze, row-1, col, visited, result, paths)) {
                //result[row-1][col] = 1;
                direction_map.put("top",true);
                solveMaze(maze, row-1, col, visited, result, paths);
                //result[row-1][col] = 0;
            }
            // Move to Right
            if(isSafe(maze, row, col+1, visited, result, paths)) {
                //result[row][col+1] = 1;
                direction_map.put("right",true);
                solveMaze(maze, row, col+1, visited, result, paths);
                //result[row][col+1] = 0;
            }

            // Move to Down
            if(isSafe(maze, row+1, col, visited, result, paths)) {
                //result[row+1][col] = 1;
                direction_map.put("down",true);
                solveMaze(maze, row+1, col, visited, result, paths);
                //result[row+1][col] = 0;
            }

            // Move to Left   path and list of the path...
            if (isSafe(maze, row, col-1, visited, result, paths)) {
                //result[row][col-1] = 1;
                direction_map.put("left",true);
                solveMaze(maze, row, col-1, visited, result, paths);
                //result[row][col-1] = 0;
            }

            long direction_count = direction_map.entrySet().stream().filter(x -> x.getValue() == false).count();
//
            if(direction_count > 1) {
//                HashMap<String, Object> temp = new HashMap<>();
//                temp.put("id",);
//                paths.add()

                if(direction_count == 4) {


                    log.debug("false direction is over 1 : {}", direction_count);
                    // int[][] temp_result = Arrays.copyOf(result, maze.length);

                    int[][] temp_result = Arrays.stream(result).map(int[]::clone).toArray(int[][]::new);

                    HashMap<String, Object> temp = new HashMap<>();
                    temp.put("has_exit",false);
                    temp.put("path",temp_result);

                    //result = new int[maze[0].length][maze.length];
                    paths.add(temp);
                }

            }


        }

        return result;
    }

    // If there is record visited then return
    public boolean isVisitedDirection(int row, int col, int[][] visited) {
        if (visited[row][col] == 1) {
            return true;
        } else {
            return false;
        }
    }



    public boolean isSafe(int[][] maze, int row, int col, int[][] visited, int[][] result, List<HashMap<String, Object>> paths) {
        // 2. Set exit condition
        //    - 2.1 over flow of direction top/bottom/left/right
        if (col >= maze[0].length || col < 0 || row < 0 || row >= maze.length) {
            return false;
        }
        //    - 2.2 when it's not path  --> value == 1
        if(maze[row][col] == 0) {
            return false;
        }

        //    - 2.3 is visited
        if(isVisitedDirection(row, col, visited)) {
            return false;
        }

        //    - 2.4 Found Exit!!! so exit
        if(maze[row][col] == 2) {
            result[row][col] = 2;
            return false;
        }
        return true;
    }













}
