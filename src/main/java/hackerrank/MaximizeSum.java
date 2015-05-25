package hackerrank;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/maximise-sum
 * 
 * @author harish.sharma
 *
 */
public class MaximizeSum {

    public static long solve(long[] a, long m) {
        int len = a.length;
        long[] sum = new long[len];
        sum[0] = a[0];
        for (int i = 1; i < len; i++) {
            sum[i] = sum[i - 1] + a[i];
        }

        long res = 0l;
        for (int i = 1; i < len; i++) {
            res = Math.max(sum[i] % m, res);
            if (res == m - 1) return m - 1;
            for (int j = i; j < len; j++) {
                long t = (sum[j] - sum[j - i]) % m;
                if (t == m - 1) return m - 1;
                res = Math.max(res, t);
            }
        }
        res = Math.max(res, sum[len - 1] % m);
        return res;
    }

    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int j = 0; j < t; j++) {
            int n = in.nextInt();
            long m = in.nextInt();
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextLong();
            }
            System.out.println(solve(a, m));
        }
        in.close();
    }
}
