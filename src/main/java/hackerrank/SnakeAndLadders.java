package hackerrank;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

/**
 * Standard snake and ladder problem.
 * 
 * @author harish.sharma
 *
 */
public class SnakeAndLadders {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            Map<Integer, Integer> mapOfSnakesAndLadders = new HashMap<>();
            for (int j = 0; j < n; j++) {
                mapOfSnakesAndLadders.put(in.nextInt(), in.nextInt());
            }
            int m = in.nextInt();
            for (int j = 0; j < m; j++) {
                mapOfSnakesAndLadders.put(in.nextInt(), in.nextInt());
            }
            System.out.println(solve(mapOfSnakesAndLadders));
        }
        in.close();
    }

    private static int solve(Map<Integer, Integer> mapOfSnakesAndLadders) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        int[] values = new int[101];
        boolean finished = false;
        int res = -1;
        while (!queue.isEmpty() && !finished) {
            int head = queue.poll();
            for (int i = 1; i <= 6; i++) {
                int next = mapOfSnakesAndLadders.containsKey(head + i) ? mapOfSnakesAndLadders.get(head + i) : head + i;
                if (values[next] == 0) {
                    values[next] = values[head] + 1;
                    queue.add(next);
                }
                if (next == 100) {
                    finished = true;
                    res = next;
                    break;
                }
            }
        }
        if (res > 0) {
            return values[res];
        }
        return -1;
    }
}
