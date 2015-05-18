package hr;

import java.util.Scanner;

/**
 * 
 * @author harish.sharma
 *
 */
public class P3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long m = in.nextLong();
        int[] numTickets = new int[100001];
        for (int i = 0; i < n; i++) {
            int input = in.nextInt();
            numTickets[input] += 1;
        }
        System.out.println(solve(n, m, numTickets));
        in.close();
    }

    public static long solve(int n, long m, int[] numTickets) {
        long resSum = 0l;
        for (int i = 100000; i >= 1 && m > 0;) {
            if (numTickets[i] > 0) {
                long minNum = Math.min(m, numTickets[i]);
                resSum += i * minNum;
                numTickets[i] -= minNum;
                numTickets[i - 1] += minNum;
                m -= minNum;
            } else {
                i--;
            }
        }
        return resSum;
    }
}
