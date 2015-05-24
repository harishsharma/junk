package hackerrank;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/bigger-is-greater
 * 
 * @author harish.sharma
 *
 */
public class BiggerIsGreater {

    public static String solve(String input) {
        char[] aStr = input.toCharArray();
        int len = aStr.length;
        int i;
        if (len <= 1) return "no answer";
        for (i = len - 1; i > 1; i--) {
            if (aStr[i] > aStr[i - 1]) break;
        }
        if (i == 1 && aStr[i] <= aStr[i - 1]) return "no answer";
        int ele = aStr[i - 1] - 'a';
        int minMax = aStr[i] - 'a';
        int minMaxIdx = i;
        for (int j = i; j < len; j++) {
            int cur = aStr[j] - 'a';
            if (cur < minMax && cur > ele) {
                minMax = cur;
                minMaxIdx = j;
            }
        }
        swap(aStr, i - 1, minMaxIdx);
        sort(aStr, i, len);
        return new String(aStr);
    }

    private static void sort(char[] aStr, int i, int len) {
        for (int j = i; j < len; j++) {
            for (int k = j + 1; k < len; k++) {
                if (aStr[j] > aStr[k]) {
                    swap(aStr, j, k);
                }
            }
        }
    }

    private static void swap(char[] aStr, int j, int k) {
        char temp = aStr[j];
        aStr[j] = aStr[k];
        aStr[k] = temp;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            System.out.println(solve(in.next()));
        }
        in.close();
    }
}
