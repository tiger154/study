import com.jeonhwan.algorithm.sort.MergeSort;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.NumberFormat;


public class BasicTest {

    private static Logger log = LoggerFactory.getLogger(MergeSort.class);

    @Test
    public void square_calculate_Teset() {

        long target_num = 2;
        long square_result = 1;
        int loop_count = 32;

        for (int i = 0; i < loop_count; i++) {
            square_result = square_result * target_num;
            log.debug("square {}^{} result is: {}", target_num , i+1 , NumberFormat.getInstance().format(square_result));
        }
    }

    @Test
    public void substring_index_0_test() {
        String str = "hi there";

        String sub0 = str.substring(0,0);
        String sub1 = str.substring(0,1);
        String sub2 = str.substring(0,2);
        String sub3 = str.substring(1,4);

        //quick brown fox jumps over the lazy dog
        log.debug("sub0: {}, sub1: {}, sub2: {}, sub3: {}", sub0 ,sub1, sub2, sub3);
    }


    /**
     * Left index start from 0
     * Right index start from 1
     */
    @Test
    public void substring_index_pattern_test() {
        String str = "abcabcde";


        String sub0 = str.substring(0,1);
        String sub1 = str.substring(1,2);

        String sub2 = str.substring(0,2);
        String sub3 = str.substring(2,4);

        String sub4 = str.substring(0,3);
        String sub5 = str.substring(3,6);

        //quick brown fox jumps over the lazy dog
        log.debug("sub0: {}, sub1: {}", sub0 ,sub1);
        log.debug("sub2: {}, sub3: {}", sub2 ,sub3);
    }
}
