package hackerrank;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/quicksort3
 * 
 * @author harish.sharma
 *
 */
public class QuickSort3 {
    public static int[] sort(int[] a) {
        int start = 0, end = a.length - 1;
        quickSort(a, start, end);
        return a;
    }

    private static void quickSort(int[] a, int start, int end) {
        if (start < end) {
            int partition = partition(a, start, end);
            quickSort(a, start, partition - 1);
            quickSort(a, partition + 1, end);
        }
    }

    private static int partition(int[] a, int start, int end) {
        int pivot = a[end];
        int i = start, j = end - 1;
        for (; i < j;) {
            while (a[i] <= pivot) {
                if (i >= j) break;
                i++;
            }
            while (a[j] > pivot) {
                if (i >= j) break;
                j--;
            }
            if (i != j) swap(a, i, j);
        }
        int res = end;
        if (a[i] > a[end]) {
            swap(a, i, end);
            res = i;
        }
        for (int k = 0; k < a.length; k++) {
            System.out.print(a[k] + " ");
        }
        System.out.println();
        return res;
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        sort(a);
        in.close();
    }
}
