package dp;

/**
 * Given an array of integers where each element represents the max number of steps that can be made forward from that
 * element. Write a function to return the minimum number of jumps to reach the end of the array (starting from the
 * first element). If an element is 0, then cannot move through that element.
 * 
 * @author harish.sharma
 *
 */
public class P15 {

    public static int solve(int[] a) {
        int len = a.length;
        int[] L = new int[len];

        if (len == 0 || a[0] == 0) return 0;

        L[0] = 0;
        for (int i = 1; i < len; i++) {
            L[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (i <= j + a[j] && L[j] != Integer.MAX_VALUE) {
                    L[i] = Math.min(L[i], L[j] + 1);
                    break;
                }
            }
        }
        return L[len - 1];
    }

    public static void main(String[] args) {
        int arr[] = { 1, 3, 6, 1, 0, 9};
        System.out.println(solve(arr));
    }
}
