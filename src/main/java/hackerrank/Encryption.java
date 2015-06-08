package hackerrank;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/encryption
 * 
 * @author harish.sharma
 *
 */
public class Encryption {
    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        solve(a);
        in.close();
    }

    private static void solve(String a) {
        int len = a.length();
        int nearRoot = (int) Math.sqrt(len);
        int rows = nearRoot;
        int cols = nearRoot;
        while (rows * cols < len) {
            if (cols <= rows)
                cols++;
            else
                rows++;
        }
        char[][] res = new char[rows][cols];
        char[] aa = a.toCharArray();
        char c = res[0][0];
        int count = len;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (--count >= 0) res[i][j] = aa[i * cols + j];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                if (res[j][i] != c) sb.append(res[j][i]);
            }
            sb.append((char) ' ');
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
    }
}
