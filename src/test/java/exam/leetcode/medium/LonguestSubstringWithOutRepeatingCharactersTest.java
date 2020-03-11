package exam.leetcode.medium;

import com.jeonhwan.exam.leetcode.medium.LongestSubstringWithOutRepeatingCharacters;
import org.junit.Test;

public class LonguestSubstringWithOutRepeatingCharactersTest {





    @Test
    public void longestSubStringWithOutRepeatingCharactersTest() {


        LongestSubstringWithOutRepeatingCharacters solution = new LongestSubstringWithOutRepeatingCharacters();



        String test = "pwwkew";
//        String test = "abcabcbb";
//        String test = "bbbbb";
//        String test = "dvdf";
        // dvf

        //String test = "acbeaebcdd";

        int longest_length2 = solution.lengthOfLongestSubstringApproach2(test);
        int longest_length3 = solution.lengthOfLongestSubstringLeetcode(test);





        System.out.println("hey");
    }

}
