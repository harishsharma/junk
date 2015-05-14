package dp;

/**
 * Given weights and values of n items, put these items in a knapsack of capacity W to get the maximum total value in
 * the knapsack. In other words, given two integer arrays val[0..n-1] and wt[0..n-1] which represent values and weights
 * associated with n items respectively. Also given an integer W which represents knapsack capacity, find out the
 * maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W. You cannot
 * break an item, either pick the complete item, or don’t pick it (0-1 property).
 * 
 * @author harish.sharma
 *
 */
public class P8 {
    public static int solve(int[] val, int[] wt, int n, int w) {
        if (n == 0 || w == 0) return 0;
        if (w < wt[n - 1]) {
            return solve(val, wt, n - 1, w);
        }
        return Math.max(solve(val, wt, n - 1, w), solve(val, wt, n - 1, w - wt[n - 1]) + val[n - 1]);
    }


    public static int solve1(int[] val, int[] wt, int n, int W) {
        int i, w;
        int[][] K = new int[n + 1][W + 1];

        for (i = 0; i <= n; i++) {
            for (w = 0; w <= W; w++) {
                if (i == 0 || w == 0)
                    K[i][w] = 0;
                else if (wt[i - 1] <= w)
                    K[i][w] = Math.max(val[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w]);
                else
                    K[i][w] = K[i - 1][w];
            }
        }

        return K[n][W];
    }

    public static void main(String[] args) {
        int[] val = { 60, 100, 120, 10};
        int[] wt = { 10, 20, 30, 10};
        System.out.println(solve(val, wt, 4, 70));
        System.out.println(solve1(val, wt, 4, 60));
    }


}
