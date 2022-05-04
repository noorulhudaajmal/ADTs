package Stack.ModifiedStack;

import Stack.ArrayBoundedStack;
import Stack.StackUnderflowException;

public class ArrayBoundedStack2<T> extends ArrayBoundedStack<T> implements StackInterface2<T>{

    public ArrayBoundedStack2() {
    }

    public ArrayBoundedStack2(int maxSize) {
        super(maxSize);
    }


    @Override
    public String toSting() {
        //returns a string that correctly represents the current stack.
        String stack = "Size : " + size() + "\n";
        int size = size()-1;
        for (int i=0; i<size() ; i++){
            stack += elements[size--].toString() + "\n";
        }
//        for(T element : elements){
//
//            if(element==null){
//                break;
//            }
//            stack += element.toString()+"\n";
//        }
        return stack;
    }

    @Override
    public int size(){
        //returns a count of how many elements are currently on the stack
        int size = 0;

        for(int i=0;i<elements.length;i++)
        {
            if(elements[size] != null){
                size++;
            }
            else{
                break;
            }
        }
        return size;
    }

    @Override
    public void popSome(int count) throws StackUnderflowException{
        //removes the top count elements from the stack
        if(count>size()){
            throw new StackUnderflowException("count(Pop) attempted on a low-sized stack.");
        }
        else{
            for(int i=0;i<count;i++){
                elements[topIndex] = null;
                topIndex--;
            }
        }
    }

    @Override
    public boolean swapStart(){
        //reverses the order of top two elements on the stack
        if(size()<2){
            return false;
        }
        else{
            T top_element = elements[topIndex];
            elements[topIndex] = elements[topIndex-1];
            elements[topIndex-1] = top_element;
            return true;
        }
    }

    @Override
    public T poptop() throws StackUnderflowException{
        //removes and returns the top element of the stack
        if(isEmpty()){
            throw new StackUnderflowException("Pop attempted on an empty stack.");
        }
        else{
//            return elements[topIndex];
//            topIndex--;
            T top_element = top();
            pop();
            return top_element;
        }
    }
}