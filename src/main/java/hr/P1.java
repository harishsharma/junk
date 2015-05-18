package hr;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author harish.sharma
 *
 */
public class P1 {
    public static Long solve(final Integer n, final Long m, final Queue<Integer> heap) {
        if (n == 0 || m == 0) return 0l;
        Long tempM = m;
        Long totalProfit = 0l;
        while (tempM > 0) {
            Integer max = heap.remove();
            Integer currTop = heap.peek();
            if (currTop != null) {
                while (max >= currTop && tempM > 0) {
                    totalProfit += max;
                    tempM--;
                    max--;
                }
            }
            if (max != 1) heap.add(max);
        }
        return totalProfit;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long m = in.nextLong();
        Queue<Integer> heap = new PriorityQueue<>(n, Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            heap.add(in.nextInt());
        }
        System.out.println(solve(n, m, heap));
        in.close();
    }
}
