package hackerrank;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/flipping-bits
 * 
 * @author harish.sharma
 *
 */
public class FlippingBits {
    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            long n = in.nextLong();
            System.out.println(solve(n));
        }
        in.close();
    }

    private static long solve(long n) {
        long res = 0;
        for (int k = 0; k < 32; k++) {
            long temp = n;
            long bit = (temp >> k) & 1;
            if (bit == 0) {
                res += Math.pow(2, k);
            }
        }
        return res;
    }
}
