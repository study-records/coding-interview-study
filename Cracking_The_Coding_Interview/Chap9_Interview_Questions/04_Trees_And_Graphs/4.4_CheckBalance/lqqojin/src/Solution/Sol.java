package Solution;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sol {

    int checkHeight(Node1 root) {
        if (root == null) return -1;

        int leftHeight = checkHeight(root.left);
        if (leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;

        int rightHeight = checkHeight(root.right);
        if (rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;

        int heightDiff = leftHeight - rightHeight;
        // System.out.println(Math.abs(heightDiff));
        if (Math.abs(heightDiff) > 1) {

            return Integer.MIN_VALUE;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    boolean isBalanced(Node1 root) {
        return checkHeight(root) != Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();


        Node1 n7 = bt.makeBT(null, "7", null);
        Node1 n6 = bt.makeBT(null, "6", null);
        Node1 n5 = bt.makeBT(null, "5", null);
        Node1 n4 = bt.makeBT(null, "4", null);
        Node1 n3 = bt.makeBT(n6, "3", n7);
        Node1 n2 = bt.makeBT(n4, "2", n5);
        Node1 n1 = bt.makeBT(n2, "1", n3);

//        Map<String, Node1> createNode = new HashMap<>();
//        String[] arr = {"1","2","3","4","5","6","7","a","b","c","d","e","f","g","h"};
//        for(int i = 0; i < arr.length; i++) {
//            createNode.put(arr[i], new Node1(arr[i]) );
//            System.out.println(createNode.get(arr[i]));
//        }
//
//        for(int i = arr.length-1; i > 0 ; i -= 1) {
//            if( i > 7 )createNode.put("node"+i, bt.makeBT(createNode.get(arr[i-1]), arr[i], createNode.get(arr[i-2])));
//            else createNode.put("node"+i, bt.makeBT(null, arr[i], null));
//        }
        System.out.print("preorder : ");
        bt.preorder(n1);
        System.out.println();

        System.out.print("inorder : ");
        bt.inorder(n1);
        System.out.println();

        System.out.print("postorder : ");
        bt.postorder(n1);
        System.out.println();

        Sol sol = new Sol();
        System.out.println(sol.checkHeight(n1));
        System.out.println(sol.isBalanced(n1));


    }
}
