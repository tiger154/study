package play;


import org.junit.Test;

/**
 * Test whatever queue related works
 *   1. simple queue
 *     - limit capacity
 *     - O(1)
 *     - May we can make better?
 *
 *  2. priority queue (may be)
 *     - naive implementation: using list -_-;;
 *     - heap implementation: much better one
 */
public class SimpleQueueTest {




    // 1. Make a simple queue
    // queue need head -> to get most front node
    // queue need tail -> to add item at last
    // Idea: If size is set, then we can use index to control data.
    //   enqueue: add data at tail+1 index
    //            if size is over then throw overflow
    //   dequeue: get data at head and change head+1
    //   peek
    //
    public class SimpleQueue {

        private int arr[];  		// array to store queue elements
        private int front;  		// front points to front element in the queue
        private int rear;   		// rear points to last element in the queue
        private int capacity;   	// maximum capacity of the queue
        private int count;  		// current size of the queue

        // Constructor to initialize queue
        SimpleQueue(int size)
        {
            arr = new int[size];
            capacity = size;
            front = 0;
            rear = -1;
            count = 0;
        }

        // Utility function to remove front element from the queue
        public void dequeue()
        {
            // check for queue underflow
            if (isEmpty())
            {
                System.out.println("UnderFlow\nProgram Terminated");
                System.exit(1);
            }

            System.out.println("Removing " + arr[front]);

            front = (front + 1) % capacity;
            count--;
        }

        // Utility function to add an item to the queue
        public void enqueue(int item)
        {
            // check for queue overflow
            if (isFull())
            {
                System.out.println("OverFlow\nProgram Terminated");
                System.exit(1);
            }

            System.out.println("Inserting " + item);

            rear = (rear + 1) % capacity;
            arr[rear] = item;
            count++;
        }

        // Utility function to return front element in the queue
        public int peek()
        {
            if (isEmpty())
            {
                System.out.println("UnderFlow\nProgram Terminated");
                System.exit(1);
            }
            return arr[front];
        }

        // Utility function to return the size of the queue
        public int size()
        {
            return count;
        }

        // Utility function to check if the queue is empty or not
        public Boolean isEmpty()
        {
            return (size() == 0);
        }

        // Utility function to check if the queue is full or not
        public Boolean isFull()
        {
            return (size() == capacity);
        }

    }

    @Test
    public void simple_bug_test() {
        SimpleQueue q  = new SimpleQueue(3);

        q.enqueue(1);
        q.enqueue(2);
//        q.enqueue(3);

        System.out.println("Front element is: " + q.peek());
        q.dequeue();
        System.out.println("Front element is: " + q.peek());

        System.out.println("Queue size is " + q.size());

        q.dequeue();
//        q.dequeue();

        if (q.isEmpty()) {
            System.out.println("Queue Is Empty");
        } else {
            System.out.println("Queue Is Not Empty");
        }

        // So here what happen I tried to add more
        q.enqueue(3);

        q.dequeue();

        System.out.println("Queue size is " + q.size());
    }


}
