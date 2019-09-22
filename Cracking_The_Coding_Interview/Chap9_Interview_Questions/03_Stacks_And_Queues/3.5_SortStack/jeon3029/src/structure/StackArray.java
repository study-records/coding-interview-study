package structure;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class StackArray <T> implements Stack<T>{
    private int maxSize;
    ArrayList<Object[]> stacks = new ArrayList<>(); //stack 1, stack 2, stack 3...
    private int i=-1; //i th stack
    private Object[] array;
    private int top;

    public StackArray(int maxSize) {
        this.maxSize = maxSize;
//        @SuppressWarnings("unchecked")
        //this.array = (T[]) Array.newInstance(StackArray.class, maxSize);
        this.array = new Object[maxSize];
        this.stacks.add(array);
        i++;
        this.top = -1;
    }

    private Object[] newStack() {
        /**
         * create a new array double the size of the old, copy the old elements then return the new array */
        Object[] newArr = new Object[maxSize];
        this.top = -1;
        this.stacks.add(newArr);
        i++;
        return newArr;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize-1;
    }

    public void push(T element) {
        if(!this.isFull()) {
            ++top;
            array[top] = element;
        }
        else {
            array = newStack();
            array[++top] = element;
        }
    }

    public T pop() {
        if(!this.isEmpty()){
            if(i>0 && top==0){
                T ret = (T)array[top];
                i--;
                array = stacks.get(i);
                top = maxSize-1;
                return ret;
            }
            return (T)array[top--];
        }
        throw new EmptyStackException();
    }

    public T peek() {
        return (T)array[top];
    }
}
