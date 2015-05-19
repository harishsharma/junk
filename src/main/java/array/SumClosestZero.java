package array;

import java.util.Arrays;

/**
 * An Array of integers is given, both +ve and -ve. You need to find the two elements such that their sum is closest to
 * zero.
 * 
 * @author harish.sharma
 *
 */
public class SumClosestZero {

    public Pair<Integer, Integer> solve(int[] a) {
        Arrays.sort(a);
        int len = a.length;
        Integer pairA = null, pairB = null;
        int curMin = Integer.MAX_VALUE;

        for (int i = 0, j = len - 1; i < j;) {
            int sum = a[i] + a[j];
            if (Math.abs(sum) < Math.abs(curMin)) {
                pairA = i;
                pairB = j;
                curMin = sum;
            }
            if (curMin == 0) {
                pairA = i;
                pairB = j;
                break;
            } else if (sum < 0) {
                i++;
            } else {
                j--;
            }
        }
        return Pair.of(a[pairA], a[pairB]);
    }

    public static void main(String[] args) {
        int[] a = { 60, -10, 70, -80, 85, -83, 83};
        System.out.println(new SumClosestZero().solve(a));
    }
}
