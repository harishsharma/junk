package codechef;

import java.util.Scanner;

/**
 * https://www.codechef.com/AUG15/problems/ADMAG
 * 
 * @author harish.sharma
 *
 */
class MagicTrick {
    static Long[] fibs;
    static {
        fibs = new Long[101];
        fibs[0] = 0l;
        fibs[1] = 1l;
        fibs[2] = 2l;
        for (int i = 3; i < 100; i++) {
            fibs[i] = fibs[i - 1] + fibs[i - 2];
        }
    }

    private static int binSearch(int low, int high, long n) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (fibs[mid] == n) {
                return mid;
            } else if (fibs[mid] < n) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        if (fibs[low] > n) return low - 1;
        return low;
    }

    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            long num = in.nextLong();
            solve(num);
        }
        in.close();
    }

    private static void solve(long num) {
        System.out.println(binSearch(0, 100, num));
    }
}
