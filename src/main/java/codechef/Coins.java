package codechef;

import java.util.Scanner;

/**
 * https://www.codechef.com/problems/COINS
 * 
 * @author harish.sharma
 *
 */
class Coins {
    private final int CONST = 10000000;
    private long[]    dp    = new long[CONST];

    public void preprocess() {
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        int size = dp.length;
        for (int i = 4; i < size; i++) {
            int a = i / 2;
            int b = i / 3;
            int c = i / 4;
            if (dp[a] + dp[b] + dp[c] > i) {
                dp[i] = dp[a] + dp[b] + dp[c];
            } else {
                dp[i] = i;
            }
        }
    }

    public long solve(int n) {
        if (n < CONST)
            return dp[n];
        else
            return Math.max(n, solve(n / 2) + solve(n / 3) + solve(n / 4));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Coins c = new Coins();
        c.preprocess();
        while (in.hasNextInt()) {
            int next = in.nextInt();
            System.out.println(c.solve(next));
        }
        in.close();
    }
}
