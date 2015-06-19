package hackerrank;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/and-product
 * 
 * @author harish.sharma
 *
 */
public class AndProduct {
    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            long a = in.nextLong();
            long b = in.nextLong();
            System.out.println(solve(a, b));
        }
        in.close();
    }

    private static long solve(long a, long b) {
        long diff = a ^ b;

        diff |= diff >> 1;
        diff |= diff >> 2;
        diff |= diff >> 4;
        diff |= diff >> 8;
        diff |= diff >> 16;
        diff |= diff >> 32;

        return a & ~diff;
    }
}
