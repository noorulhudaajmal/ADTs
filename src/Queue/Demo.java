package Queue;

public class Demo {
    public static void main(String[] args) {
        testFixedFrontArrayQueue();
        testCircularLinkedQueue();
    }

    private static void testFixedFrontArrayQueue() {

        FixedFrontArrayQueue<Character> c = new FixedFrontArrayQueue<>();
        System.out.println("TEST : 1 [default constructor]");
        System.out.println("Expected : 100 \nActual : " + c.getQueueCapacity());
        System.out.println("------------------------");

        FixedFrontArrayQueue<String> q = new FixedFrontArrayQueue<>(2);
        System.out.println("TEST : 2 [overloaded constructor]");
        System.out.println("Expected : 2 \nActual : " + q.getQueueCapacity());
        System.out.println("------------------------");

        System.out.println("TEST : 3 [underflow exception]");
        System.out.print("Expected : \nQueue is Empty , Actual : \n");
        try {
            q.dequeue(); // Note: Underflow exception should occur
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("------------------------");

        System.out.println("TEST : 4 [isEmpty()]");
        System.out.println("Expected : true \nActual : " + q.isEmpty());
        System.out.println("------------------------");

        System.out.println("TEST : 5 [isFull()]");
        System.out.println("Expected : false \nActual : " + q.isFull());
        System.out.println("------------------------");

        System.out.println("TEST : 6 [size()]");
        System.out.println("Expected : 0 \nActual : " + q.size());
        System.out.println("------------------------");

        System.out.println("TEST : 7 [enqueue()]");
        System.out.println("Enqueue Orange");
        q.enqueue("Orange");
//        System.out.println(q);

        System.out.println("Enqueue Mango");
        q.enqueue("Mango");
//        System.out.println(q);

        System.out.println("Expected : \nSize: 2\nMango\nOrange\nActual : \n" +q);
        System.out.println("------------------------");

        System.out.println("TEST : 8 [overflow exception]");
        System.out.println("Enqueue Guava into full queue");
        System.out.print("Expected : \nQueue is Full , Actual : \n");
        try {
            q.enqueue("Guava"); // Note: with Queue size 2, this won't get into the queue.
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
//        System.out.println(q);
        System.out.println("------------------------");

        System.out.println("TEST : 9 [enqueue() & isFull()]");
        System.out.println("Expected :\nisFull = true \nActual : \nisFull = " + q.isFull());
        System.out.println("------------------------");

        System.out.println("TEST : 10 [dequeue()]");
        System.out.println("Dequeue");
        System.out.println("Expected : Orange\nActual : " +q.dequeue());
        System.out.println("------------------------");

        System.out.println("TEST : 11 [size()]");
        System.out.println("Expected : 1 \nActual : " +q.size());
        System.out.println("------------------------");

        System.out.println("TEST : 12 [isEmpty()]");
        System.out.println("Expected :\nisEmpty = false\nActual : \nisEmpty() = " +q.isEmpty());
        System.out.println("------------------------");

        System.out.println("TEST : 13 [dequeue() & size() & isEmpty()]");
        System.out.println("Dequeue");
        System.out.println("Expected : Mango\nActual : " +q.dequeue());
        System.out.println("Expected : 0 \nActual : " +q.size());
        System.out.println("Expected : true \nActual : " +q.isEmpty());
        System.out.println("------------------------");

        System.out.println("TEST : 14 [enqueue(), resize(), getQueueCapacity(), size(), isEmpty and isFull()]");
        System.out.println("* Enqueue Strawberry");
        q.enqueue("Strawberry");
//        System.out.println(q);

        System.out.println("* Enqueue Lemon");
        q.enqueue("Lemon");
//        System.out.println(q);

        System.out.println("* Resize and Enqueue Banana");
        q.resize(2); // Increase the array size by 2
        q.enqueue("Banana");
        System.out.println("Expected : \nCapacity = 4 , Size = 3 , isEmpty = false , isFull = false\n" +
                "Actual : \nCapacity = "+q.getQueueCapacity()+" , Size = "+q.size()+" , isEmpty = "+q.isEmpty()+
                " , isFull = "+q.isFull());
        System.out.println("------------------------");

        System.out.println("TEST : 15 [enqueue(), resize(), getQueueCapacity(), size(), isEmpty and isFull()]");

        System.out.println("Resize");
        q.resize(-1); // Decrease the array size by 1.
        System.out.println("Expected : \nCapacity = 3 , Size = 3 , isEmpty = false , isFull = true\n" +
                "Actual : \nCapacity = "+q.getQueueCapacity()+" , Size = "+q.size()+" , isEmpty = "+q.isEmpty()+
                " , isFull = "+q.isFull());

        System.out.println("------------------------");


    }

    private static void testCircularLinkedQueue() {

        CircularLinkedQueue<String> cq = new CircularLinkedQueue<>();

        System.out.println("Test 1:");
        System.out.println("Expected : \nQueue is Empty.\nActual : ");
        try { // Note: This is to test if dequeue from an empty queue is handled.
            System.out.println(cq.dequeue());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("------------------------");

        System.out.println("Test 2:");
        System.out.println("Expected : \nSize = 0 , isEmpty = true , isFull = false\n" +
                "Actual : \nSize = "+cq.size()+" , isEmpty = "+cq.isEmpty()+" , isFull = "+cq.isFull());

        System.out.println("------------------------");

        System.out.println("Test 3:");
        System.out.println("Enqueue Tomato");
        cq.enqueue("Tomato");
        System.out.println("Expected : \nSize: 1\nTomato\nActual : \n"+cq);

        System.out.println("------------------------");

        System.out.println("Test 4:");
        System.out.println("Enqueue Grape");
        cq.enqueue("Grape");
        System.out.println("Expected : \nSize: 2\nTomato\nGrape\nActual : \n"+cq);

        System.out.println("------------------------");

        System.out.println("Test 5:");
        System.out.println("Expected : \nSize = 2 , isEmpty = false , isFull = false\n" +
                "Actual : \nSize = "+cq.size()+" , isEmpty = "+cq.isEmpty()+" , isFull = "+cq.isFull());

        System.out.println("------------------------");

        System.out.println("Test 6:");
        System.out.println("Dequeue");
        cq.dequeue();
        System.out.println("Expected : \nSize: 1\nGrape\nActual : \n"+cq);

        System.out.println("------------------------");

        System.out.println("Test 7:");
        System.out.println("Dequeue");
        cq.dequeue();
        System.out.println("Expected : \nSize: 0\nActual : \n"+cq.toString());

        System.out.println("------------------------");

        System.out.println("Test 8:");
        System.out.println("Expected : \nSize = 0 , isEmpty = true , isFull = false\n" +
                "Actual : \nSize = "+cq.size()+" , isEmpty = "+cq.isEmpty()+" , isFull = "+cq.isFull());

        System.out.println("------------------------");

        System.out.println("Test 9:");
        System.out.println("Enqueue Pineapple");
        cq.enqueue("Pineapple");

        System.out.println("Enqueue Line");
        cq.enqueue("Lime");
        System.out.println("Expected : \nSize: 2\nPineapple\nLime\nActual : \n"+cq);

        System.out.println("------------------------");

    }


}
