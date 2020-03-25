package play;

import com.jeonhwan.algorithm.sort.MergeSort;
import com.jeonhwan.play.LongestCommonSubString;
import com.jeonhwan.play.Median;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

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
        List<String[]> list = new ArrayList<>();

        list.add(new String[]{"GeeksforGeeks", "GeeksQuiz"});
        list.add(new String[]{"abcdxyz", "xyzabcd"});
        list.add(new String[]{"zxabcdezy", "yzabcdezx"});
        list.add(new String[]{"CACA", "ACAC"});

        for (String[] item : list) {
            String longestCommonSubString = solution.findLongestCommonSubString(item[0].toCharArray(), item[1].toCharArray());
            log.debug("Result : {}, from String A: {}, B: {}", longestCommonSubString, item[0], item[1]);
        }

        log.debug("done");

    }



}
