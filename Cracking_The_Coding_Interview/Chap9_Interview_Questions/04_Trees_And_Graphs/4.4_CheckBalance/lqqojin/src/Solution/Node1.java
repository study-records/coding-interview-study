package Solution;

public class Node1 {
    Node1 left;
    Object data;
    Node1 right;

    public Node1(Object data) {
        left =null;
        right =null;
        this.data = data;
    }

    public Object getData(){
        return this.data;
    }
}
