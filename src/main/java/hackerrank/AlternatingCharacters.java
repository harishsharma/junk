package hackerrank;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/alternating-characters
 * 
 * @author harish.sharma
 *
 */
public class AlternatingCharacters {

    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            String a = in.next();
            System.out.println(solve(a));
        }
        in.close();
    }

    private static int solve(String a) {
        char[] ar = a.toCharArray();
        int len = a.length();
        int count = 0;
        if (len == 0 || len == 1) return len;
        for (int i = 1; i < len; i++) {
            if (ar[i] == ar[i - 1]) count++;
        }
        return count;
    }
}
