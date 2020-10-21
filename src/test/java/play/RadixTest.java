package play;

import com.jeonhwan.algorithm.sort.MergeSort;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RadixTest {
    private static Logger log = LoggerFactory.getLogger(RadixTest.class);

    @Test
    public void convertTo() {

        int[] arr = new int[100];
        int i = 0, j;

        int decimal = 72;
        int radix = 8;

        while (decimal >= radix) {
            arr[i] = decimal % radix;
            decimal /= radix;
            i++;
        }

        arr[i] = decimal;

        log.debug("hi there arr: {}", arr);



    }
}
