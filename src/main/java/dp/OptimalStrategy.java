package dp;

/**
 * Consider a row of n coins of values v1 . . . vn, where n is even. We play a game against an opponent by alternating
 * turns. In each turn, a player selects either the first or last coin from the row, removes it from the row
 * permanently, and receives the value of the coin. Determine the maximum possible amount of money we can definitely win
 * if we move first.
 * 
 * F(i,j) = Max{coins[i] + Min(F(i+2,j) , F(i+1,j-1)) , coins[j]+Min(F(i,j-2),F(i+1,j-1))}
 * 
 * @author harish.sharma
 *
 */
public class OptimalStrategy {
    public static int solve(int[] coins) {
        int len = coins.length;
        int[][] R = new int[len][len];
        for (int gap = 0; gap < len; gap++) {
            for (int i = 0, j = gap; j < len; i++, j++) {
                int x = (i + 2 <= j) ? R[i + 2][j] : 0;
                int y = (i + 1 <= j - 1) ? R[i + 1][j - 1] : 0;
                int z = (i <= j - 2) ? R[i][j - 2] : 0;
                R[i][j] = Math.max(coins[j] + Math.min(z, y), coins[i] + Math.min(x, y));
            }
        }
        return R[0][len - 1];
    }

    public static void main(String[] args) {
        int arr1[] = { 8, 15, 3, 7};
        System.out.println(solve(arr1));
        int arr2[] = { 2, 2, 2, 2};
        System.out.println(solve(arr2));
        int arr3[] = { 20, 30, 2, 2, 2, 10};
        System.out.println(solve(arr3));
    }
}
