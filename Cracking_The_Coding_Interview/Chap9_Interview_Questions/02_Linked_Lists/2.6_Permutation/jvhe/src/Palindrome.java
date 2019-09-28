import java.util.*;

public class Palindrome {
    public static boolean solution(Node head) {
        if (head == null) return false;
        if (head.next == null) return true;

        Stack<Node> stack = new Stack<>();

        Node fastRunner = head.next;
        Node slowRunner = head;

        stack.push(slowRunner);
        while (fastRunner.next != null && fastRunner.next.next != null) {
            fastRunner = fastRunner.next.next;
            slowRunner = slowRunner.next;
            stack.push(slowRunner);
        }

        if (fastRunner.next != null) {
            slowRunner = slowRunner.next;
        }
        while (!stack.empty()) {
            if(slowRunner.next == null) return false;
            slowRunner = slowRunner.next;
            if (stack.pop().data != slowRunner.data) {
                return false;
            }
        }

        return true;
    }
}
