import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class RotateMatrixTest {

    @org.junit.Test
    public void rotate() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] output1 = {
                {3, 6, 9},
                {2, 5, 8},
                {1, 4, 7}
        };
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix.length; j++) {
//                System.out.printf(matrix[i][j] + " ");
//            }
//            System.out.println();
//        }

        RotateMatrix.rotate(matrix);
        assertThat(matrix, equalTo(output1));
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.printf(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}