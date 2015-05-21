package hackerrank;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/grid-challenge
 * 
 * @author harish.sharma
 *
 */
public class GridChallenge {

    public static String solve(char[][] input) {
        int rows = input.length;
        int cols = input[0].length;
        if (rows == 1) return "YES";
        for (int i = 0; i < rows; i++) {
            sort(input[i], 0, cols);
        }
        for (int i = 0; i < cols; i++) {
            sortVertical(input, i, rows, cols);
            if (!checkValid(input, i, rows, cols)) return "NO";
        }
        return "YES";
    }

    private static boolean checkValid(char[][] input, int colNum, int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            if (colNum == 0) {
                if (input[i][colNum] > input[i][colNum + 1]) return false;
            } else if (colNum == cols - 1) {
                if (input[i][colNum] < input[i][colNum - 1]) return false;
            } else {
                if (input[i][colNum] > input[i][colNum + 1] || input[i][colNum] < input[i][colNum - 1]) return false;
            }
        }
        return true;
    }

    private static void sortVertical(char[][] cs, int colNum, int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            for (int j = i + 1; j < cols; j++) {
                if (cs[i][colNum] > cs[j][colNum]) {
                    char temp = cs[i][colNum];
                    cs[i][colNum] = cs[j][colNum];
                    cs[j][colNum] = temp;
                }
            }
        }
    }

    private static void sort(char[] cs, int start, int end) {
        for (int i = start; i < end; i++) {
            for (int j = i + 1; j < end; j++) {
                if (cs[i] > cs[j]) swap(cs, i, j);
            }
        }
    }


    private static void swap(char[] cs, int i, int j) {
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            char[][] input = new char[n][n];
            for (int j = 0; j < n; j++) {
                input[j] = in.next().toCharArray();
            }
            System.out.println(solve(input));
        }
        in.close();
    }
}
