package Stack.ModifiedStack;

import Stack.StackInterface;
import Stack.StackOverflowException;
import Stack.StackUnderflowException;

public interface StackInterface2<T> extends StackInterface<T> {
    String toString();
    // Creates and returns a string that correctly represents the current stack.

    String toSting();

    int size();
    // Returns a count of how many items are currently on the stack.

    void popSome(int count) throws StackUnderflowException;
    // Removes the top count elements from the stack.
    // Throws StackUnderflowException if there are less than count elements on the stack.

    boolean swapStart();
    // Returns false if there are less than two elements on the stack;
    // otherwise, returns true and reverses the order of the top two elements on the stack.

    T poptop() throws StackOverflowException;
    // Removes and returns the top element of the stack if the stack is not empty;
    // otherwise, throws StackUnderflowException.
}