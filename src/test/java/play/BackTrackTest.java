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
     *  1) How to make a grid? use 2d array
     *  2) What is backtracking ?
     *    2.1) My explanation
     *    - On Search algorithm, we can make faster with this
     *    - It has specific condition which direction or path is possible.
     *      If we can avoid, worthless node search, we can improve speed.
     *    - It works with recursive way, and each step we can save node data.
     *    - When it reach of end of search condition, we can also finally save a path.
     *      And it go back(backtrack) to parent node step by step(Stack structure), At the moment we remove one by one the previous node.
     *
     *    2.2) Good link explanation
     *       - https://www.geeksforgeeks.org/backtracking-algorithms/
     *     Backtracking is an algorithmic-technique for solving problems recursively by trying to build a solution incrementally, one piece at a time
     *     , removing those solutions that fail to satisfy the constraints of the problem at any point of time
     *     (by time, here, is referred to the time elapsed till reaching any level of the search tree).
     *
     *     For example, consider the SudoKo solving Problem,
     *     we try filling digits one by one. Whenever we find that current digit cannot lead to a solution
     *     , we remove it (backtrack) and try next digit. This is better than naive approach
     *     (generating all possible combinations of digits and then trying every combination one by one) as it drops a set of permutations whenever it backtracks.
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
     *   - we give this
     *     0 : wall
     *     1 : path >> we can give any path as a start point
     *     2 : exit
     *
     *  - Provide all paths while lookup the exit.
     *  - Path data type is 2d array.
     *
     *
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

        // save all possible path here!
        // If there is a path has 2 value. that is path we look for.
        // Future I can calculate most shortest path as well as we can count path 1.
        // and shortest one is the answer!
        // Then I can make a Quiz saying 'Find exit paths and order by shortest asc'
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


    /**
     *
     * It works recursively.
     *
     * @param maze    Given maze
     * @param row
     * @param col
     * @param visited It tracks all visited node
     * @param result  It save path recursive way(Add node sequentially, And remove node when backtrack happen sequentially)
     *                When it finally fail or found path, it save current path in paths variable.
     * @param paths   Save all possible paths
     * @return        Visited node map from maze
     */
    public int[][] solveMaze(int[][] maze, int row, int col, int[][] visited, int[][] result, List<HashMap<String, Object>> paths) {


        // we need to have visited area. as map
        // so


        // pseudo code
        // 1. start from the start point

        // 2. Set exit condition
        //    - 2.1 over flow of direction top/bottom/left/right



        //    - 2.2 When hit the exit   --> value == 2
        //    - 2.3 when it's not path  --> value == 1




        if (isSafe(maze, row, col, visited, result, paths)) {
            visited[row][col] = 1;
            // if hit exit set as 2 to identify! which path found exit!
            result[row][col] = (maze[row][col] == 2) ? 2 : 1;

            // Init all direction map
            Map<String, Boolean> direction_map = new HashMap<>();
            direction_map.put("top",false);
            direction_map.put("right",false);
            direction_map.put("down",false);
            direction_map.put("left",false);


            log.debug("visited x: {}, y: {} point", row, col);

            // 3. loop 4 direction or just write down by order
            // Move to Top
            if(isSafe(maze, row-1, col, visited, result, paths)) {
                direction_map.put("top",true);
                solveMaze(maze, row-1, col, visited, result, paths);
                result[row-1][col] = 0;
            }
            // Move to Right
            if(isSafe(maze, row, col+1, visited, result, paths)) {
                direction_map.put("right",true);
                solveMaze(maze, row, col+1, visited, result, paths);
                result[row][col+1] = 0;
                log.debug("hi there");
            }

            // Move to Down
            if(isSafe(maze, row+1, col, visited, result, paths)) {
                direction_map.put("down",true);
                solveMaze(maze, row+1, col, visited, result, paths);
                result[row+1][col] = 0;
            }

            // Move to Left   path and list of the path...
            if (isSafe(maze, row, col-1, visited, result, paths)) {
                direction_map.put("left",true);
                solveMaze(maze, row, col-1, visited, result, paths);
                result[row][col-1] = 0;
            }



            long direction_count = direction_map.entrySet().stream().filter(x -> x.getValue() == false).count();

            if (direction_count == 4) {
                log.debug("false direction is over 1 : {}", direction_count);
                int[][] temp_result = Arrays.stream(result).map(int[]::clone).toArray(int[][]::new);
                HashMap<String, Object> temp = new HashMap<>();
                temp.put("has_exit",false);
                temp.put("path",temp_result);
                paths.add(temp);
            }

        }

        return visited;
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
//        if (maze[row][col] == 2) {
//            result[row][col] = 2;
//            return false;
//        }
        return true;
    }













}
