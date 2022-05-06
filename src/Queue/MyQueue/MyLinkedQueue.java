package Queue.MyQueue;

import Queue.LLNode;
import Queue.LinkedQueue;
import Queue.QueueUnderflowException;
import Stack.LinkedStack;

public class MyLinkedQueue<T> extends LinkedQueue<T> implements MyQueueInterface<T> {

    public MyLinkedQueue() {
        super();
    }

    public String toString() {
        // Creates and returns a string that correctly represents the current queue.
        // Such a method could prove useful for testing and debugging the class and
        // for testing and debugging applications that use the class.
        String content = "";
        LLNode<T> current = front;
        for(int i =0 ; i<numElements ; i++){
            content+=current.getInfo()+"\n";
            current = current.getLink();
        }
        return content;
    }

    @Override
    public void remove(int count) {
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

    @Override
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

    @Override
    public void clear() {
        while (!isEmpty()){
            dequeue();
        }
    }

    @Override
    public void reverse() {
        // Reverse queue content.  Hint: you may use LinkedStack ADT.
        LinkedStack<T> stack = new LinkedStack<>();
        while (!isEmpty()) {
            stack.push(front.getInfo());
            dequeue();
        }
        while (!stack.isEmpty()) {
            enqueue(stack.top());
            stack.pop();
        }
    }

}
