package hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * https://www.hackerrank.com/challenges/subsequence-weighting
 * 
 * @author harish.sharma
 *
 */
public class SubsequenceWeighting {

    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            long[] vals = new long[n];
            long[] weights = new long[n];
            for (int j = 0; j < n; j++) {
                vals[j] = in.nextLong();
            }
            for (int j = 0; j < n; j++) {
                weights[j] = in.nextLong();
            }
            System.out.println(solve1(vals, weights));
        }
        in.close();
    }


    private static long solve1(long[] a, long[] w) {
        int n = a.length;
        long best = 0;
        TreeMap<Long, Long> map = new TreeMap<Long, Long>();
        for (int k = 0; k < n; ++k) {
            Entry<Long, Long> e = map.lowerEntry(a[k]);
            long b = (e == null ? 0 : e.getValue()) + w[k];
            SortedMap<Long, Long> tail = map.tailMap(a[k]);
            List<Long> del = new ArrayList<Long>();
            for (Entry<Long, Long> x : tail.entrySet()) {
                if (x.getValue().longValue() > b) break;
                del.add(x.getKey());
            }
            for (Long i : del) {
                map.remove(i);
            }
            if (!map.containsKey(a[k])) map.put(a[k], b);
            if (best < b) best = b;
        }
        return best;
    }

    public static long solve(long[] vals, long[] weights) {
        int len = vals.length;
        long[] res = new long[len];
        res[0] = weights[0];
        long result = Long.MIN_VALUE;
        for (int i = 1; i < len; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (vals[i] > vals[j] && weights[i] + res[j] > res[i]) {
                    res[i] = weights[i] + res[j];
                }
            }
            if (res[i] == 0) {
                res[i] = weights[i];
            }
            result = Math.max(result, res[i]);
        }
        return result;
    }
}
