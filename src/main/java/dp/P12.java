package dp;

/**
 * Given an array of n positive integers. Write a program to find the sum of maximum sum subsequence of the given array
 * such that the integers in the subsequence are sorted in increasing order. For example, if input is {1, 101, 2, 3,
 * 100, 4, 5}, then output should be 106 (1 + 2 + 3 + 100), if the input array is {3, 4, 5, 10}, then output should be
 * 22 (3 + 4 + 5 + 10) and if the input array is {10, 5, 4, 3}, then output should be 10
 * 
 * @author harish.sharma
 *
 */
public class P12 {

    public static int solve(int[] a) {
        int len = a.length;
        int[] S = new int[len];
        S[0] = a[0];
        for (int i = 1; i < len; i++) {
            int res = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (a[j] < a[i]) res = Math.max(res, a[i] + S[j]);
            }
            S[i] = res;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++)
            max = Math.max(max, S[i]);
        return max;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 101, 2, 3, 100, 4, 5};
        System.out.println(solve(arr));
    }
}
