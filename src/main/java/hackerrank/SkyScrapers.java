package hackerrank;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * https://www.hackerrank.com/challenges/jim-and-the-skyscrapers
 * 
 * @author harish.sharma
 *
 */
public class SkyScrapers {

    public static long solve(int[] a, int[] heights) {
        int len = a.length;
        Set<Integer> set = new HashSet<>();
        long sol = 0l;
        for (int i = 0; i < len; i++) {
            int intesest = a[i];
            int prevCount = 1;
            long res = 0l;
            if (set.contains(a[i])) continue;
            if (heights[a[i]] < 2) continue;
            for (int j = i + 1; j < len; j++) {
                if (a[j] > intesest) {
                    sol += res * 2;
                    prevCount = 0;
                    res = 0l;
                }
                if (a[j] == intesest) {
                    prevCount++;
                    res += prevCount - 1;
                }
            }
            sol += res * 2;
            res = 0l;
            set.add(a[i]);
        }
        return sol;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        int[] height = new int[1000000];
        for (int i = 0; i < n; i++) {
            int input = in.nextInt();
            a[i] = input;
            height[input] += 1;
        }
        System.out.println(solve(a, height));
        in.close();
    }
}
