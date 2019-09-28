import org.junit.*;

import java.util.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.*;

public class SortStackTest {
    SortStack sortStack;

    @Before
    public void setUp() throws Exception {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(7);
        stack.push(51);
        stack.push(10);
        stack.push(12);
        stack.push(4);
        sortStack = new SortStack(stack);
    }

    @Test
    public void peek() {
        assertThat(sortStack.peek(), equalTo(1));
    }

    @Test
    public void push() {
        sortStack.push(15);
        assertThat(sortStack.peek(), equalTo(1));
        sortStack.push(-1);
        assertThat(sortStack.peek(), equalTo(-1));
        sortStack.push(18);
        assertThat(sortStack.peek(), equalTo(-1));
        sortStack.pop();
        assertThat(sortStack.peek(), equalTo(1));
        sortStack.pop();
        assertThat(sortStack.peek(), equalTo(4));
    }

    @Test
    public void pop() {
        assertThat(sortStack.pop(), equalTo(1));
        assertThat(sortStack.pop(), equalTo(4));
        assertThat(sortStack.pop(), equalTo(7));
        assertThat(sortStack.pop(), equalTo(10));
        assertThat(sortStack.pop(), equalTo(12));
        assertThat(sortStack.pop(), equalTo(51));
    }

    @Test
    public void isEmpty() {
        assertThat(sortStack.isEmpty(), equalTo(false));
    }
}