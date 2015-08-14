package codechef;

import java.util.Scanner;

/**
 * https://www.codechef.com/AUG15/problems/COOKMACH
 * 
 * @author harish.sharma
 *
 */
class CookingMachine {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(solve(a, b));
        }
        in.close();
    }

    private static int solve(int a, int b) {
        if (a == b) return 0;
        if (isPowOf2(a)) {
            return Math.abs(log2(a) - log2(b));
        } else {
            int x = a;
            int count = 0;
            while (!isPowOf2(x)) {
                if (x % 2 == 0)
                    x = x / 2;
                else
                    x = (x - 1) / 2;
                count++;
            }
            return Math.abs(log2(x) - log2(b)) + count;
        }
    }

    private static int log2(int a) {
        return 31 - Integer.numberOfLeadingZeros(a);
    }

    private static boolean isPowOf2(int a) {
        return ((a & (a - 1)) == 0);
    }
}
