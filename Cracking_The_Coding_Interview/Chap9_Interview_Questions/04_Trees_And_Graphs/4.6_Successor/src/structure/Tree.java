package structure;

public class Tree {
    public static class Node{
        public Node left;
        public Node right;
        public Node parent;
        public int val;

        public Node(int k){
            this.val = k;
        }
    }
    public Node root;
}
