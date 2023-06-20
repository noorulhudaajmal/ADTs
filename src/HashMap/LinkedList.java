import java.util.Iterator;

public class LinkedList<T> implements Iterable<T> {
    private LLNode<T> head;
    private LLNode<T> tail;
    private int size;

    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public void addLast(T element) {
        LLNode<T> newNode = new LLNode<>(element);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setLink(newNode);
            tail = newNode;
        }

        size++;
    }

    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T> {
        private LLNode<T> current;

        public LinkedListIterator() {
            current = head;
        }

        public boolean hasNext() {
            return current != null;
        }

        public T next() {
            if (!hasNext())
                throw new IndexOutOfBoundsException("No more elements in the iteration.");

            T data = current.getInfo();
            current = current.getLink();
            return data;
        }

        public void remove() {
            throw new UnsupportedOperationException("Unsupported remove attempted on LinkedListIterator.");
        }
    }
}
