package hackerrank;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/sherlock-and-cost
 * 
 * @author harish.sharma
 *
 */
public class SherlockAndCost {

    public static long solve(int[] b) {
        int len = b.length;
        long[][] dp = new long[len][2];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + (b[i - 1] - 1));
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + b[i] - 1);
        }
        return Math.max(dp[len - 1][0], dp[len - 1][1]);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int[] b = new int[n];
            for (int j = 0; j < n; j++) {
                b[j] = in.nextInt();
            }
            System.out.println(solve(b));
        }
        in.close();
    }
}
