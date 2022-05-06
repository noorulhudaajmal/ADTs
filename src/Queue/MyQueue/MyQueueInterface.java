package Queue.MyQueue;

import Queue.QueueInterface;

public interface MyQueueInterface<T> extends QueueInterface<T> {
    public String toString();
    // Creates and returns a string that correctly represents the current queue.
    // Such a method could prove useful for testing and debugging the class and
    // for testing and debugging applications that use the class.

    public void remove(int count);
    // Removes the front count elements from the queue.
    // Throw QueueUnderflowException with message of "Less than count elements in
    // queue." if there are less than count elements in the queue.

    public void reQueue();
    // Dequeue an element from front, and enqueue the element back to rear of the queue.
    // Throw QueueUnderflowException with message of "No element in queue."
    // if there is no element in the queue.

    public void clear();
    // Clear entire queue.

    public void reverse();
    // Reverse queue content.  Hint: you may use LinkedStack ADT.
}
