package hackerrank;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/board-cutting
 * 
 * @author harish.sharma
 *
 */
public class BoardCutting {


    public static long solve(Long[] mh, Long[] nv) {
        long MOD = 1000000007;
        long res = 0l;
        int h = 1, v = 1;
        Arrays.sort(mh, Collections.reverseOrder());
        Arrays.sort(nv, Collections.reverseOrder());
        int lenh = mh.length;
        int lenv = nv.length;
        int i = 0, j = 0;
        while (lenv > 0 && lenh > 0) {
            if (mh[i] > nv[j]) {
                res += mh[i++] * v;
                h++;
                lenh--;
            } else if (mh[i] < nv[j]) {
                res += nv[j++] * h;
                v++;
                lenv--;
            } else {
                if (lenh > lenv) {
                    res += mh[i++] * v;
                    h++;
                    lenh--;
                } else {
                    res += nv[j++] * h;
                    v++;
                    lenv--;
                }
            }
            res %= MOD;
        }

        while (lenh > 0) {
            res += mh[i++] * v;
            h++;
            lenh--;
            res %= MOD;
        }
        while (lenv > 0) {
            res += nv[j++] * h;
            v++;
            lenv--;
            res %= MOD;
        }
        return res;
    }

    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int m = in.nextInt();
            int n = in.nextInt();
            Long[] mh = new Long[m - 1];
            Long[] nv = new Long[n - 1];
            for (int j = 0; j < m - 1; j++) {
                mh[j] = in.nextLong();
            }
            for (int j = 0; j < n - 1; j++) {
                nv[j] = in.nextLong();
            }
            System.out.println(solve(mh, nv));
        }
        in.close();
    }
}
