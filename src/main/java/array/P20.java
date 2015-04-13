package array;

/**
 * Given an array of positive numbers, find the maximum sum of a subsequence with the constraint that no 2 numbers in
 * the sequence should be adjacent in the array. So 3 2 7 10 should return 13 (sum of 3 and 10) or 3 2 5 10 7 should
 * return 15 (sum of 3, 5 and 7).Answer the question in most efficient way.
 * 
 * @author harish.sharma
 *
 */
public class P20 {
    public int solve(int[] a) {
        int len = a.length;
        int inc = a[0];
        int exc = 0;
        int oldinc;
        for (int i = 1; i < len; i++) {
            oldinc = inc;
            inc = Math.max(exc + a[i], inc);
            exc = oldinc;
        }
        return Math.max(inc, exc);
    }

    public static void main(String[] args) {
        int[] a = { 3, 2, 5, 10, 7};
        System.out.println(new P20().solve(a));
    }
}
