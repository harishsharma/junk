package array;

/**
 * Given an array arr[], find the maximum j – i such that arr[j] > arr[i].
 * 
 * Examples:
 * 
 * Input: {34, 8, 10, 3, 2, 80, 30, 33, 1} Output: 6 (j = 7, i = 1)
 * 
 * @author harish.sharma
 *
 */
public class P26 {

    public int solve(int[] a) {
        int len = a.length;
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = a[0];
        for (int i = 1; i < len; i++) {
            left[i] = Math.min(a[i], left[i - 1]);
        }

        right[len - 1] = a[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            right[i] = Math.max(a[i], right[i + 1]);
        }

        int i = 0, j = 0, maxDiff = Integer.MIN_VALUE;
        while (i < len && j < len) {
            if (left[i] < right[j]) {
                maxDiff = Math.max(maxDiff, j - i);
                j++;
            } else
                i++;
        }
        return maxDiff;
    }

    public static void main(String[] args) {
        int[] a = { 6, 5, 4, 3, 2, 1};
        System.out.println(new P26().solve(a));
    }
}
