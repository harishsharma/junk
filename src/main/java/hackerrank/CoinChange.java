package hackerrank;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/coin-change
 * 
 * @author harish.sharma
 *
 */
public class CoinChange {
    public static int coinChange(int[] c, int coins, int amount) {
        if (amount == 0) return 1;
        if (amount < 0) return 0;
        if (coins <= 0 && amount > 0) return 0;

        if (c[coins - 1] > amount) return coinChange(c, coins - 1, amount);
        return coinChange(c, coins - 1, amount) + coinChange(c, coins, amount - c[coins - 1]);
    }

    public static long coinChange1(int[] c, int coins, int amount) {
        long[][] S = new long[amount + 1][coins];
        for (int i = 0; i < coins; i++) {
            S[0][i] = 1;
        }

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins; j++) {
                long x = (j >= 1) ? S[i][j - 1] : 0;
                long y = (i - c[j]) >= 0 ? S[i - c[j]][j] : 0;
                S[i][j] = x + y;
            }
        }
        return S[amount][coins - 1];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] coinValues = new int[m];
        for (int i = 0; i < m; i++) {
            coinValues[i] = in.nextInt();
        }
        System.out.println(coinChange1(coinValues, m, n));
        in.close();
    }
}
