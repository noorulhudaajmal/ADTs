package Stack;

public class ArrayBoundedStack<T> implements StackInterface<T> {
    protected final int DEFCAP = 100; // default capacity
    protected T[] elements; // holds stack elements
    protected int topIndex = -1; // index of top element in stack

    @SuppressWarnings("unchecked")
    public ArrayBoundedStack() {
        elements = (T[]) new Object[DEFCAP];
    }

    @SuppressWarnings("unchecked")
    public ArrayBoundedStack(int maxSize) {
        elements = (T[]) new Object[maxSize];
    }

    // Throws StackOverflowException if this stack is full,
    // otherwise places element at the top of this stack.
    public void push(T element) {
        if (isFull())
            throw new StackOverflowException("Push attempted on a full stack.");
        else {
            topIndex++;
            elements[topIndex] = element;
        }
    }

    // Throws StackUnderflowException if this stack is empty,
    // otherwise removes top element from this stack.
    public void pop() {
        if (isEmpty())
            throw new StackUnderflowException("Pop attempted on an empty stack.");
        else {
            elements[topIndex] = null;
            topIndex--;
        }
    }

    // Throws StackUnderflowException if this stack is empty,
    // otherwise returns top element of this stack.
    public T top() {
        T topOfStack = null;

        if (isEmpty())
            throw new StackUnderflowException("Top attempted on an empty stack.");
        else
            topOfStack = elements[topIndex];

        return topOfStack;
    }

    public boolean isEmpty() {     // Returns true if this stack is empty, otherwise returns false.

        return (topIndex == -1);
    }

    public boolean isFull() { // Returns true if this stack is full, otherwise returns false.
        return (topIndex == (elements.length - 1));
    }

}