package play;

import com.jeonhwan.algorithm.sort.MergeSort;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Make simple request call and log result with multi thread
 *
 * make sample url list
 * run using ExecutorService(threadPool)
 *
 * one instance only. many function call
 * If generate too many
 *
 *
 * Var scope on multi thread : https://emong.tistory.com/187
 *
 */
public class MultiThreadRequesterTest {

    private static Logger log = LoggerFactory.getLogger(MultiThreadRequesterTest.class);




    @Test
    public void isValidUrls() throws MalformedURLException, IOException {

        long startTime = System.nanoTime();
        List<ResponseModel> list = Collections.synchronizedList(new ArrayList<ResponseModel>()); // multi threads gonna access to this value, so it must be thread safe
//        List<ResponseModel> remote_list = list;
        // 1. get urls
        List<String> urls = new ArrayList<>();
        urls.add("https://play.google.com/store/apps/details?id=com.bestappfactory.lotto_1");
        urls.add("https://play.google.com/store/apps/details?id=com.eyefilter.night");
        urls.add("https://play.google.com/store/apps/details?id=com.quick.clean.easy");
        urls.add("https://play.google.com/store/apps/details?id=com.cashwalk.cashwalk");


        int threadPoolSize = 5;

        ExecutorService executorService = Executors.newFixedThreadPool(threadPoolSize);

        // 2. loop urls
        for (String url : urls) {
            // lets do lambda here
            Runnable task = () -> {
                try {
                    // make every time new instance for safety
                    Requester requester =  new Requester();
                    requester.setList(list);
                    requester.requestAndCodeReturn(url);
                } catch (Exception e) {
                   System.out.println(e.getMessage());
                }
            };
            executorService.submit(task);
        }

        executorService.shutdown();
        try {
            if(!executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.debug(e.getMessage());
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }




       // 3. run
//       Requester requester =  new Requester();
//       int res_code =  requester.requestAndCodeReturn("https://play.google.com/store/apps/details?id=com.bestappfactory.lotto_1");

       long elapsedTime = System.nanoTime() - startTime;

        System.out.println("Total execution time in millis: " + elapsedTime/1000000 + ", in seconds: " + TimeUnit.MILLISECONDS.toSeconds(elapsedTime/1000000));

       log.debug("hi there");
    }


    @Test
    public void isValidUrls_brute_force() throws MalformedURLException, IOException {

        long startTime = System.nanoTime();

        // 1. get urls
        List<String> urls = new ArrayList<>();
        urls.add("https://play.google.com/store/apps/details?id=com.bestappfactory.lotto_1");
        urls.add("https://play.google.com/store/apps/details?id=com.eyefilter.night");
        urls.add("https://play.google.com/store/apps/details?id=com.quick.clean.easy");
        urls.add("https://play.google.com/store/apps/details?id=com.cashwalk.cashwalk");


        int threadPoolSize = 5;

        ExecutorService executorService = Executors.newFixedThreadPool(threadPoolSize);

        // 2. loop urls
        for (String url : urls) {
            Requester requester =  new Requester();
            requester.requestAndCodeReturn(url);
        }

        long elapsedTime = System.nanoTime() - startTime;

        System.out.println("Total execution time in millis: " + elapsedTime/1000000);

        log.debug("hi there");
    }


    public class ResponseModel {
        private int res_code;
        private String url;

        public int getRes_code() {
            return res_code;
        }

        public String getUrl() {
            return url;
        }

        public void setRes_code(int res_code) {
            this.res_code = res_code;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }



    public class Requester {

        private String url;
        private String return_code;
        private List<ResponseModel> list;
        private Object lock = new Object();

        public Requester() {}

        public Requester(String url, String return_code, List<ResponseModel> list) {
            this.url = url;
            this.return_code = return_code;
            this.list = list;
        }

        public String getUrl() {
            return url;
        }

        public String getReturn_code() {
            return return_code;
        }

        public List<ResponseModel> getList() {
            return list;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public void setReturn_code(String return_code) {
            this.return_code = return_code;
        }

        public void setList(List<ResponseModel> list) {
            this.list = list;
        }

        /**
         * Make a request and return code
         * Also we can control duration here (Must be some singleton duration checker needed)
         *
         * @param url_string
         * @return
         * @throws MalformedURLException
         * @throws IOException
         */
        public int requestAndCodeReturn(String url_string) throws MalformedURLException, IOException {
            synchronized (lock) {
                URL url =  new URL(url_string);
                HttpURLConnection con = (HttpURLConnection)url.openConnection();
                con.setRequestMethod("GET");
                int res_code = con.getResponseCode();

                // log here may we can put down the result to a file..
                System.out.println(Thread.currentThread().getName() + ": res_code=" + res_code + ", url: " + url_string);

                // insert result as well
                // this not gonna be safe is not thread safe
                ResponseModel rm =  new ResponseModel();
                rm.setRes_code(res_code);
                rm.setUrl(url_string);
                list.add(rm);


                return res_code;
            }
        }
    }




    public class Counter implements Runnable {
        public int counter = 0;
        public final int limit = 10;
        public final Object lock = new Object();
        @Override
        public void run() {
            while (counter < limit) {
                increaseCounter();
            }
        }
        private void increaseCounter() {
            synchronized (lock) {
                //log.debug("hi there");
                // log.debug("count: {}", counter);
               // log.debug("{} : {}", Thread.currentThread().getName(), 1);
                System.out.println(Thread.currentThread().getName() + " : " + counter);
                counter++;
           }
        }
    }


    /**
     * So If we use one instance to multi thread, we need to lock
     * But if it's every time new instance, it's working well
     */
    @Test
    public void count_one_instance_with_multithread_test() {

        int threadPoolSize = 2;
        Counter counter = new Counter();
        ExecutorService executorService = Executors.newFixedThreadPool(threadPoolSize);
        for (int i =0; i < threadPoolSize; i++) {
            executorService.submit(counter);
        }
         executorService.shutdown();
    }

    @Test
    public void count_multi_instance_with_multithread_test() {

        int threadPoolSize = 3;
        ExecutorService executorService = Executors.newFixedThreadPool(threadPoolSize);
        for (int i =0; i < threadPoolSize; i++) {
            executorService.submit(new Counter());
        }
         executorService.shutdown();
    }


    public void performStaticSyncTask() {
        synchronized (this) {

        }
    }


    @Test
    public void datatype_iterate_test() {
        final Vector<Integer> a = new Vector<Integer>();
        for(int i=0;i<100;i++) {
            a.add(i);
        }

        new Thread() {
            public void run() {
                for (int i=100;i<1000;i++) {
                    a.add(i);
                }
            }
        }.start();

        for (Integer integer: a) {
            System.out.println(integer);
        }

    }


}
