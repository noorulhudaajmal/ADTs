package Stack.SafeStack;

import Stack.StackInterface;

public interface SafeStackInterface<T> extends StackInterface<T> {
    boolean safePush(T element);
    // pushes element onto the stack;
    // returns true if element is successfully pushed, false otherwise

    boolean safePop();
    // removes the top element of the stack;
    // returns true if element is successfully popped, false otherwise

    T safeTop();
    // if the stack is not empty returns the top element of the stack,
    // otherwise returns null

    String toString();
    // returns contents of the stack as a single String

    int size();
    // return number of elements in the stack
}