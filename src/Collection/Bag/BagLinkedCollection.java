package Collection.Bag;

import Collection.LLNode;
import Collection.LinkedCollection;

public class BagLinkedCollection<T> extends LinkedCollection<T> implements BagInterface<T>{

    public BagLinkedCollection() {
        super();
    }

    @Override
    public T grab() {
        // If this bag is not empty, removes and returns a random element of the bag;
        // otherwise returns null.
        if(!isEmpty()){
            LLNode<T> current = head;
            int rand_int = (int)Math.floor(Math.random()*(size()-0+1));
            for(int i=0; i<rand_int-1 ;i++ ){
                current = current.getLink();
            }
            T objToReturn = current.getInfo();
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
            LLNode current = head;
            while(current != null){
                if(current.getInfo().equals(target)){
                    count++;
                }
                current = current.getLink();
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
        head = null;
        numElements = 0;
    }

    @Override
    public String toString() {
        String content = "";
        LLNode<T> current =head;
        for(int i =0 ; i< size() ; i++){
            content+=current.getInfo()+"\n";
            current = current.getLink();
        }
        return content;
    }

}
