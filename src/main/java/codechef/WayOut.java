package codechef;

import java.util.Scanner;

/**
 * https://www.codechef.com/AUG15/problems/WOUT
 * 
 * @author harish.sharma
 *
 */
class WayOut {
    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int dim = in.nextInt();
            int height = in.nextInt();
            long[] arr = new long[dim + 1];
            for (int j = 0; j < dim; j++) {
                int st = in.nextInt();
                int end = in.nextInt();
                arr[st] += 1;
                arr[end + 1] -= 1;
            }
            for (int k = 1; k < dim; k++) {
                arr[k] = arr[k] + arr[k - 1];
            }
            solve(arr, height);

        }
        in.close();
    }

    private static void solve(long[] arr, int height) {
        int size = arr.length - 1;
        int prev = (int) arr[0];
        long curSum = 0;
        long minAns = Long.MAX_VALUE;
        for (int i = 0; i < height; i++) {
            curSum += arr[i];
        }
        minAns = Math.min(height * size - curSum, minAns);
        for (int i = height; i < size; i++) {
            prev = i - height;
            curSum = curSum - arr[prev] + arr[i];
            minAns = Math.min(height * size - curSum, minAns);
        }
        System.out.println(minAns);
    }
}
