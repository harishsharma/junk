package hackerrank;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/xoring-ninja
 * 
 * @author harish.sharma
 *
 */
public class XoringNinja {

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

    private static long solve(int[] a) {
        int len = a.length;
        int res = a[0];
        for (int i = 1; i < len; i++) {
            res |= a[i];
        }
        long ress = res;
        for (int i = 0; i < len - 1; i++) {
            ress = ress * 2;
            ress %= 1000000007;
        }
        return ress;
    }
}
