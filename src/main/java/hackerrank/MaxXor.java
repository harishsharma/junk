package hackerrank;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/maximizing-xor
 * 
 * @author harish.sharma
 *
 */
public class MaxXor {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int l = in.nextInt();
        int r = in.nextInt();
        int curMax = Integer.MIN_VALUE;
        for (int i = l; i <= r; i++) {
            for (int j = l + 1; j <= r; j++) {
                curMax = Math.max(curMax, i ^ j);
            }
        }
        System.out.println(curMax);
        in.close();
    }
}
