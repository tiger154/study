package play;

import com.jeonhwan.algorithm.sort.MergeSort;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import static org.junit.Assert.*;

public class BackTrackTest {
    private static Logger log = LoggerFactory.getLogger(MergeSort.class);

    //-------------------------------------------------------------------------------
    // Maze solving with backtracking
    //-------------------------------------------------------------------------------

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


    /**
     * Alright lets solve the problem myself now Im bit used to it about backtrack ! .
     *
     *  So alphabet given between 2-9
     *  - Need to use recursive
     *  - Need to return all paths
     *
     *  - Use map for digit
     *  - Exit condition > if given next digit is null? then exit!
     *
     *  - Get given digit's alphabets
     *  - loop each alphabet
     *  - call itself with parameter
     *    - first > path (incremented concat string)
     *    - second > next digit.
     *
     *
     *
     */

    // As constant data
    Map<String,String> dial = new HashMap<String,String>(){{
        put("2","abc");
        put("3","def");
        put("4","ghi");
        put("5","jkl");
        put("6","mno");
        put("7","pqrs");
        put("8","tuv");
        put("9","wxyz");
    }};
    List<String> combnations = new ArrayList<>();


    @Test
    public void subst_test() {
        String a = "abc";
        Assert.assertEquals("ab",a.substring(0, a.length()-1));
    }


    @Test
    public void backtrack_test_again() {

        List<String> result = new ArrayList<>();
//        // call back track here! to see all possible path
//        comb_get(result, "", "");
//        assertTrue(  Arrays.asList("").containsAll(result) && result.containsAll(Arrays.asList("")));

        result = new ArrayList<>();
        comb_get(result, "", "2");
        assertTrue(  Arrays.asList("a","b","c").containsAll(result) && result.containsAll(Arrays.asList("a","b","c")));


        for (String combination : result) {   log.debug(combination);}
    }

    public void comb_get(List<String> result, String curr, String digits) {

        if (digits.isEmpty())  {
            result.add(curr);
            return;
        }

        String s = dial.get(digits.substring(0,1));

        for (int i=0; i< s.length(); i++) {

            curr = curr + s.charAt(i);
            comb_get(result, curr, digits.substring(1)); // decrease possible digits num
            curr = curr.substring(0, curr.length()-1);
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() > 0) comb_get(result, "", digits);
        return result;
    }







    @Test
    public void backtrack_test() {


        // call back track here! to see all possible path
        backtrack_("", "2489");

        for (String combination : combnations) {
            log.debug(combination);
        }


    }

    public void backtrack_(String path, String next) {
        // Exit point here
        if (next.isEmpty()) {
            //log.debug(path);
            combnations.add(path);
            return;
        }
        String alphabets =  dial.get(next.substring(0,1));
        // Try possible direction(which is selected alphabets only)
        for (char alphabet  : alphabets.toCharArray()) {
            // 1. sequently concat string
            path = path + alphabet;
            // 2. Call recursively for next digit
            backtrack_(path, next.substring(1));
            // 3. When the end of stack, remove last element
            path = path.substring(0, path.length() -1);
        }
    }



    //-------------------------------------------------------------------------------
    // Backtrack Tests from Leetcode:
    //   - https://leetcode.com/problems/permutations/discuss/18239/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partioning)
    //   - Description backtracking: https://medium.com/algorithms-and-leetcode/backtracking-e001561b9f28
    // To see general backtrack problems solving.
    //
    //   !! 7 Problem with backtracking practice!
    //
    //  1. Drawl(Make) a tree(or map) with ur hand.
    //  2. Think(Draw) backtracking order (usually there is concat string, and looping arguments.
    //  3. Think(Draw) parameter structure in detail
    //  4. Think(Draw) When to save the data
    //
    //   So far I used this to get combinations, find path. wonder where I can use this more !
    //
    //  permutations & combination detail explanation: https://gridamath.tistory.com/43
    //-------------------------------------------------------------------------------

    /**
     * 1. SubSet
     *    - https://leetcode.com/problems/subsets/
     *    I spent lot of time to debug on my head(not writing, no IDE)
     *    First of all I didn't know subset mean so bit confused.
     *
     *
     *
     */

    @Test
    public void subset_test() {
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> rtn = subsets(nums);
        log.debug("hi there, rtn: {}", rtn);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums); // Let's check again why do we need sorting here? as it need time O(n Log n)
        backtrack_subset(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void backtrack_subset(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack_subset(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }

    }

    /**
     * 2. SubSet with dup data
     *    - https://leetcode.com/problems/subsets-ii/
     *
     *   To check duplication I first thought HashSet<List<Integer>>, But some how it doesnt work
     *   And I though what about using HashSet<List<String>> which I need to use 'arrays.toString' But I guess that would be O(N)
     *   Which is expensive so probably interviewer doesnt want.
     *
     *   And I couldn't find answer, but after check the answer it was aha moment ;)
     *   1. As it's sort first, all duplication is aligned
     *   2. As it check all combination left to right. on each level if there is duplicate we can check  if (i == i-1)
     *      - Because it's subset it's working
     */

    @Test
    public void subset_dup_test() {
        int[] nums = new int[]{1,2,2};
        List<List<Integer>> rtn = subsetsWithDup(nums);
        log.debug("hi there, rtn: {}", rtn);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        // duplication checker
        List<List<Integer>> final_list = new ArrayList<>();
        Arrays.sort(nums);  // It must be sorted...
        backtrack_subset_with_dup( final_list, nums, new ArrayList<Integer>(), 0);

        return final_list;

    }

    public void backtrack_subset_with_dup(List<List<Integer>> final_list, int[]  nums, List<Integer> curr, int start) {
        // add data if not duplicate --> It doesn't detect..
        // array compare, I would say gonna make to string and compare.it
        // Index comparing is not needed. we need to compare data if it's same...

        final_list.add(new ArrayList<>(curr));

        // loop (start ~ nums.length)
        for (int i = start; i < nums.length; i++) {

            // this single line is a beauty, and define everything here
            // If it's ordered we can simply compare i and i-1
            // If it was not subset but Permutations we can't use this..
            if (i > start && nums[i] == nums[i-1]) continue;

            // concat cur combination
            curr.add(nums[i]);
            // call again
            backtrack_subset_with_dup(final_list, nums, curr, i+1);
            // backtrack after it done
            curr.remove(curr.size()-1);
        }
    }



    /**
     *  3. Permutations
     *    - https://leetcode.com/problems/permutations/
     *
     *    - I already solve myself but not using backtrack, Mine is bit better (O(n! *n ), then backtrack (n! * n^2) but for the practice reason I implement it.
     *
     */

    @Test
    public void permute_test() {
        int[] nums = new int[]{1,1,2};
        List<List<Integer>> rtn = permute(nums);
        log.debug("hi there, rtn: {}", rtn);
    }

    public List<List<Integer>> permute(int[] nums) {
        // lets call backtrack function
        List<List<Integer>> list = new ArrayList<>();
        boolean[] dup_checker = new boolean[nums.length]; // initial value is set to false! good
        backtrack_permute(list, nums, new ArrayList<>(), dup_checker);
        return list;
    }


    public void backtrack_permute(List<List<Integer>> list, int[] nums, List<Integer> curr, boolean[] dup_checker) {

        // exit condition or adding data condition
        if (curr.size() == nums.length)
            list.add(new ArrayList<>(curr));

        // (n! * n^2) time for each -> which is quit expensive!
        for (int i =0; i < nums.length; i++) {

            if (dup_checker[i]) continue;   // duplication skip

            // path(comb) making
            curr.add(nums[i]);
            dup_checker[i] = true;

            // recursive call!
            backtrack_permute(list, nums, curr, dup_checker);
            // backtrack
            curr.remove(curr.size()-1);
            dup_checker[i] = false;
        }
    }


    /**
     *  4. Permutations II (contains duplicates) :
     *    - https://leetcode.com/problems/permutations-ii/
     *
     *   Duplicate check how to do it
     *
     *   1. Sorting manner
     *     1) sort first
     *     2) if i >0 && arr[i] == arr[i-1] && !used[i-1] ==> duplication!!
     *
     *
     *
     *
     *
     *   2. Counter strategy
     *     1) Make an hashmap -> Real candidate with count
     *     2) Pass argument with count-1 everytime
     *     3) On backtrack, recover count as well.
     *       - Keep going on.
     *
     *
     *
     *
     */

    @Test
    public void permute_uq_test() {

        List<List<Integer>> rtn = permuteUnique(new int[]{1,1,2});
        log.debug("hi there, rtn: {}", rtn);

        rtn = permuteUnique(new int[]{1,2,3});

        log.debug("hi there, rtn: {}", rtn);
    }


    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();

        // count the occurrence of each number
        HashMap<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            if (!counter.containsKey(num))
                counter.put(num, 0);
            counter.put(num, counter.get(num) + 1);
        }

        LinkedList<Integer> comb = new LinkedList<>();
        this.backtrack(comb, nums.length, counter, results);
        return results;
    }

    protected void backtrack(
            LinkedList<Integer> comb,
            Integer N,
            HashMap<Integer, Integer> counter,
            List<List<Integer>> results) {

        if (comb.size() == N) {
            // make a deep copy of the resulting permutation,
            // since the permutation would be backtracked later.
            results.add(new ArrayList<Integer>(comb));
            return;
        }

        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            Integer num = entry.getKey();
            Integer count = entry.getValue();
            if (count == 0)
                continue;
            // add this number into the current combination
            comb.addLast(num);
            counter.put(num, count - 1);

            // continue the exploration
            backtrack(comb, N, counter, results);

            // revert the choice for the next exploration
            comb.removeLast();
            counter.put(num, count);
        }
    }


    /**
     *  5. Combination Sum
     *    - https://leetcode.com/problems/combination-sum/
     *    - It looks like Combinations with allowing duplication
     *
     *    Problem: I didn't realize this is combination with duplication.
     *    Reason: I have small experience of this types.
     *    Solution: Solve and Sort it out myself more of related types.
     *
     *     - But I can build plan how to solve this. Also could explain Time complexity.
     *
     *
     *   1) Idea
     *     (1) Generate all combinations with recursive
     *
     *   2) Recursive in detail
     *
     *     target: target number
     *     start: loop start index, (incremental number)
     *     end  : length of given array (Static number)
     *     curr : current comb (list of int)
     *     final : final combs ( lis of list of int)
     *     sum  : each time sum value
     *       - sum = 0; // init
     *       - sum = sum +  (Level)N[Index]
     *       !! When we pass the 'sum' data we need pass as
     *     (1) Loop (i = start ~ end, i++)
     *       - Each index can be selected again
     *       - Pass sum (sum += m)  value to next call     *
     *          (2) Exit condition
     *               A. If sum > target  --> return;
     *               B. If sum == target --> save combination && return;
     *
     *          (3) Curr.add(arr[i])
     *          (4) Call f(target, i, end, sum, curr, final)
     *               -
     *          (5) Backtracking
     *               Curr.remove(curr.length)
     *
     *    3) TimeComplexity
     *       - H(n,r) = C(n+r - 1, r) => nHr = n+r-1Cr
     *      1) All combinations: nCr + nCr-1 + nCr-2 ... + nC1
     *          - O(nHr * n )
     *         - n : length of number (0 - n)
     *
     *      2) Each element can be increased M time
     *          - n * M
     *          - n is length of number
     *          - M is maximum repeated element
     *            > log n[0] target
     *
     *      3) Final result
     *          - O(nHr * n * n * M) =>  O(nCr * n^n * M)
     *
     *          which is really
     *
     */


    @Test
    public void comb_sum_test() {

        Assert.assertEquals(new ArrayList<List<Integer>>(){{
            add(Arrays.asList(2,2,3)); add(Arrays.asList(7));
        }}, combinationSum(new int[]{2,3,6,7}, 7));

        Assert.assertEquals(new ArrayList<List<Integer>>(){{
            add(Arrays.asList(2,2,2,2)); add(Arrays.asList(2,3,3)); add(Arrays.asList(3,5));
        }}, combinationSum(new int[]{2,3,5}, 8));

        Assert.assertEquals(new ArrayList<List<Integer>>(), combinationSum(new int[]{2}, 1));

        Assert.assertEquals(new ArrayList<List<Integer>>(){{
            add(Arrays.asList(1));
        }}, combinationSum(new int[]{1}, 1));

        Assert.assertEquals(new ArrayList<List<Integer>>(){{
            add(Arrays.asList(1,1));
        }}, combinationSum(new int[]{1}, 2));
        //log.debug("hi there, comb_list: {}", comb_list);
    }


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> final_list = new ArrayList<>();
        combination_sum_recursive(candidates, target, final_list, new ArrayList<Integer>(), 0, 0);
        return final_list;
    }

    public void combination_sum_recursive(int[] nums, int target, List<List<Integer>> final_list, List<Integer> curr, int sum, int start) {

        // exit condition
        if (sum > target) return;
        if (sum == target) final_list.add(new ArrayList<>(curr));

        // loop recursive logic here!
        for (int i = start; i < nums.length; i++) {
            int temp_sum = sum + nums[i];    // If it's copy of value it should be fine!
            curr.add(nums[i]);
            // call recursive
            combination_sum_recursive(nums, target, final_list, curr, temp_sum, i);
            // backtracking
            curr.remove(curr.size() - 1);
        }

    }


    /**
     * 6. Combination Sum2
     *   - https://leetcode.com/problems/combination-sum-ii/
     *
     * Idea: It's similar with subset problem but with sum condition
     *       1) So make subset with saving sum subset
     *       2) Skip If arr[i-1] == arr[i] then result would be same ?
     *
     *
     *  10,1,2,7,6,1,5
     *
     *  1,1,2,5,6,7,10
     */
    @Test
    public void comb_sum2_test() {
        Assert.assertEquals(new ArrayList<List<Integer>>(){{
            add(Arrays.asList(1,1,6)); add(Arrays.asList(1,2,5)); add(Arrays.asList(1,7)); add(Arrays.asList(2,6));
        }}, combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));


        Assert.assertEquals(new ArrayList<List<Integer>>(){{
            add(Arrays.asList(1,2,2)); add(Arrays.asList(5));
        }}, combinationSum2(new int[]{2,5,2,1,2}, 5));

        // 2,5,2,1,2
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> final_list = new ArrayList<List<Integer>>();
        combination_sum2_recursive(candidates, target, final_list, new ArrayList<Integer>(), 0, 0 );
        return final_list;

    }

    public void combination_sum2_recursive(int[] nums, int target, List<List<Integer>> final_list, List<Integer> curr, int sum, int start) {

        // ignore edge cases
        if (sum > target) return;
        // save data
        if (sum == target) final_list.add(new ArrayList<>(curr));


        for (int i = start; i < nums.length; i++) {
            // sum data
            int temp_sum = sum + nums[i];


            if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates

            log.debug("combination: {}, sum: {}", curr, sum);

            // set curr
            curr.add(nums[i]);
            // recursive call
            combination_sum2_recursive(nums, target, final_list, curr, temp_sum, i+1);
            // backtrack
            curr.remove(curr.size()-1);

        }
    }


    /**
     * 7. Palindrome Partitioning
     *  - https://leetcode.com/problems/palindrome-partitioning/
     *
     * Idea: Generate All SubString
     *        - pass start+1
     *        - loop i=start ~ end of string
     *        - from start ~ i --> consecutive combination(SubString)
     *       Check If its valid palindrome
     *        - Use two index (start++, end--) , while(start < end)
     *        - So we can check N/2 time by word
     *
     */
    @Test
    public void palindrome_test() {


        Assert.assertEquals(new ArrayList<List<String>>(){{
            add(Arrays.asList("a","a","b")); add(Arrays.asList("aa", "b"));
        }}, partition("aab"));
    }

    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), s, 0);
        return list;
    }

    public void backtrack(List<List<String>> list, List<String> tempList, String s, int start){



        if(start == s.length())
            list.add(new ArrayList<>(tempList));
        else{
            for(int i = start; i < s.length(); i++){
                if(isPalindrome(s, start, i)){
                    tempList.add(s.substring(start, i + 1));
                    backtrack(list, tempList, s, i + 1);
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }

    public boolean isPalindrome(String s, int low, int high){
        while(low < high)
            if(s.charAt(low++) != s.charAt(high--)) return false;
        return true;
    }



    public List<List<String>> partition2(String s) {
        List<List<String>> list = new ArrayList<>();
        backtrack2(list, new ArrayList<>(), s, 0);
        return list;
    }

    public void backtrack2(List<List<String>> list, List<String> tempList, String s, int start){

        // it goes to the end so don't need any of exit condition

        // save condition --> It doesn't need to reach all branch
        // so when ever it reach at the end  stop it. 
        if (start == s.length()) {
            // this is the point to return.
        }
        if(start == s.length())
            list.add(new ArrayList<>(tempList));
        else{
            for(int i = start; i < s.length(); i++){
                if(isPalindrome2(s, start, i)){
                    tempList.add(s.substring(start, i + 1));
                    backtrack2(list, tempList, s, i + 1);
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }

    public boolean isPalindrome2(String s, int low, int high){
        while(low < high)
            if(s.charAt(low++) != s.charAt(high--)) return false;
        return true;
    }



    public boolean is_pal(String s) {
        for (int i=0; i < s.length()/2; i++) {
            if (s.charAt(i) != s.charAt(s.length()-1-i)) return false;
        }
        return true;
    }

    public boolean is_pal_index(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }


    @Test
    public void is_pal_index_test() {
        Assert.assertTrue(is_pal_index("aba",0,2));
        Assert.assertFalse(is_pal_index("aba",1,2));

    }

    @Test
    public void is_pal_test() {
        Assert.assertTrue(is_pal("aba"));
        Assert.assertFalse(is_pal("abaa"));
        Assert.assertTrue(is_pal("abba"));
        Assert.assertTrue(is_pal("npapn"));
    }


    // get all substring is this... pal is just for fun!
    //





}
