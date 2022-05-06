package Queue;

public class FixedFrontArrayQueue<T> implements QueueInterface{
    private static int CAPACITY ;//= 100;
    private T[] elements;
    private int frontIndex;
    private int rearIndex;
    int numOfElements;

    // Implement following methods:
    // Default constructor to initialize array capacity with CAPACITY

    public FixedFrontArrayQueue() {
        CAPACITY = 100;
        this.elements = (T[]) new Object[CAPACITY];
        this.frontIndex = 0;
        this.rearIndex = 0;
        numOfElements = 0;
    }

    // Constructor to initialize array capacity with 'size'
    public FixedFrontArrayQueue(int size) {
        this.elements = (T[])new Object[size];
        this.frontIndex = 0;
        this.rearIndex = 0;
        CAPACITY = size;
        numOfElements = 0;
    }

    // Dequeue info from array. Throw QueueUnderflowException if array is empty
    public T dequeue() throws QueueUnderflowException{
        if (isEmpty()) {
            throw new QueueUnderflowException("Queue is Empty");
        }
        else{
            T element = this.elements[this.frontIndex];
            this.elements[frontIndex] = null;
            this.frontIndex++;
            numOfElements--;
            if (frontIndex == elements.length) {
                frontIndex = 0;
            }
            return element;
        }
    }

    public void enqueue(Object info) throws QueueOverflowException{
        // check queue is full or not
        if (isFull()) {
            throw new QueueOverflowException("Queue is Full");
        }
        // insert element at the rear
        else {
            this.elements[rearIndex] = (T)info;
            rearIndex++;
            numOfElements++;
        }
        if (rearIndex == elements.length) {
            rearIndex = 0;
        }
        return;
    }


    // Return true if the array is empty; otherwise return false
    public boolean isEmpty(){
        return this.size() == 0;
    }
    // Return true if the array is full; otherwise return false
    public boolean isFull(){
        return this.size() == CAPACITY;
    }
    // Return number of elements
    public int size(){
        return numOfElements;
    }
    // Adjust elements array capacity with 'size' more or 'size' less elements

    public void resize(int s){
        if(s>0) {
            assert s >= size();
            T[] copy = (T[]) new Object[s + size()];
            for (int i = 0; i < size(); i++) {
                copy[i] = elements[(frontIndex+i)%this.size()];
            }
            CAPACITY = s + this.size();
            this.elements = copy.clone();
            frontIndex = 0;
            rearIndex  = size();
        }
        else{
            CAPACITY = CAPACITY + s;
        }
    }

    // .toString() method that returns a string that correctly represents the
    // current stack.
    public String toString(){
        String stack = "Size: "+this.size();
        if(size()>=1){
            for (int i = 0; i < this.size(); i++) {
                stack += "\n" + this.elements[i+this.frontIndex];
            }
        }
        stack += "\n";
        return stack;
    }
    // Return array capacity of the queue
    public int getQueueCapacity(){
        return CAPACITY;
    }

}
