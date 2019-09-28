public class RotateMatrix {
    static int[][] solution(int[][] matrix) {
        int size = matrix.length;
        int[][] result = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result[i][j] = matrix[i][j];
            }
        }

        for (int y = 0; y < size / 2; y++) {
            for (int x = y; x < size - 1 - y; x++) {
                int tmp = result[y][x];
                result[y][x] = result[x][size - y - 1];
                result[x][size - y - 1] = result[size - y - 1][size - x - 1];
                result[size - y - 1][size - x - 1] = result[size - x - 1][y];
                result[size - x - 1][y] = tmp;
            }
        }

        return result;
    }
}
