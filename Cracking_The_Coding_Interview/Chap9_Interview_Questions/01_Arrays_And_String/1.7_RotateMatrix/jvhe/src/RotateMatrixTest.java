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
        int[][] matrix2 = {
                {1, 2, 3, 4},
                {4, 5, 6, 7},
                {7, 8, 9, 10},
                {1532, 231, 5531, 223}
        };
        int[][] output2 = {
                {4, 7, 10, 223},
                {3, 6, 9, 5531},
                {2, 5, 8, 231},
                {1, 4, 7, 1532}
        };
        assertThat(RotateMatrix.solution(matrix), equalTo(output1));
        assertThat(RotateMatrix.solution(matrix2), equalTo(output2));
    }
}