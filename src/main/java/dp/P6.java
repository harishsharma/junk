package dp;

/**
 * Given a cost matrix cost[][] and a position (m, n) in cost[][], write a function that returns cost of minimum cost
 * path to reach (m, n) from (0, 0). Each cell of the matrix represents a cost to traverse through that cell. Total cost
 * of a path to reach (m, n) is sum of all the costs on that path (including both source and destination). You can only
 * traverse down, right and diagonally lower cells from a given cell, i.e., from a given cell (i, j), cells (i+1, j),
 * (i, j+1) and (i+1, j+1) can be traversed. You may assume that all costs are positive integers.
 * 
 * 
 * @author harish.sharma
 *
 */
public class P6 {
    public static int solve(int[][] cost, int m, int n) {
        int row = cost.length;
        int col = cost[0].length;
        int[][] C = new int[row + 1][col + 1];

        for (int i = 1; i < row + 1; i++) {
            C[i][0] = cost[i - 1][0] + C[i - 1][0];
        }
        for (int i = 1; i < col + 1; i++) {
            C[0][i] = cost[0][i - 1] + C[0][i - 1];
        }
        for (int i = 1; i < row + 1; i++) {
            for (int j = 1; j < col + 1; j++) {
                C[i][j] = cost[i - 1][j - 1] + Math.min(C[i - 1][j - 1], Math.min(C[i - 1][j], C[i][j - 1]));
            }
        }
        return C[m][n];
    }

    public static void main(String[] args) {
        int[][] cost = { { 1, 2, 3}, { 4, 8, 2}, { 1, 5, 3}};
        System.out.println(solve(cost, 3, 2));
    }
}
