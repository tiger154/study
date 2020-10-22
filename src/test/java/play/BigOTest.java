package play;

import com.jeonhwan.algorithm.sort.MergeSort;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * https://holika.tistory.com/entry/%EC%9E%90%EB%A3%8C%EA%B5%AC%EC%A1%B0-%EB%B9%85-%EC%98%A4-%ED%91%9C%EA%B8%B0%EB%B2%95Big-O-notation%EC%9D%B4%EB%9E%80
 */
public class BigOTest {

    private static Logger log = LoggerFactory.getLogger(BigOTest.class);

    //-----------------------------------------------
    // 1+2+3.... BigO Comparing by different algorithm.
    //-----------------------------------------------

    /**
     * O(N*M)
     *   - M is increasing by Nth length
     */
    @Test
    public void bigo_test() {

        int n = 4;
        int result = 0;

        for (int i =1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                result++;
            }
        }

        log.debug("result: {}", result);

    }


    /**
     * O(N)
     */
    @Test
    public void bigo_test2() {

        int n = 3;
        int result = 0;

        for (int i =1; i <=n; i++) {
            result += i;
        }

        log.debug("result: {}", result);

    }

    /**
     * O(1)
     */
    @Test
    public void bigo_test3() {
        int n = 3;
        int result = 0;
        result = n * (n+1) /2;
        log.debug("result: {}", result);
    }
}
