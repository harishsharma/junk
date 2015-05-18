package dp;

/**
 * Given a binary matrix, find out the maximum size square sub-matrix with all 1s.
 * 
 * @author harish.sharma
 *
 */
public class P16 {

    public static int solve(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int[][] S = new int[rows][cols];
        for (int i = 0; i < cols; i++) {
            S[0][i] = mat[0][i];
        }
        for (int i = 0; i < rows; i++) {
            S[i][0] = mat[i][0];
        }

        int result = Integer.MIN_VALUE;
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (mat[i][j] == 0)
                    S[i][j] = 0;
                else {
                    S[i][j] = 1 + Math.min(S[i - 1][j], Math.min(S[i][j - 1], S[i - 1][j - 1]));
                }
                result = Math.max(result, S[i][j]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] M = { { 0, 1, 1, 0, 1}, { 1, 1, 0, 1, 0}, { 0, 1, 1, 1, 0}, { 1, 1, 1, 1, 0}, { 1, 1, 1, 1, 1},
                { 0, 0, 0, 0, 0}};

        System.out.println(solve(M));
    }
}
