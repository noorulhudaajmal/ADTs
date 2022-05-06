package Queue.MyQueue;

import Queue.ArrayBoundedQueue;
import Queue.QueueUnderflowException;
import Stack.LinkedStack;

public class MyArrayBoundedQueue<T> extends ArrayBoundedQueue<T> implements MyQueueInterface<T> {

    public MyArrayBoundedQueue() {
        super();
    }

    public MyArrayBoundedQueue(int maxSize) {
        super(maxSize);
    }

    public int space() {
        // Returns an integer indicating how many empty spaces remain in the queue.
        return elements.length - numElements;
    }

    @java.lang.Override
    public String toString() {
        // Creates and returns a string that correctly represents the current queue.
        // Such a method could prove useful for testing and debugging the class and
        // for testing and debugging applications that use the class.
        StringBuilder content = new StringBuilder();
        for(int i=front ; i<=rear;i++){
            content.append((String) elements[i]).append("\n");
        }
        return content.toString();
    }

    @java.lang.Override
    public void remove(int count) throws QueueUnderflowException {
        // Removes the front count elements from the queue.
        // Throw QueueUnderflowException with message of "Less than count elements in
        // queue." if there are less than count elements in the queue.
        if(count > numElements){
            throw new QueueUnderflowException("Less than "+count+" elements in queue.");
        }
        else{
            for(int i = 0;i<count ; i++){
                dequeue();
            }
        }

    }

    @java.lang.Override
    public void reQueue() {
        // Dequeue an element from front, and enqueue the element back to rear of the queue.
        // Throw QueueUnderflowException with message of "No element in queue."
        // if there is no element in the queue.
        if(isEmpty()){
            throw new QueueUnderflowException("No element in queue.");
        }
        else{
            enqueue(dequeue());
        }
    }

    @java.lang.Override
    public void clear() {
        while (!isEmpty()){
            dequeue();
        }
    }

    @java.lang.Override
    public void reverse() {
        // Reverse queue content.  Hint: you may use LinkedStack ADT.
        LinkedStack<T> stack = new LinkedStack<>();
        while (!isEmpty()) {
            stack.push(elements[front]);
            dequeue();
        }
        while (!stack.isEmpty()) {
            enqueue(stack.top());
            stack.pop();
        }
    }
}
