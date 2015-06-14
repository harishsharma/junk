package hackerrank;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 
 * @author harish.sharma
 *
 */
public class QuickestWayUp {

    private static int solve(int[] moveMap) {
        int[] minMove = new int[101];
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(1);
        boolean finished = false;
        while (!queue.isEmpty() && !finished) {
            int cell = queue.poll();
            for (int i = 1; i <= 6; ++i) {
                int newCell = moveMap[cell + i] == 0 ? cell + i : moveMap[cell + i];
                if (minMove[newCell] == 0) {
                    minMove[newCell] = minMove[cell] + 1;
                    queue.add(newCell);
                }
                if (newCell == 100) {
                    finished = true;
                    break;
                }
            }
        }
        int res = -1;
        if (minMove[100] != 0) {
            res = minMove[100];
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int[] moveMap = new int[101];
            int n = in.nextInt();
            for (int j = 0; j < n; j++) {
                moveMap[in.nextInt()] = in.nextInt();
            }
            int m = in.nextInt();
            for (int j = 0; j < m; j++) {
                moveMap[in.nextInt()] = in.nextInt();
            }
            System.out.println(solve(moveMap));
        }
        in.close();
    }
}
