package hackerrank;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/antipalindromic-strings
 * 
 * @author harish.sharma
 *
 */
public class AntiPalindromicString {


    public static long solve(int n, int m) {
        long MOD = 1000000007;
        if (n == 1) return m;
        if (m == 0) return 0;
        long res = (m * (m - 1)) % MOD;
        return res * pow(m - 2, n - 2, MOD);
    }

    private static long pow(int a, int b, long MOD) {
        if (a == 1) return 1;
        if (b == 0) return 1;
        if (b % 2 == 0)
            return (pow(a, b / 2, MOD) * pow(a, b / 2, MOD)) % MOD;
        else
            return (a * pow(a, b / 2, MOD) * pow(a, b / 2, MOD)) % MOD;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int m = in.nextInt();
            System.out.println(solve(n, m));
        }
        in.close();
    }
}
