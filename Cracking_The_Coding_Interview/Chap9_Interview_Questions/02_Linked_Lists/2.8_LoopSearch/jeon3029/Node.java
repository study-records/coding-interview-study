
public class Node{
    public Object data;
    public Node next;
    public Node(Object input) {
        this.data = input;
        this.next = null;
    }
    public Node findBeginning(Node head){
      Node fast=head;
      Node slow=head;
      fast=fast.next.next;
      slow=slow.next;
      while(fast!=slow){
        fast=fast.next.next;
        slow=slow.next;
      }
      slow=head;
      while(fast!=slow){
        fast=fast.next;
        slow=slow.next;
      }
      return fast;
    }
}
