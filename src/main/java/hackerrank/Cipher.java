package hackerrank;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/cipher
 * 
 * @author harish.sharma
 *
 */
public class Cipher {
    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int size = n + k - 1;
        int[] f = new int[n + k - 1];
        String num = in.next();
        for (int i = 0; i < size; i++) {
            f[i] = num.charAt(size - i - 1) - '0';
        }
        System.out.println(solve(f, k, n));
        in.close();
    }

    private static String solve(int[] f, int k, int n) {
        int[] r = new int[n];
        r[0] = f[0];
        r[1] = f[1] ^ r[0];
        StringBuilder sb = new StringBuilder();

        int[] pre = new int[n];
        pre[0] = r[0];
        for (int i = 1; i < n; i++) {
            r[i] = f[i] ^ pre[i - 1];
            if (i < k - 1)
                pre[i] = r[i] ^ pre[i - 1];
            else {
                pre[i] = r[i - (k - 1)] ^ r[i] ^ pre[i - 1];
            }

        }
        reverse(r, 0, n);
        for (int i = 0; i < n; i++) {
            sb.append(r[i]);
        }
        return sb.toString();
    }

    private static void reverse(int[] a, int start, int end) {
        for (int i = start, j = end - 1; i < j; i++, j--) {
            int tem = a[i];
            a[i] = a[j];
            a[j] = tem;
        }
    }
}
