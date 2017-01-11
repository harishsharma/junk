package AlgoManual;

/**
 * Created by harish.sharma on 2/27/16.
 */
public class RotateMatrix {

    public static int[][] rotate(int[][] mat) {
        if (mat == null)
            throw new IllegalArgumentException("null not allowed");
        int row = mat.length;
        int col = mat[0].length;
        int newRow = col, newCOl = row;
        int[][] newMatrix = new int[newRow][newCOl];

        for (int i = 0, k = newCOl - 1; i < row; i++) {
            for (int j = 0; j < col; j++) {
                newMatrix[j][k] = mat[i][j];
            }
            k--;
        }

        return newMatrix;
    }

    public static void main(String[] art) {
        int[][] main = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int[][] result = rotate(main);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(" " + result[i][j]);
            }
            System.out.println();
        }
    }
}
