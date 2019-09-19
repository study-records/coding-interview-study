//Q8. 순환연결리스트가 주어졌을 때 순환되는 첫번째 노드를 반환하라
//EX) a->b->c->d->e->c(front c)
//fast runner and slow runner
//fast runner : 2t
//slow runner : t
//when they meet : fast runner at : loop size
// slow runner goes to head
// same running
//when they meet : loop point!

public class Solution{
    public static void main(String[] args) {
        //Assume string is all ASCII code
        Node a = new Node('a');
        Node b = new Node('b');
        Node c = new Node('c');
        Node d = new Node('d');
        Node e = new Node('e');
        a.next = b;b.next =c;c.next=d;d.next=e;e.next=c;
        Node loop = a.findBeginning(a);
        System.out.println(loop.data);
    }
}
