package codechef;

import java.util.Scanner;

/**
 * https://www.codechef.com/problems/PRIME1
 * 
 * @author harish.sharma
 *
 */
class Prime1 {

    private static final int   CONST    = 1004000001;
    private static final int   SQRTCONT = (int) Math.sqrt(CONST);
    private static final int[] seives   = new int[SQRTCONT + 2];

    public static void preprocess() {
        boolean[] primes = new boolean[SQRTCONT + 1];
        for (int i = 2; i * i < SQRTCONT; i++) {
            if (primes[i] == false) {
                for (int j = i; i * j < SQRTCONT; j++) {
                    primes[i * j] = true;
                }
            }
        }

        for (int i = 2, j = 0; i <= SQRTCONT; i++) {
            if (primes[i] == false) {
                seives[j++] = i;
            }
        }
    }

    public static void solve(int a, int b) {
        a = a < 2 ? 2 : a;
        for (int i = a; i <= b; i++) {
            boolean isPrime = true;
            for (int j = 0; seives[j] * seives[j] <= i; j++) {
                if (i % seives[j] == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) System.out.println(i);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        preprocess();
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            solve(a, b);
        }
        in.close();
    }
}
