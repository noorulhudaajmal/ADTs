package Stack.SafeStack;

import Stack.LinkedStack;

import java.util.ArrayList;

public class SafeLinkedStack<T> extends LinkedStack<T> implements SafeStackInterface<T>{

    public SafeLinkedStack() {
        super();
    }


    @Override
    public boolean safePush(Object element) {
        // pushes element onto the stack;
        // returns true if element is successfully pushed, false otherwise
        push((T) element);
        if(safeTop().equals(element))
            return true;
        return false;
    }

    @Override
    public boolean safePop() {
        // removes the top element of the stack;
        // returns true if element is successfully popped, false otherwise
        if(!isEmpty()){
            pop();
            return true;
        }
        return false;
    }

    @Override
    public T safeTop() {
        // if the stack is not empty returns the top element of the stack,
        // otherwise returns null
        if(!isEmpty()){
            return top();
        }
        return null;
    }

    @Override
    public int size() {
        // return number of elements in the stack
        ArrayList<T> elements = new ArrayList<>();
        while(safeTop()!=null){
            elements.add(safeTop());
            safePop();
        }
        for(int i=0;i<elements.size();i++){
            safePush(elements.get(i));
        }
        return elements.size();
    }

    @Override
    public String toString() {
        String content = "";
        ArrayList<T> elements = new ArrayList<>();
        while(safeTop()!=null){
            content += safeTop()+"\n";
            elements.add(safeTop());
            safePop();
        }
        for(int i=0;i<elements.size();i++){
            safePush(elements.get(i));
        }
        return content;
    }
}