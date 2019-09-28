import java.util.*;

public class SortStack {
    private Stack<Integer> stack;
    private Stack<Integer> extraStack;
    public SortStack(Stack<Integer> _stack) {
        extraStack = new Stack<>();
        stack = _stack;
        sort();
    }

    public Integer peek() {
        sort();
        return stack.peek();
    }

    public void push(int data) {
        if(data > stack.peek()){
            int temp = stack.pop();
            stack.push(data);
            stack.push(temp);
        } else {
            stack.push(data);
        }
    }

    public Integer pop() {
        sort();
        return stack.pop();
    }

    public boolean isEmpty() {
        return stack.empty();
    }

    private void sort() {
        int minValue = stack.pop();
        while (!stack.empty()) {
            if (minValue > stack.peek()) {
                extraStack.push(minValue);
                minValue = stack.pop();
            } else {
                extraStack.push(stack.pop());
            }
        }
//        System.out.println("Stack Value -----");
        while (!extraStack.empty()) {
            stack.push(extraStack.pop());
//            System.out.println(stack.peek());
        }
        stack.push(minValue);
//        System.out.println(stack.peek());
    }
}
