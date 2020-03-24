package play;

import com.jeonhwan.algorithm.sort.MergeSort;
import com.jeonhwan.play.LongestCommonSubString;
import com.jeonhwan.play.Median;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LongestCommonSubStringTest {
    private static Logger log = LoggerFactory.getLogger(MergeSort.class);



    @Test
    public void total_substring_count_test() {

        LongestCommonSubString solution = new LongestCommonSubString();
        String str = "abcde";
        int count = solution.getTotalSubstringCount(str);
        log.debug("TotalSubstringCount: {}", count);
        log.debug("done");

    }


    @Test
    public void find_longest_common_substring_number() {

        LongestCommonSubString solution = new LongestCommonSubString();
        String a = "GeeksforGeeks";
        String b = "GeeksQuiz";
        String a2 = "abcdxyz";
        String b2 = "xyzabcd";
        String a3 = "zxabcdezy";
        String b3 = "yzabcdezx";



        int count = solution.findLongestCommonSubString(a3.toCharArray(), b3.toCharArray());
        log.debug("TotalSubstringCount: {}", count);
        log.debug("done");

    }



}
