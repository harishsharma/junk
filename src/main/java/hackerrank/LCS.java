package hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/dynamic-programming-classics-the-longest-common-subsequence
 * 
 * @author harish.sharma
 *
 */
public class LCS {
    public static List<Integer> solve(int[] a, int[] b) {
        int alen = a.length;
        int blen = b.length;
        int[][] res = new int[alen + 1][blen + 1];
        for (int i = 1; i <= alen; i++) {
            for (int j = 1; j <= blen; j++) {
                if (a[i - 1] == b[j - 1])
                    res[i][j] = res[i - 1][j - 1] + 1;
                else {
                    res[i][j] = Math.max(res[i][j - 1], res[i - 1][j]);
                }
            }
        }
        List<Integer> ints = new ArrayList<Integer>();
        int jstart = blen;
        int j = jstart;
        for (int i = alen; i >= 1 && j >= 1;) {
            for (j = jstart; j >= 1;) {
                int cur = res[i][j];
                int up = res[i - 1][j];
                int left = res[i][j - 1];
                int corner = res[i - 1][j - 1];
                if (left < cur && up < cur && corner == cur - 1) {
                    ints.add(b[j - 1]);
                    i--;
                    jstart = --j;
                    break;
                } else if (cur == left) {
                    j--;
                } else {
                    i--;
                    jstart = j;
                    break;
                }
            }
        }
        return ints;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];
        int[] b = new int[m];

        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        for (int i = 0; i < m; i++) {
            b[i] = in.nextInt();
        }
        List<Integer> res = solve(a, b);
        int len = res.size();
        for (int i = len - 1; i >= 0; i--) {
            System.out.print(res.get(i) + " ");
        }
        in.close();
    }
}
