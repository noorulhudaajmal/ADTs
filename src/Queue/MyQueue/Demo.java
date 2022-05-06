package Queue.MyQueue;

import Queue.QueueUnderflowException;

public class Demo {
    protected static MyArrayBoundedQueue<String> fruits = new MyArrayBoundedQueue<>(10);
    protected static MyLinkedQueue<String> colors = new MyLinkedQueue<>();

    public static void main(String[] args) {
        runTests();
        getExpectedOutput();
    }

    public static void runTests(){
        System.out.println("MyArrayBoundedQueue:\n******************");
        System.out.println("Test 1: [testing toString()]");
        // 1. Testing toString()
        fruits.enqueue("Apple");
        fruits.enqueue("Orange");
        System.out.println(fruits.toString());
        System.out.println("-----------------------------");

        // 2. Testing space()
        System.out.println("Test 2: [testing space()]");
        System.out.println(fruits.space());
        System.out.println("-----------------------------");

        // 3. Testing remove(count) successful
        System.out.println("Test 3: [testing remove(count)]");
        fruits.enqueue("Lemon");
        fruits.remove(2);
        System.out.println(fruits.toString());
        System.out.println("-----------------------------");

        // 4. Testing remove(count) unsuccessful
        System.out.println("Test 4: [testing remove(count)]");
        try {
            fruits.remove(2);
        } catch (QueueUnderflowException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("-----------------------------");

        // 5. Testing reQueue()
        System.out.println("Test 5: [testing reQueue()]");
        fruits.enqueue("Banana");
        fruits.enqueue("Pineapple");
        fruits.reQueue();
        System.out.println(fruits.toString());
        System.out.println("-----------------------------");

        // 6. Testing reverse()
        System.out.println("Test 6: [testing reverse()]");
        fruits.reverse();
        System.out.println(fruits.toString());
        System.out.println("-----------------------------");

        // 7. Testing clear()
        System.out.println("Test 7: [testing clear()]");
        fruits.clear();
        System.out.println("clean queue? : "+fruits.isEmpty() + "\tSize = "+fruits.size());
        System.out.println("-----------------------------");

        System.out.println("MyLinkedQueue:\n*****************");
        // 8. Testing toString()
        System.out.println("Test 8: [testing toString()]");

        colors.enqueue("Red");
        colors.enqueue("Blue");
        System.out.println(colors.toString());
        System.out.println("-----------------------------");

        // 9. Testing remove(count) successful
        System.out.println("Test 9: [testing remove(count)]");

        colors.enqueue("White");
        colors.remove(2);
        System.out.println(colors.toString());
        System.out.println("-----------------------------");

        // 10. Testing remove() unsuccessful
        System.out.println("Test 10: [testing remove(count)]");
        try {
            colors.remove(2);
        } catch (QueueUnderflowException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("-----------------------------");

        // 11. Testing reQueue()
        System.out.println("Test 11: [testing reQueue()]");

        colors.enqueue("Green");
        colors.enqueue("Purple");
        colors.reQueue();
        System.out.println(colors.toString());
        System.out.println("-----------------------------");

        // 12. Testing reverse()
        System.out.println("Test 12: [testing reverse()]");

        colors.reverse();
        System.out.println(colors.toString());
        System.out.println("-----------------------------");

        // 13. Testing clear()
        System.out.println("Test 13: [testing clear()]");
        colors.clear();
        System.out.println("clean queue? : "+colors.isEmpty() + "\tSize = "+colors.size());
        System.out.println("-----------------------------");
    }

    public static void getExpectedOutput(){
        System.out.println("EXPECTED OUTPUTS:\n****************");
        System.out.println("Test 1 :\nApple\nOrange");
        System.out.println("Test 2 : 8");
        System.out.println("Test 3 : Lemon");
        System.out.println("Test 4 Expect to throw QueueUnderflowException with message of \"Less than 2 elements in queue\".");
        System.out.println("Test 5 :\nBanana\nPineapple\nLemon");
        System.out.println("Test 6 :\nLemon\nPineapple\nBanana");
        System.out.println("Test 7 Expect a clean queue.");
        System.out.println("Test 8 :\nRed\nBlue");
        System.out.println("Test 9 : White");
        System.out.println("Test 10 Expect to throw QueueUnderflowException with message of \"Less than 2 elements in queue\".");
        System.out.println("Test 11 :\nGreen\nPurple\nWhite");
        System.out.println("Test 12 Expect a reverse queue: \nWhite\nPurple\nGreen\n");
        System.out.println("Test 13 Expect a clean queue.\n");
    }

}
