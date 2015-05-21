package hackerrank;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/largest-permutation
 * 
 * @author harish.sharma
 *
 */
public class LargestPermutation {
    public static int[] solve(int[] a, int perm) {
        int len = a.length;

        for (int i = 0, j = 0; i < perm && j < a.length; j++) {
            int idx = findIndex(a, j, len--);
            if (j != idx) {
                swap(a, j, idx);
                i++;
            }
        }
        return a;
    }

    private static void swap(int[] a, int i, int idx) {
        int tem = a[i];
        a[i] = a[idx];
        a[idx] = tem;
    }

    private static int findIndex(int[] a, int start, int k) {
        int len = a.length;
        for (int i = start; i < len; i++) {
            if (a[i] == k) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int perms = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        int[] rs = solve(a, perms);
        for (int i = 0; i < n; i++) {
            System.out.print(rs[i] + " ");
        }
        in.close();
    }
}
