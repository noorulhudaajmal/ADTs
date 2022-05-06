package Collection.Bag;

import Collection.SortedArrayCollection;

public class BagSortedArrayCollection<T> extends SortedArrayCollection<T> implements BagInterface<T>{

    public BagSortedArrayCollection() {
        super();
    }

    public BagSortedArrayCollection(int capacity) {
        super(capacity);
    }

    @Override
    public T grab() {
        // If this bag is not empty, removes and returns a random element of the bag;
        // otherwise returns null.
        if(!isEmpty()){
            int rand_int = (int)Math.floor(Math.random()*(size()-0+1));
            T objToReturn = elements[rand_int];
            remove(objToReturn);
            return objToReturn;
        }
        return null;
    }

    @Override
    public int count(T target) {
        // Returns a count of all elements e in this collection such that
        // e.equals(target).
        if(!isEmpty()){
            int count = 0;
            int i=0;
            while(elements[i] != null){
                if(elements[i].equals(target)){
                    count++;
                }
                i++;
            }
            return count;
        }
        return 0;
    }

    @Override
    public int removeAll(T target) {
        // Removes all elements e from this collection such that e.equals(target)
        // and returns the number of elements removed.
        if(!isEmpty()){
            int no_of_Elements = count(target);
            for(int i=0;i<no_of_Elements;i++){
                remove(target);
            }
            return no_of_Elements;
        }
        return 0;
    }

    @Override
    public void clear() {
        // Empties this bag so that it contains zero elements.
        int iter = numElements;
        while(size()!=0){
            remove(elements[iter]);
            iter--;
        }
    }

    @Override
    public String toString() {
        String content = "";
        if(!isEmpty()) {
            for (int i = 0; i < size(); i++) {
                content += elements[i] + "\n";
            }
        }
        return content;
    }
}
