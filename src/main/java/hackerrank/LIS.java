package hackerrank;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/longest-increasing-subsequence
 * 
 * @author harish.sharma
 *
 */
public class LIS {

    public static int lis(int[] a) {
        int len = a.length;
        int[] L = new int[len];
        L[0] = 1;
        int result = Integer.MIN_VALUE;
        for (int i = 1; i < len; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (a[j] < a[i]) {
                    L[i] = Math.max(L[i], L[j] + 1);
                }
            }
            if (L[i] == 0) L[i] = 1;
            result = Math.max(L[i], result);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = in.nextInt();
        }
        System.out.println(lis(ar));
        in.close();
    }
}
