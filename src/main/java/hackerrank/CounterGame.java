package hackerrank;

import java.util.Scanner;

public class CounterGame {
    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            String a = in.next();
            Long num = Long.parseUnsignedLong(a);
            boolean isPowerOfTwo = (num & (num - 1)) == 0;
            boolean louseTurn = true;
            boolean first = true;
            while (num != 1) {
                isPowerOfTwo = (num & (num - 1)) == 0;
                if (!isPowerOfTwo) {
                    Long powOfTwo = Long.highestOneBit(num);
                    if (powOfTwo.equals(num)) {
                        powOfTwo = Long.highestOneBit(num - 1);
                    }
                    num = num - powOfTwo;
                } else {
                    num = num / 2;
                }
                if (first) {
                    louseTurn = true;
                    first = false;
                } else {
                    louseTurn = false;
                    first = true;
                }
            }

            if (louseTurn)
                System.out.println("Louise");
            else {
                System.out.println("Richard");
            }
        }
        in.close();
    }
}
