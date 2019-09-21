public class RotateMatrix {
    static void rotate(int[][] matrix) {
        int size = matrix.length;
        for (int y = 0; y < size / 2; y++) {
            for (int x = y; x < size - 1 - y; x++) {
                int tmp = matrix[y][x];
                // 5 5에서
                // 1, 2는 2, size -1
                matrix[y][x] = matrix[x][size - y - 1];
                matrix[x][size - y - 1] = matrix[size - y - 1][size - x - 1];
                matrix[size - y - 1][size - x - 1] = matrix[size - x - 1][y];
                matrix[size - x - 1][y] = tmp;
            }
        }
    }
}
