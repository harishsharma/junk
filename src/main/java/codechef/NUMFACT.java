package codechef;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.codechef.com/problems/NUMFACT
 * 
 * @author harish.sharma
 *
 */
class NUMFACT {

    private static int           size   = 1000000;
    private static boolean[]     arr    = new boolean[size + 1];
    private static List<Integer> primes = new ArrayList<>();
    static {
        for (int i = 2; i <= size; i++) {
            if (arr[i] != true) {
                for (int j = 2; i * j < size; j++) {
                    arr[i * j] = true;
                }
            }
        }

        for (int i = 2; i < size; i++) {
            if (arr[i] != true) primes.add(i);
        }
    }

    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            int[] a = new int[1000001];
            for (int j = 0; j < num; j++) {
                int val = in.nextInt();
                for (int k : primes) {
                    int count = 0;
                    while (val % k == 0) {
                        val = val / k;
                        count++;
                    }
                    a[k] = a[k] + count;
                }
            }
            long res = 1;
            for (int k : primes) {
                res = res * (a[k] + 1);
            }
            System.out.println(res);
        }
        in.close();
    }
}
