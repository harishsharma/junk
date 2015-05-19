package dp;

/**
 * Given an array arr[0 … n-1] containing n positive integers, a subsequence of arr[] is called Bitonic if it is first
 * increasing, then decreasing. Write a function that takes an array as argument and returns the length of the longest
 * bitonic subsequence. A sequence, sorted in increasing order is considered Bitonic with the decreasing part as empty.
 * Similarly, decreasing order sequence is considered Bitonic with the increasing part as empty.
 * 
 * @author harish.sharma
 *
 */
public class Bitonic {
    public static int solve(int[] a) {
        int len = a.length;
        int[] L = new int[len];
        int[] R = new int[len];

        L[0] = 1;
        for (int i = 1; i < len; i++) {
            int res = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (a[j] <= a[i]) {
                    res = Math.max(res, 1 + L[j]);
                }
            }
            L[i] = res;
        }

        R[len - 1] = 1;
        for (int i = len - 2; i >= 0; i--) {
            int res = 1;
            for (int j = len - 1; j > i; j--) {
                if (a[j] <= a[i]) res = Math.max(res, 1 + R[j]);
            }
            R[i] = res;
        }
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                result = Math.max(L[i] + R[j], result);
            }
        }
        result = Math.max(result, R[0]);
        result = Math.max(result, L[len - 1]);
        return result;
    }

    public static void main(String[] args) {
        int[] a = { 80, 60, 30, 40, 20, 10};
        System.out.println(solve(a));
        int[] a1 = { 1, 11, 2, 10, 4, 5, 2, 1};
        System.out.println(solve(a1));
        int[] a2 = { 12, 11, 40, 5, 3, 1};
        System.out.println(solve(a2));
    }
}
