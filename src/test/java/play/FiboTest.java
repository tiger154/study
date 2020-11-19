package play;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FiboTest {
    private static Logger log = LoggerFactory.getLogger(FiboTest.class);

    /**
     * basic example
     * @param n
     * @return
     */
    public int fibo(int n) {
        if (n <= 1) return 1;
        return fibo(n-1) + fibo(n-2);
    }



    public int fibo_cache(int n, int[] cache) {
        if (n <= 1) return 1;

        if (cache[n] > 0) return cache[n];

        return cache[n] = fibo_cache(n-1, cache) + fibo_cache(n-2, cache);
    }

    @Test
    public void fibotest_cache() {
        int n = 5;
        int[] cache = new int[n+1];
        int rtn = fibo_cache(n, cache);


        log.debug("rtn: {}", rtn);
    }


    /**
     * What would be the time complexity?
     *
     *
     */
    @Test
    public void fibotest() {
        int rtn = fibo(5);
        log.debug("rtn: {}", rtn);
    }
}
