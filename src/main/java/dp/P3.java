package dp;

/**
 * The longest Increasing Subsequence (LIS) problem is to find the length of the longest subsequence of a given sequence
 * such that all elements of the subsequence are sorted in increasing order. For example, length of LIS for { 10, 22, 9,
 * 33, 21, 50, 41, 60, 80 } is 6 and LIS is {10, 22, 33, 50, 60, 80}.
 * 
 * @author harish.sharma
 *
 */
public class P3 {

    public static int solve(int[] a) {
        int len = a.length;
        int[] lis = new int[len];
        lis[0] = 1;
        for (int i = 1; i < len; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (a[i] >= a[j] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                }
            }
            if (lis[i] == 0) {
                lis[i] = 1;
            }
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            res = Math.max(res, lis[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = { 10, 22, 9, 33, 21, 50, 41, 60};
        System.out.println(solve(a));
    }
}
