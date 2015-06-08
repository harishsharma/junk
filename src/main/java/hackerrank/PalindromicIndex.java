package hackerrank;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/palindrome-index
 * 
 * @author harish.sharma
 *
 */
public class PalindromicIndex {
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
        int index = -1;
        char[] ar = a.toCharArray();
        int len = ar.length;
        for (int i = 0, j = len - 1; i < j; i++, j--) {
            if (ar[i] != ar[j]) {
                if (ar[i + 1] == ar[j] && ar[i + 2] == ar[j - 1]) {
                    return i;
                } else
                    return j;
            }
        }
        return index;
    }
}
