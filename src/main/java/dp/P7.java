package dp;

/**
 * Given a value N, if we want to make change for N cents, and we have infinite supply of each of S = { S1, S2, .. , Sm}
 * valued coins, how many ways can we make the change? The order of coins doesn’t matter.
 * 
 * For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. So output should be
 * 4. For N = 10 and S = {2, 5, 3, 6}, there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}. So
 * the output should be 5.
 * 
 * 
 * @author harish.sharma
 *
 */
public class P7 {
    public static int solve(int[] s, int m, int n) {

        if (n == 0) return 1;
        if (n < 0) return 0;
        if (m <= 0 && n > 0) return 0;
        return solve(s, m, n - s[m - 1]) + solve(s, m - 1, n);
    }

    public static int solve1(int[] s, int coins, int amount) {

        int[][] S = new int[amount + 1][coins];
        for (int i = 0; i < coins; i++) {
            S[0][i] = 1;
        }
        for (int i = 1; i < amount + 1; i++) {
            for (int j = 0; j < coins; j++) {
                int x = (j >= 1) ? S[i][j - 1] : 0;
                int y = (i - s[j]) >= 0 ? S[i - s[j]][j] : 0;
                S[i][j] = x + y;
            }
        }
        return S[amount][coins - 1];
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3};
        System.out.println(solve(arr, 3, 2));
        System.out.println(solve(arr, 3, 3));
        System.out.println(solve(arr, 3, 4));
        System.out.println(solve(arr, 3, 5));
        System.out.println(solve(arr, 3, 6));
        System.out.println(solve1(arr, 3, 2));
        System.out.println(solve1(arr, 3, 3));
        System.out.println(solve1(arr, 3, 4));
        System.out.println(solve1(arr, 3, 5));
        System.out.println(solve1(arr, 3, 6));
    }
}
