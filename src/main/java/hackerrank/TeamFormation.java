package hackerrank;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/team-formation
 * 
 * @author harish.sharma
 *
 */
public class TeamFormation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            long[] a = new long[n];
            for (int j = 0; j < n; j++) {
                a[j] = in.nextLong();
            }
            System.out.println(solve(a));
        }
        in.close();
    }

    private static long solve(long[] a) {
        Arrays.sort(a);
        int len = a.length;
        long res = Long.MAX_VALUE;
        int count = 1;
        if (a.length == 0) return 0l;
        long prev = a[0];
        for (int i = 1; i < len; i++) {
            if (prev + 1 == a[i]) {
                count++;
                prev = a[i];
            } else {
                res = Math.min(res, count);
                count = 1;
                prev = a[i];
            }
        }
        res = Math.min(res, count);
        return res;
    }
}
