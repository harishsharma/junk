package hackerrank;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/priyanka-and-toys
 * 
 * @author harish.sharma
 *
 */
public class Toys {

    public static int solve(int[] a) {
        int len = a.length;
        Arrays.sort(a);
        int res = 0;
        for (int i = 0; i < len - 1;) {
            int j = i + 1;
            while (j < len && a[j] - a[i] <= 4) {
                j++;
            }
            i = j;
            res++;
        }
        if (a[len - 1] - a[len - 2] > 4) res++;
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        System.out.println(solve(a));
        in.close();
    }
}
