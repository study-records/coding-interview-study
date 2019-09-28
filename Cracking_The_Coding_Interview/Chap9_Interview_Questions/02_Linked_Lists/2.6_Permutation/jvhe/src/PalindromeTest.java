import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class PalindromeTest {

    @org.junit.Test
    public void solution() {

        Node node1 = new Node(1);
        node1.appendToTail(2);
        node1.appendToTail(3);
        node1.appendToTail(2);
        node1.appendToTail(1);

        Node node2 = new Node(2);
        node2.appendToTail(3);
        node2.appendToTail(3);
        node2.appendToTail(2);

        Node node3 = new Node(1);
        node3.appendToTail(12);
        node3.appendToTail(12);
        node3.appendToTail(12);

        assertThat(Palindrome.solution(null), equalTo(false));
        assertThat(Palindrome.solution(new Node(3)), equalTo(true));
        assertThat(Palindrome.solution(node1), equalTo(true));
        assertThat(Palindrome.solution(node2), equalTo(true));
        assertThat(Palindrome.solution(node3), equalTo(false));
    }
}