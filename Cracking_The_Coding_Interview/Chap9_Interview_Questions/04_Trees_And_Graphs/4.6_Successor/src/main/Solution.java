package main;
import structure.Tree;

public class Solution {
    public static void main(String [] args){
        Tree T = new Tree();
        T.root = new Tree.Node(7);
        T.root.parent = null;
        /**
         *               7
         *            5     10
         *         4    6
         *      3
         */
        Tree.Node N5 = new Tree.Node(5);
        Tree.Node N10 = new Tree.Node(10);
        Tree.Node N4= new Tree.Node(4);
        Tree.Node N6 = new Tree.Node(6);
        Tree.Node N3 = new Tree.Node(3);

        T.root.left = N5;
        T.root.right = N10;

        N5.left = N4;
        N5.right = N6;

        N4.left = N3;

        // IN Order Search : 3 4 5 6 7 10
        // Find Successor

        Tree.Node S = findSuccessor(N4);

        System.out.println(S.val);
        return;
    }

    private static Tree.Node findSuccessor(Tree.Node N) {
        Tree.Node answer;
        //if there is right node

        if(N.right!=null) { //answer => right node left bottom
            answer = N.right;
            while (answer.left != null) {
                answer = answer.left;
            }
            return answer;
        } //answer =>
        else{
            Tree.Node p = N.parent;
            answer = N;
            while(p!=null && p.left !=answer){
                answer = p;
                p = answer.parent;
            }
            return p;
        }
    }
}
