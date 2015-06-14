package hackerrank;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/chief-hopper
 * 
 * @author harish.sharma
 *
 */
public class ChiefHopper {

    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] a = new long[n];
        long min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            min = Math.min(min, a[i]);
            max = Math.max(max, a[i]);
        }
        System.out.println(solve(a, min, max));
        in.close();
    }

    public static long solve(long[] a, long min, long max) {
        if (a.length == 1) {
            min = 0;
            max = a[0];
        }
        if (min == max) {
            min = 0;
        }
        while (min < max) {
            long mid = min + (max - min) / 2;
            long botEnergy = result(a, mid);
            if (botEnergy == 0)
                return mid;
            else if (botEnergy > 0) {
                if (max - min == 1 || max - min == 2) {
                    if (result(a, min) >= 0)
                        return min;
                    else if (result(a, mid) >= 0)
                        return mid;
                    else
                        return max;
                }
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return max;
    }

    private static long result(long[] a, long v) {
        long botEnergy = v;
        for (int i = 0; i < a.length; i++) {
            if (botEnergy > 100002) return 1;
            if (a[i] > botEnergy) {
                botEnergy = botEnergy - (a[i] - botEnergy);
            } else {
                botEnergy += (botEnergy - a[i]);
            }
            if (botEnergy < 0) return botEnergy;
        }
        return botEnergy;
    }
}
