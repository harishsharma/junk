package array;

/**
 * Find the sum of contiguous sub array within a one-dimensional array of numbers which has the largest sum.
 * 
 * @author harish.sharma
 *
 */
public class MaxSumContigous {

    public int solve(int[] a) {

        int len = a.length;
        int curMax = a[0];
        int maxSoFar = a[0];
        for (int i = 1; i < len; i++) {
            curMax = Math.max(a[i], curMax + a[i]);
            maxSoFar = Math.max(maxSoFar, curMax);
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        int[] a = { 1, 2, 3, -3, 1, 3, 4};
        System.out.println(new MaxSumContigous().solve(a));
    }
}
