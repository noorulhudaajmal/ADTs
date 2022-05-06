package Collection.Bag;

import Collection.CollectionInterface;

@SuppressWarnings("rawtypes")
public interface BagInterface<T> extends CollectionInterface<T> {
    T grab();
    // If this bag is not empty, removes and returns a random element of the bag;
    // otherwise returns null.

    int count(T target);
    // Returns a count of all elements e in this collection such that
    // e.equals(target).

    int removeAll(T target);
    // Removes all elCollements e from this collection such that e.equals(target)
    // and returns the number of elements removed.

    void clear();
    // Empties this bag so that it contains zero elements.
}