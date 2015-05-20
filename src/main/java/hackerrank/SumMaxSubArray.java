package hackerrank;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/maxsubarray
 * 
 * @author harish.sharma
 *
 */
public class SumMaxSubArray {

    public static long contiguous(int[] a) {
        int len = a.length;
        long maxSofar = a[0];
        long maxOfAll = a[0];
        for (int i = 1; i < len; i++) {
            maxSofar = Math.max(a[i], a[i] + maxSofar);
            maxOfAll = Math.max(maxOfAll, maxSofar);
        }
        return maxOfAll;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int j = 0; j < t; j++) {
            int n = in.nextInt();
            int[] arr = new int[n];
            long nonContiguous = 0l;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                int input = in.nextInt();
                max = Math.max(max, input);
                if (input > 0) nonContiguous += input;
                arr[i] = input;
            }
            if (max < 0) nonContiguous = max;
            System.out.println(contiguous(arr) + " " + nonContiguous);
        }
        in.close();
    }
}
