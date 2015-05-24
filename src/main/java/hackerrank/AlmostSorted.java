package hackerrank;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/almost-sorted
 * 
 * @author harish.sharma
 *
 */
public class AlmostSorted {

    public static void solve(int[] a) {
        int len = a.length;
        int count = 0;
        int badIndex1 = 0;
        int badIndex2 = 0;
        boolean f = true;
        for (int i = 1; i < len - 1; i++) {
            if (a[i] > a[i + 1]) {
                count++;
                if (f) {
                    badIndex1 = i + 1;
                    f = false;
                }
                badIndex2 = i + 1;
            }
        }
        if (count == 0) System.out.println("yes");
        if (count == 1 || count == 2) {
            int ele = a[badIndex1];
            int i = 1;
            for (; i < badIndex1; i++) {
                if (a[i] < ele) continue;
                break;
            }
            if (badIndex2 != badIndex1)
                swap(a, badIndex1 - 1, badIndex2);
            else
                swap(a, i, badIndex1);
            if (a[i] > a[i - 1] && a[i] < a[i + 1] && a[badIndex1] > a[badIndex1 - 1]) {
                if (badIndex1 < len - 1 && a[badIndex1] > a[badIndex1 + 1]) {
                    System.out.println("no");
                } else {
                    System.out.println("yes");
                    if (badIndex1 != badIndex2)
                        System.out.println("swap " + (badIndex1 - 1) + " " + badIndex2);
                    else
                        System.out.println("swap " + i + " " + badIndex1);
                }
            } else
                System.out.println("no");
        } else {
            int start = 1, end = 1;
            boolean first = true;
            for (int i = 1; i < len - 1; i++) {
                if (a[i] > a[i + 1]) {
                    if (first) {
                        start = i;
                        first = false;
                    } else
                        end = i + 1;
                }
            }
            reverse(a, start, end);
            if (sorted(a)) {
                System.out.println("yes");
                System.out.println("reverse " + start + " " + end);
            }
        }
    }

    private static boolean sorted(int[] a) {
        int i = 1;
        for (; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) break;
        }
        if (i + 1 == a.length) return true;
        return false;
    }

    private static void reverse(int[] a, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            swap(a, i, j);
        }
    }

    private static void swap(int[] a, int i, int badIndex) {
        int t = a[i];
        a[i] = a[badIndex];
        a[badIndex] = t;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = in.nextInt();
        }
        solve(a);
        in.close();
    }
}
