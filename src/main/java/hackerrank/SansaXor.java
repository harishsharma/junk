package hackerrank;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/sansa-and-xor
 * 
 * @author harish.sharma
 *
 */
public class SansaXor {
    public static void main(String[] arg) {

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int[] a = new int[n];
            for (int j = 0; j < n; j++) {
                a[j] = in.nextInt();
            }
            System.out.println(solve(a));
        }
        in.close();
    }

    private static int solve(int[] a) {
        int len = a.length;
        int n = len;
        int start = 1;
        int res = 0;
        for (int i = 0; i < len; i++) {
            int num = (n - i) * (start + i);
            if (num % 2 != 0) res ^= a[i];
        }
        return res;
    }
}
