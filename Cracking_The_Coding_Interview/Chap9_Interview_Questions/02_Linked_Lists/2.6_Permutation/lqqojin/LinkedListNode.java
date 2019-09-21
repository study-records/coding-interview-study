package src;
public class LinkedListNode {
    boolean isPalindrome(LinkedListNode head) {
        LinkedListNode reversed = resverseAndClone(head);
        return isEqual(head, reserved);
    };

    LinkedListNode resverseAndClone(LinkedListNode node) {
        LinkedListNode head =null;
        while (node != null) {
            LinkedListNode n = new LinkedListNode(node.data);
            n.next =head;
            head = n;
            node = node.next;
        }
        return head;
    }

    boolean isEqual(LinkedListNode one, LinkedListNode two) {
        while ( one != null && two != null ) {
            if (one.data != two.data) {
                return false;
            }
            one = one.next;
            two = two.next;
        }
        return one == null && two == null;
    }


}

