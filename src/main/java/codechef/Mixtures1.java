package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.codechef.com/problems/MIXTURES
 * 
 * @author harish.sharma
 *
 */
class Mixtures1 {
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in = null;
        while ((in = br.readLine()) != null) {
            int n = Integer.parseInt(in);
            int[] arr = new int[n];
            String x = br.readLine();
            String[] a = x.split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(a[i]);
            }
            System.out.println(solve(arr));
        }

        br.close();
    }

    private static int solve(int[] arr) {
        int len = arr.length;
        if (len == 1) {
            return arr[0];
        } else if (len == 2)
            return arr[0] * arr[1];
        else {
            return solvePrivate(arr, 0, len - 1);
        }
    }

    private static int solvePrivate(int[] arr, int start, int end) {
        if (end - start == 1) return arr[start] * arr[end];
        int mix = Integer.MAX_VALUE;
        for (int i = start + 1; i <= end; i++) {
            int back = arr[i];
            int temp = (arr[i - 1] + arr[i]) % 100;
            arr[i] = temp;
            int k = start;
            while (k != i) {

            }
        }
        return mix;
    }
}
