package hackerrank;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/crush
 * 
 * @author harish.sharma
 *
 */
public class Crush {


    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        long[] ar = new long[n + 2];
        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int k = in.nextInt();
            ar[a] += k;
            ar[b + 1] -= k;
        }
        long max = Long.MIN_VALUE;
        for (int i = 1; i < n + 2; i++) {
            long k = ar[i] + ar[i - 1];
            max = Math.max(k, max);
            ar[i] = k;
        }
        System.out.println(max);
        in.close();
    }
}
