import java.util.*;

public class SetOfStacks<T> {
    private final int stackCapacity;
    private int currentStackSize;
    private ArrayList<Stack<T>> stacks;

    public SetOfStacks(int _stackSize) {
        if (_stackSize < 1) _stackSize = 1;
        stackCapacity = _stackSize;
        currentStackSize = 0;
        stacks = new ArrayList<Stack<T>>();
        Stack<T> stack = new Stack<>();
        stacks.add(stack);
    }

    public void push(T item) {
        if (item == null) return;
        if (currentStackSize == stackCapacity) {
            Stack<T> stack = new Stack<>();
            stacks.add(stack);
            currentStackSize = 0;
        }

        stacks.get(stacks.size() - 1).push(item);
        currentStackSize++;
    }

    private boolean _empty;

    public boolean empty() {
        return stacks.get(0).empty();
    }

    public T pop() {
        T output;
        if (currentStackSize > 0) {
            currentStackSize--;
            output = stacks.get(stacks.size() - 1).pop();

            if (currentStackSize == 0) {
                if (stacks.size() - 1 > 0){
                    stacks.remove(stacks.size()-1);
                    currentStackSize = stackCapacity;
                }
            }

            return output;
        } else {
            return null;
        }
    }

    public T peek() {
        if (!stacks.get(stacks.size() - 1).empty()) {
            return stacks.get(stacks.size() - 1).peek();
        } else {
            if (stacks.size() - 2 < 0) return null;
            else {
                stacks.remove(stacks.size() - 1);
                currentStackSize = stackCapacity;
                return stacks.get(stacks.size() - 1).peek();
            }
        }
    }

}
