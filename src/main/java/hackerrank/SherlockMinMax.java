package hackerrank;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/sherlock-and-minimax
 * 
 * @author harish.sharma
 *
 */
public class SherlockMinMax {

    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextLong();
        }
        long p = in.nextLong();
        long q = in.nextLong();
        System.out.println(solve1(a, p, q));
        in.close();
    }

    public static long solve1(long[] a, long p, long q) {
        Arrays.sort(a);
        Pair max = new Pair(0, Long.MIN_VALUE);
        for (long i = p; i <= q; i++) {
            long min = Long.MAX_VALUE;
            for (int j = 0; j < a.length; j++) {
                min = Math.min(min, Math.abs(a[j] - i));
            }
            if (max.second < min) {
                max = new Pair(i, min);
            }
        }

        return max.first;
    }

    public static long solve(long[] a, long p, long q) {
        Arrays.sort(a);
        Pair max = new Pair(0, Long.MIN_VALUE);
        for (int i = 0; i < a.length; i++) {
            long min = 0l;
            if (a[i] > q) {
                min = Math.abs(a[i] - q);
            } else if (a[i] < p) {
                min = Math.abs(a[i] - p);
            } else if (a[i] == p) {
                min = p + 1;
            } else if (a[i] == q) {
                min = q - 1;
            } else {
                min = a[i] - 1;
            }
            if (Math.abs(a[i] - min) > max.second) {
                max = new Pair(min, Math.abs(a[i] - min));
            }
        }

        return max.first;
    }

    private static class Pair {
        long first;
        long second;

        public Pair(long a, long b) {
            this.first = a;
            this.second = b;
        }
    }
}
