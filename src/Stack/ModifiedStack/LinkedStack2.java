package Stack.ModifiedStack;

import Stack.LLNode;
import Stack.LinkedStack;
import Stack.StackOverflowException;
import Stack.StackUnderflowException;

public class LinkedStack2<T> extends LinkedStack<T> implements StackInterface2<T> {

    @Override
    public String toSting(){
        String stack = "Size : " + size() + "\n";
        if(isEmpty()){
            return stack;
        }
        else {
            LLNode<T> node = top;
            stack += node.getInfo()+"\n";
            while (node.getLink()!=null){
                node = node.getLink();
                stack += node.getInfo() +"\n";
            }
        }
        return stack;
    }

    @Override
    public int size() {
        int size = 0;
        if(!isEmpty()){
            LLNode<T> node = top;
            size++;
            while(node.getLink()!=null){
                node = node.getLink();
                size++;
            }
        }
        return size;
    }

    @Override
    public void popSome(int count) throws StackUnderflowException {
        if(count>size()){
            throw new StackUnderflowException("popSome attempted on low-sized Stack.");
        }
        else if(count==1){
            pop();
        }
        else{
            LLNode<T> node = top;
            for(int i=0;i<count;i++) {
                node = top.getLink();
            }
            top = node;
        }
    }

    @Override
    public boolean swapStart() {
        if(size()<2){
            return false;
        }
        else{
            LLNode<T> node0 = top;
            LLNode<T> node1 = top.getLink();
            node0.setLink(node1.getLink()) ;
            node1.setLink(node0);
            top = node1;
            return true;
        }
    }

    @Override
    public T poptop() throws StackOverflowException {
        //removes and returns the top element of the stack
        if(isEmpty()){
            throw new StackUnderflowException("Pop attempted on an empty stack.");
        }
        else{
            LLNode<T> node = top;
            top = node.getLink();
            return node.getInfo();
        }
    }
}
