package hackerrank;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/direct-connections
 * 
 * @author harish.sharma
 *
 */
public class DIrectConnection {

    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            long[] cords = new long[n];
            long[] population = new long[n];
            for (int j = 0; j < n; j++) {
                cords[j] = in.nextLong();
            }
            for (int j = 0; j < n; j++) {
                population[j] = in.nextLong();
            }
            System.out.println(solve(cords, population));
        }
        in.close();
    }

    private static long solve(long[] cords, long[] population) {
        int len = cords.length;
        long sum = 0l;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                sum += (Math.abs(cords[j] - cords[i])) * Math.max(population[i], population[j]);
                sum %= 1000000007;
            }
        }
        return sum;
    }
}
