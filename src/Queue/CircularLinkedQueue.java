package Queue;

public class CircularLinkedQueue<T> implements QueueInterface {
    protected LLNode<T> rear; // reference to the rear of this queue
    protected LLNode<T> front;

    // Implement following 7 methods:
    // Constructor

    public CircularLinkedQueue(LLNode<T> rear, LLNode<T> front) {
        this.rear = rear;
        this.front = front;
    }

    public CircularLinkedQueue() {
        this.front = null;
        this.rear = null;
    }

    // Adds element to the rear of this queue.
    // enqueue(T element)
    public void enqueue(Object element) throws QueueOverflowException{
        if(isFull()){
            throw new QueueOverflowException("Queue is Full.");
        }
        LLNode<T> temp = new LLNode<T>((T)element);
        if (front == null){
            front = temp;
        }
        else {
            rear.setLink(temp);
        }
        rear = temp;
        rear.setLink(front);
    }

    // Throws QueueUnderflowException if this queue is empty;
    // otherwise, removes front element from this queue and returns it.
    // dequeue()

    public T dequeue() throws  QueueUnderflowException{
        if (isEmpty()) {
            throw new QueueUnderflowException("Queue is Empty.");
        }
        // If this is the last node to be deleted
        T value; // Value to be dequeued
        if (front == rear) {
            value = front.getInfo();
            front = null;
            rear = null;
        }
        else {
            LLNode<T> temp = front;
            value = temp.getInfo();
            front = front.getLink();
            rear.setLink(front);
        }
        return value;
    }

    // Returns a string that correctly represents the current stack.
    // toString()
    public String toString(){
        String stack = "Size: "+this.size();
        if(isEmpty()){
            return stack;
        }
        stack+="\n";
        LLNode<T> temp = front;
        while (temp.getLink() != front) {
            stack += temp.getInfo()+"\n";
            temp = temp.getLink();
        }
        return stack+temp.getInfo()+"\n";
    }

    // Returns true if this queue is empty; otherwise, returns false.
    // isEmpty()

    public boolean isEmpty(){
        return front == null;
    }

    // Returns false - a linked queue is never full.
    // isFull()
    public boolean isFull(){
        return 1==3 ;
    }

    // Returns the number of elements in this queue.
    // size()

    public int size(){
        if(isEmpty()){
            return 0;
        }
        LLNode<T> temp = front;
        int size = 0;
        while (temp.getLink() != front) {
            size++;
            temp = temp.getLink();
        }
        size+=1;
        return size;
    }

}