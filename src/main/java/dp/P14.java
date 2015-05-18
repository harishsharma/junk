package dp;

/**
 * Partition problem is to determine whether a given set can be partitioned into two subsets such that the sum of
 * elements in both subsets is same.
 * 
 * @author harish.sharma
 *
 */
public class P14 {

    public static boolean isSubset(int[] arr, int n, int sum) {
        if (sum == 0) return true;
        if (n == 0 && sum != 0) return false;
        if (arr[n - 1] > sum) return isSubset(arr, n - 1, sum);
        return isSubset(arr, n - 1, sum - arr[n - 1]) || isSubset(arr, n - 1, sum);
    }

    public static boolean solve(int[] arr) {
        int sum = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++)
            sum += arr[i];

        if (sum % 2 != 0) return false;
        return isSubset(arr, n, sum / 2);
    }

    public static void main(String[] args) {
        int arr[] = { 3, 1, 5, 9, 12};
        System.out.println(solve(arr));
    }
}
