package Solution;

import static org.junit.Assert.*;

public class SolTest {

    private final Sol sol = new Sol();
    @org.junit.Test
    public void isBalanced1() {
        BinaryTree bt = new BinaryTree();


        Node1 n7 = bt.makeBT(null, "7", null);
        Node1 n6 = bt.makeBT(null, "6", null);
        Node1 n5 = bt.makeBT(null, "5", null);
        Node1 n4 = bt.makeBT(null, "4", null);
        Node1 n3 = bt.makeBT(n6, "3", n7);
        Node1 n2 = bt.makeBT(n4, "2", n5);
        Node1 n1 = bt.makeBT(n2, "1", n3);

        Boolean result = sol.isBalanced(n1);
        assertEquals(true, result);
    }

    @org.junit.Test
    public void isBalanced2() {
        BinaryTree bt = new BinaryTree();

        Node1 n9 = bt.makeBT(null, "9", null);
        Node1 n8 = bt.makeBT(n9, "8", null);

        Node1 n7 = bt.makeBT(null, "7", null);
        Node1 n6 = bt.makeBT(null, "6", null);
        Node1 n5 = bt.makeBT(null, "5", null);
        Node1 n4 = bt.makeBT(n8, "4", null);
        Node1 n3 = bt.makeBT(n6, "3", n7);
        Node1 n2 = bt.makeBT(n4, "2", n5);
        Node1 n1 = bt.makeBT(n2, "1", n3);

        Boolean result = sol.isBalanced(n1);
        assertEquals(false, result);
    }
}