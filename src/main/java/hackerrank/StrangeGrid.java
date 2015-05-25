package hackerrank;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/strange-grid
 * 
 * @author harish.sharma
 *
 */
public class StrangeGrid {

    public static long solve(long r, long c) {
        long a = 1;
        if (r % 2 != 0) {
            r = r + 1;
            a = 0;
        }
        r /= 2;
        return a + (((r - 1) * 5 + c) - 1) * 2;
    }

    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        int r = in.nextInt();
        int c = in.nextInt();
        System.out.println(solve(r, c));
        in.close();
    }
}
