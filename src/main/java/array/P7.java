package array;

import java.util.Arrays;
import java.util.Map;

import com.google.common.collect.Maps;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in
 * the array which gives the sum of zero.
 * 
 * @author harish.sharma
 *
 */
public class P7 {

    public Triplet<Integer, Integer, Integer> solve(final int[] a) {
        Arrays.sort(a);
        if (a[0] >= 0 || a[a.length - 1] <= 0) return null;
        int len = a.length;

        for (int i = 0; a[i] < 0; i++) {
            Pair<Integer, Integer> res = solveForTwo(a, i, len - 1, -a[i]);
            if (res != null) {
                return Triplet.of(a[i], res.getFirst(), res.getSecond());
            }
        }
        return null;
    }

    private Pair<Integer, Integer> solveForTwo(final int[] a, int start, int end, int k) {
        if (start >= end) return null;
        Map<Integer, Integer> map = Maps.newHashMap();
        for (int i = start; i <= end; i++) {
            if (map.containsKey(a[i])) {
                return Pair.of(map.get(a[i]), a[i]);
            } else {
                map.put(k - a[i], a[i]);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] a = { -1, 1, 1, 2, -1, -4};
        System.out.println(new P7().solve(a));
    }
}
