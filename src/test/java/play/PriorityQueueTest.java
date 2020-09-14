package play;


import com.jeonhwan.algorithm.sort.MergeSort;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;

/**
 * I think it needs to use map data structure
 *   need index -> O(1)
 *   need link each other
 *   need head
 *   need tail
 *
 *
 *  Refer: https://www2.cs.duke.edu/csed/poop/huff/spring05/code/PriorityQueue.java
 *         https://github.com/openjdk-mirror/jdk7u-jdk/blob/master/src/share/classes/java/util/PriorityQueue.java
 *
 */
public class PriorityQueueTest {
    private static Logger log = LoggerFactory.getLogger(MergeSort.class);




    // Let's make a priority queue!
    // Best to do to me is copy as much I can
    // dont take to much time myself to find best solution
    // but at least need to think about the brute force solution.(even this one If take too much time then need to skip)
    // First goal is finish 50,100 problems.
    // And Do second time(with review) -> memo main problems and implement again
    // And Do third time(deep review of other solutions)
    // And Do again till I feel easy. (make content maybe? )





    // priority queue
    //   - map
    //   - heap -> We know head and tail , how to make insert ?
    //   -
    // 1) need null filtered value -> null not accepted
    // 2) need

    // PriorityQueue doesn’t permit null. --> there must be null check logic
    // We can’t create PriorityQueue of Objects that are non-comparable --> data must be comparable which mean it needs key value(Need compare logic implement)
    // PriorityQueue are unbound queues. --> Increase without capacity (Linked list would fit well)
    // Head is least value --> Sounds like needed sorting (heap sort would fit?)
    // The queue retrieval operations poll,  remove,  peek, and element access the element at the head of the queue.
    //   --> lets think about how to poll, remove, peek, get head data
    // It inherits methods from AbstractQueue, AbstractCollection, Collection and Object class.



    // PriorityQueue interesting as it order when adding happen


    @Test
    public void priority_queue_add_data_structure_test() {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        pq.add(2);
        pq.add(4);

        pq.add(1);
        pq.add(3);

        while (!pq.isEmpty()) {
            Integer top = pq.remove();  // get top?
            log.debug("print data: {}", top);
        }
        log.debug("hey");
    }


    @Test
    public void overflow_integer_test() {
        int a = Integer.MAX_VALUE;

        int b = a + 1;

        int c = -1;
        int d = -5;


        String one = Integer.toBinaryString(c);
        String five = Integer.toBinaryString(d);

        log.debug("lets check if its gonna be minus! ");
    }




}
