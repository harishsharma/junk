package sorting;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author harish.sharma
 *
 */
@Slf4j
public class QuickSort {

    public int[] sort(int[] a) {
        int start = 0, end = a.length - 1;
        quickSort(a, start, end);
        return a;
    }

    private void quickSort(int[] a, int start, int end) {
        if (start < end) {
            int partition = partition(a, start, end);
            quickSort(a, start, partition - 1);
            quickSort(a, partition + 1, end);
        }
    }

    private int partition(int[] a, int start, int end) {
        int pivot = a[end];
        int i = start, j = end;
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
        if (a[i] > a[end]) swap(a, i, end);
        return i;
    }

    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        int[] a = { 5, 2, 1, 9, 7, 3, 4, 5723, 53, 38};
        log.debug("{}", new QuickSort().sort(a));
    }
}
