package hackerrank;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/substring-diff
 * 
 * @author harish.sharma
 *
 */
public class SubstringDiff {

    public static int solve(String a, String b, int s) {
        char[] aS = a.toCharArray();
        char[] bS = b.toCharArray();
        int misMatch = 0;
        int res = 0;
        for (int i = 0; i < aS.length; i++) {
            for (int j = 0; j < bS.length; j++) {
                int k;
                misMatch = 0;
                for (k = 0; (i + k) < aS.length && (j + k) < bS.length; k++) {
                    if (aS[i + k] != bS[j + k]) misMatch++;
                    if (misMatch > s) break;
                }
                res = Math.max(res, k);
            }
        }
        return res;
    }

    public static int solve1(String a, String b, int s) {
        return helper(a.toCharArray(), b.toCharArray(), 0, a.length() - 1, 0, b.length() - 1, s);
    }

    public static int helper(char[] a, char[] b, int ai, int aj, int bi, int bj, int s) {
        if (s == 0) return 0;
        if (ai > aj) return 0;
        if (bi > bj) return 0;
        if (a[aj] == b[bj]) {
            return 1 + helper(a, b, ai, aj - 1, bi, bj - 1, s);
        } else {
            int w = 1 + helper(a, b, ai, aj - 1, bi, bj, s - 1);
            int x = 1 + helper(a, b, ai, aj, bi, bj - 1, s - 1);
            int y = 1 + helper(a, b, ai + 1, aj, bi, bj, s - 1);
            int z = 1 + helper(a, b, ai, aj, bi + 1, bj, s - 1);
            return Math.max(w, Math.max(x, Math.max(y, z)));
        }
    }

    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int s = in.nextInt();
            String a = in.next();
            String b = in.next();
            System.out.println(solve1(a, b, s));
        }
        in.close();
    }
}
