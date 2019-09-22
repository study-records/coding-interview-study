package structure;

public class BinaryTree{
    public Node root;

    public boolean isBalance() {
        return checkHeight(root)!=Integer.MIN_VALUE;
    }

    private int checkHeight(Node root) {
        if(root ==null) return -1;
        int leftHeight = checkHeight(root.left);
        if(leftHeight==Integer.MIN_VALUE)return Integer.MIN_VALUE;

        int rightHeight = checkHeight(root.right);
        if(rightHeight==Integer.MIN_VALUE)return Integer.MIN_VALUE;

        int diff = leftHeight-rightHeight;
        if(Math.abs(diff)>1){
            return Integer.MIN_VALUE;
        }else{
            return Math.max(leftHeight,rightHeight)+1;
        }
    }

    class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            right = null;
            left = null;
        }
    }

    private Node addRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }

        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        } else {
            // value already exists
            return current;
        }

        return current;
    }
    private Node deleteRecursive(Node current, int value) {
        if (current == null) {
            return null;
        }

        if (value == current.value) {
            // Node to delete found
            // ... code to delete the node will go here
        }
        if (value < current.value) {
            current.left = deleteRecursive(current.left, value);
            return current;
        }
        current.right = deleteRecursive(current.right, value);
        return current;
    }
    public void add(int value) {
        root = addRecursive(root, value);
    }
}
