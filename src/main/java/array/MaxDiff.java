package array;

/**
 * Given an array arr[] of integers, find out the difference between any two elements such that larger element appears
 * after the smaller number in arr[].
 * 
 * Examples: If array is [2, 3, 10, 6, 4, 8, 1] then returned value should be 8 (Diff between 10 and 2). If array is [
 * 7, 9, 5, 6, 3, 2 ] then returned value should be 2 (Diff between 7 and 9)
 * 
 * @author harish.sharma
 *
 */
public class MaxDiff {

    public int solve(int[] a) {
        int len = a.length;
        int maxDiff = Integer.MIN_VALUE;
        int curMin = a[0], curMax = a[0];
        int prev = a[0];
        for (int i = 1; i < len; i++) {
            prev = a[i - 1];
            if (prev > a[i]) {
                curMin = curMax = a[i];
            }
            curMin = Math.min(curMin, a[i]);
            curMax = Math.max(curMax, a[i]);
            maxDiff = Math.max(maxDiff, curMax - curMin);

        }
        return maxDiff;
    }

    public static void main(String[] args) {
        int[] a = { 2, 3, 10, 6, 4, 8, 1};
        int[] aa = { 2, 8, 5, 4, 9, 5, 6, 3, 2};
        System.out.println(new MaxDiff().solve(a));
        System.out.println(new MaxDiff().solve(aa));
    }
}
