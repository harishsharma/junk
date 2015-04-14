package array;

/**
 * Count the number of occurrences in a sorted array
 * 
 * @author harish.sharma
 *
 */
public class P25 {

    public int solve(int[] a, int k) {
        int left = leftBoundry(a, 0, a.length - 1, k);
        if (left == -1) return left;
        int right = rightBoundry(a, 0, a.length - 1, k);
        return right - left + 1;
    }

    private int rightBoundry(int[] a, int start, int end, int k) {
        if (start <= end) {
            int mid = start + (end - start) / 2;
            if (((mid == end) || (k < a[mid + 1])) && k == a[mid]) {
                return mid;
            } else if (a[mid] > k) {
                return rightBoundry(a, start, mid - 1, k);
            } else {
                return rightBoundry(a, mid + 1, end, k);
            }
        }
        return -1;
    }

    private int leftBoundry(int[] a, int start, int end, int k) {
        if (start <= end) {
            int mid = start + (end - start) / 2;
            if (((mid == 0) || (k > a[mid - 1])) && k == a[mid]) {
                return mid;
            } else if (k > a[mid]) {
                return leftBoundry(a, mid + 1, end, k);
            } else {
                return leftBoundry(a, start, mid - 1, k);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = { 1, 1, 2, 2, 2, 2, 3, 4, 5};
        System.out.println(new P25().solve(a, 1));
        System.out.println(new P25().solve(a, 2));
        System.out.println(new P25().solve(a, 3));
        System.out.println(new P25().solve(a, 4));
    }
}
