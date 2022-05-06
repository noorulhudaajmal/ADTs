package List;

public class SinglyLinkedList {

    // the data fields: first, last, count
    protected Node first, last;
    protected int count;

    // the constructor
    public SinglyLinkedList() {
        first = last = null;
        count = 0;
    }

    // the method initializes the list to the empty state.
    public void initializer() {
        first = last = null;
        count = 0;
    }

    // the method determines if the list is empty or not.
    public boolean isEmpty() {
        return first == null; // last == null; // count == 0
    }

    // the method returns the number of items stored in the list.
    public int length() {           //size()
        return count;
    }

    // the method prints the elements of the list.
    public void print() {
        Node current = first;
        while (current != null) {
            System.out.print(current.info + " ");
            current = current.link;
        }
    }

    // the method searches the list for a given item.
    public boolean search(int searchInfo) { // 1, 5, 3, 2 | searchInfo = 5  ---> true | searchInfo = 6  ---> false
        Node current = first;
        while (current != null) {
            if (current.info == searchInfo) {
                return true;
            }
            current = current.link;
        }
        return false;
    }

    // the method returns the item stored in the first node.
    public int first() throws IllegalStateException { // 1, 5, 3, 2   ---> 1
        if (isEmpty()) {
            throw new IllegalStateException("The list is empty");
        } else {
            return first.info;
        }
    }

    // the method returns the item stored in the last node.
    public int last() throws IllegalStateException { // 1, 5, 3, 2   ---> 2
        if (isEmpty()) {
            throw new IllegalStateException("The list is empty");
        } else {
            return last.info;
        }
    }

    // the method inserts a new item at the beginning of the list.
    public void insertFirst(int newInfo) { // 1, 5, 3, 2  | newInfo = 8 ---> 8, 1, 5, 3, 2
        Node node = new Node(newInfo);
        if (isEmpty()) {
            first = last = node;
        } else {
            node.link = first;
            first = node;
        }
        count++;
    }

    // the method inserts a new item at the end of the list.
    public void insertLast(int newInfo) {  // 1, 5, 3, 2  | newInfo = 8 ---> 1, 5, 3, 2, 8
        Node node = new Node(newInfo);
        if (isEmpty()) {
            first = last = node;
        } else {
            last.link = node;
            last = node;
        }
        count++;
    }

    // the method deletes the first node in the list.
    public void deleteFirst() { // 1, 5, 3, 2  ---> 5, 3, 2
        if (!isEmpty()) {
            first = first.link;
            count--;
            if (first == null) {
                last = null;
            }
        }
    }

    // the method deletes last node in the list.
    public void deleteLast() {  // 1, 5, 3, 2  ---> 1, 5, 3
        if (!isEmpty()) {
            if (length() == 1) { // first == last
                first = last = null;
            } else {
                Node current = first;
                while (current.link != last) {
                    current = current.link;
                }
                current.link = null;
                last = current;
            }
            count--;
        }
    }

    // the method deletes an occurrence of the item deleteInfo from the list.
    public void delete(int deleteInfo) { // 1, 3, 4, 6, 9 |  deleteInfo = 6 ---> 1, 3, 4, 9
        if (isEmpty()) {
            System.err.println("The list is empty; you cannot remove deleteInfo!");
        } else {
            if (first.info == deleteInfo) {
                deleteFirst();
            } else {
                Node previous = first;
                Node current = first.link;
                boolean found = false;
                while (current != null && !found) { // current.info != deleteInfo
                    if (current.info == deleteInfo) {
                        found = true;
                    } else {
                        previous = current;
                        current = current.link;
                    }
                }
                if (found) { // current != null
                    previous.link = current.link;
                    count--;
                    if (current == last) {
                        last = previous;
                    }
                }
            }
        }
    }

    // the helper method: makes an identical copy of a given list.
    private void copy(SinglyLinkedList otherList) {
        this.initializer();
        if (!otherList.isEmpty()) {
            this.count = otherList.count;
            Node currentInOtherList = otherList.first;
            this.first = this.last = new Node(currentInOtherList.info);
            currentInOtherList = currentInOtherList.link;
            while (currentInOtherList != null) {
                Node node = new Node(currentInOtherList.info);
                this.last.link = node;
                this.last = node;
                currentInOtherList = currentInOtherList.link;
            }
        }
    }

    // the method makes an identical copy of a given list.
    public void copyList(SinglyLinkedList otherList) {
        if (this != otherList) {
            copy(otherList);
        }
    }

    // the copy constructor: makes an identical copy of a given list.
    public SinglyLinkedList(SinglyLinkedList otherList) {
        copy(otherList);
    }

    // the method makes a deep copy of itself.
    public SinglyLinkedList deepCopy() {
        SinglyLinkedList copySinglyLinkedList = new SinglyLinkedList();
        if (!this.isEmpty()) {
            Node current = this.first;
            while (current != null) {
                copySinglyLinkedList.insertLast(current.info);
                current = current.link;
            }
        }
        return copySinglyLinkedList;
    }

    public boolean equal(SinglyLinkedList otherlist) {
        Node l1 = this.first;
        Node l2 = otherlist.first;
        if (this.count == otherlist.count) {
            while (l1 != null) {
                if (l1.getInfo() != l2.getInfo()) {
                    return false;
                }
                l1 = l1.link;
                l2 = l2.link;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println("Demo");
        SinglyLinkedList l1 = new SinglyLinkedList();
        l1.insertFirst(12);
        l1.insertFirst(13);
        l1.insertFirst(1);
        l1.insertFirst(0);
        SinglyLinkedList l2 = new SinglyLinkedList();
        l2.insertFirst(12);
        l2.insertFirst(1);
        l2.insertFirst(1);
        l2.insertFirst(0);
        System.out.println(l1.equal(l2));

    }
}
