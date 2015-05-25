package hackerrank;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/antipalindromic-strings
 * 
 * @author harish.sharma
 *
 */
public class AntiPalindromicString {

    public static long solve(long n, long m) {
        long MOD = 1000000007;
        long res = m;
        if (n > 1) {
            res *= (m - 1);
            res %= MOD;
        }
        if (n > 2) {
            res *= poww(m - 2, n - 2, MOD);
            res %= MOD;
        }
        return res % MOD;
    }

    private static long poww(long a, long b, long MOD) {
        long res = 1l;
        b = b % MOD;
        while (b > 0) {
            if (b % 2 == 0) {
                b /= 2;
                a *= a;
                a = a % MOD;
            } else {
                res *= a;
                res %= MOD;
                b = b - 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            long n = in.nextLong();
            long m = in.nextLong();
            System.out.println(solve(n, m));
        }
        in.close();
    }
}
