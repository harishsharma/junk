package hackerrank;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/cube-summation
 * 
 * @author harish.sharma
 *
 */
public class CubeSum {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            long[][][] ar = new long[n + 1][n + 1][n + 1];
            int m = in.nextInt();
            for (int j = 0; j < m; j++) {
                String a = in.next();
                if (a.startsWith("UPDATE")) {
                    update(ar, in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt());
                } else {
                    int x1 = in.nextInt();
                    int y1 = in.nextInt();
                    int z1 = in.nextInt();
                    int x2 = in.nextInt();
                    int y2 = in.nextInt();
                    int z2 = in.nextInt();
                    System.out.println(query(ar, x1, y1, z1, x2, y2, z2));
                }
            }
        }
        in.close();
    }

    private static long query(long[][][] ar, int x1, int y1, int z1, int x2, int y2, int z2) {
        long sum = 0l;
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                for (int k = z1; k <= z2; k++) {
                    sum += ar[i][j][k];
                }
            }
        }
        return sum;
    }

    private static void update(long[][][] ar, int a, int b, int c, long w) {
        ar[a][b][c] = w;
    }

}
