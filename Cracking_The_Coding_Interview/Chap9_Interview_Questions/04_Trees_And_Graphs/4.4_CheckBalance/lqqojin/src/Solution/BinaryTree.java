package Solution;

public class BinaryTree {

    Node1 root;

    public BinaryTree() {
        this.root = null;
    }

    public Node1 makeBT(Node1 bt1, Object data, Node1 bt2){

        Node1 newNode = new Node1(data);
        newNode.left = bt1;
        newNode.right =bt2;

        return newNode;
    }

    public void preorder(Node1 root){
        if(root != null){
            System.out.print(root.getData());
            preorder(root.left);
            preorder(root.right);
        }
    }

    public void inorder(Node1 root){
        if(root != null){
            inorder(root.left);
            System.out.print(root.getData());
            inorder(root.right);
        }
    }

    public void postorder(Node1 root){
        if(root != null){
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.getData());
        }
    }
}


