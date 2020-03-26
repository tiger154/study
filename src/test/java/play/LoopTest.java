package play;

import com.jeonhwan.algorithm.sort.MergeSort;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoopTest {
    private static Logger log = LoggerFactory.getLogger(MergeSort.class);


    /**
     * Practice iteration
     *
     * Make triangle below ->
     * *****
     * ****
     * ***
     * **
     * *
     *
     * 01234
     * 0123
     * 012
     * 01
     * 0
     *
     */
    @Test
    public void triangle_star_test() {

        int length = 5;

        String line = "";
        String num_line="";

        for(int i =0; i < length; i++) {
            line = "";
            num_line = "";
            for(int j =0; j < length - i; j++) {
                line = line.concat("*");
                num_line = num_line.concat(String.valueOf(j));
                if (j+1 == length - i) {
                    log.debug("line: {}, num_line: {}", line, num_line);
                }
            }
        }
    }

}
