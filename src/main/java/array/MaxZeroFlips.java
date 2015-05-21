package array;

/**
 * Given an array of 1's and 0's flips all 1's and 0's between two indexes such that total 1's are maximum after the
 * flip. Find those two indexes.
 * 
 * @author harish.sharma
 *
 */
public class MaxZeroFlips {

    public static Pair<Integer, Integer> solve(int[] a) {
        int len = a.length;
        for (int i = 0; i < len; i++) {
            a[i] = (a[i] == 1) ? -1 : 1;
        }

        int start = 0, maxStart = 0, end = 0, maxEnd = 0;
        int sum = 0, maxSum = 0;
        for (int i = 0; i < len; i++) {
            sum += a[i];
            if (sum > maxSum) {
                maxStart = start;
                maxEnd = end;
                maxSum = sum;
            }
            if (sum < 0) {
                start = i + 1;
                sum = 0;
            }
            end++;
        }
        return Pair.of(maxStart, maxEnd);
    }

    public static void main(String[] args) {
        int[] a = { 1, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0};
        System.out.println(solve(a));
    }
}
