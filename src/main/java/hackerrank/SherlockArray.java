package hackerrank;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/sherlock-and-array
 * 
 * @author harish.sharma
 *
 */
public class SherlockArray {

    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int[] a = new int[n];
            for (int j = 0; j < n; j++) {
                a[j] = in.nextInt();
            }
            solve(a);
        }
        in.close();
    }

    private static void solve(int[] a) {
        int len = a.length;
        if (len == 1) {
            System.out.println("YES");
            return;
        }
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = a[0];
        for (int i = 1; i < len; i++) {
            left[i] = left[i - 1] + a[i];
        }
        right[len - 1] = a[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            right[i] = right[i + 1] + a[i];
        }
        for (int i = 1; i < len - 1; i++) {
            if (left[i - 1] == right[i + 1]) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }
}
