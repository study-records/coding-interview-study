
public class LinkedListJeon {
    private Node head;
    private Node tail;
    private int size = 0;
    private class Node{
        // 데이터가 저장될 필드
        private Object data;
        // 다음 노드를 가리키는 필드
        private Node next;
        public Node(Object input) {
            this.data = input;
            this.next = null;
        }
        // 노드의 내용을 쉽게 출력해서 확인해볼 수 있는 기능
        public String toString(){
            return String.valueOf(this.data);
        }
    }
    public void addFirst(Object input){
      Node newNode = new Node(input);
      newNode.next = head;
      head = newNode;
      size++;
      if(head.next == null){
        tail = head;
      }
    }
    public void addLast(Object input){
       Node newNode = new Node(input);
       if(size == 0){
           addFirst(input);
       }
      else {
          tail.next = newNode;
          tail = newNode;
          size++;
      }
    }
    public LinkedListJeon reverse(){
      LinkedListJeon reversed = new LinkedListJeon();
      Node node = head;
      while(node!= null){
        reversed.addFirst(node.data);
        node = node.next;
      }
      return reversed;
    }
    public boolean isEqual(LinkedListJeon l){
      Node a = head;
      Node b = l.head;
      while(a!=null && b!=null){
        if(a.data!=b.data)return false;
        a=a.next;
        b=b.next;
      }
      return a==null && b==null;
    }
}
