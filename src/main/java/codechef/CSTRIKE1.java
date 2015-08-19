package codechef;

import java.util.Scanner;

/**
 * https://www.codechef.com/COSE2015/problems/CSTRIKE1
 * 
 * @author harish.sharma
 *
 */
class CSTRIKE1 {
    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int[] ar = new int[n];
            for (int j = 0; j < n; j++) {
                ar[j] = in.nextInt();
            }
            boolean res = solve(ar);
            if (res)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
        in.close();
    }

    private static boolean solve(int[] ar) {
        if (ar.length == 1) return false;

        int sum = 0;
        for (int i = 0; i < ar.length; i++) {
            sum += ar[i];
        }
        if (sum % 2 != 0) return false;

        return isSolvable(ar, ar.length, sum / 2);
    }

    private static boolean isSolvable(int[] ar, int n, int sum) {
        if (sum == 0) return true;
        if (n == 0 && sum != 0) return false;
        if (ar[n - 1] > sum) return isSolvable(ar, n - 1, sum);
        return isSolvable(ar, n - 1, sum - ar[n - 1]) || isSolvable(ar, n - 1, sum);
    }
}
