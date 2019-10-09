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
}
