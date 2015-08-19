package codechef;

import java.util.Scanner;

/**
 * https://www.codechef.com/problems/MARBLES
 * 
 * @author harish.sharma
 *
 */
class MARBLES {
    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int k = in.nextInt();
            solve(n - 1, n - k);
        }
        in.close();
    }

    private static void solve(int n, int k) {
        long nck = 1;
        k = (n - k) < k ? n - k : k;
        for (int i = 0; i < k; i++) {
            nck = (nck * (n - i)) / (i + 1);
        }
        System.out.println(nck);
    }
}
