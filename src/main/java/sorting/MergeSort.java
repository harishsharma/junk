package sorting;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author harish.sharma
 *
 */
@Slf4j
public class MergeSort {
    int[] back;

    public int[] sort(int[] a) {
        int end = a.length;
        int start = 0;
        back = new int[a.length];
        mergeSort(a, start, end - 1);
        return a;
    }

    private void mergeSort(int[] a, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            mergeSort(a, start, mid);
            mergeSort(a, mid + 1, end);
            merge(a, start, mid, end);
        }
    }

    private void merge(int[] a, int start, int mid, int end) {

        for (int i = start; i <= end; i++) {
            back[i] = a[i];
        }
        int i = start, j = mid + 1, k = start;
        while (i <= mid && j <= end) {
            if (back[i] <= back[j]) {
                a[k] = back[i];
                i++;
            } else {
                a[k] = back[j];
                j++;
            }
            k++;
        }

        while (i <= mid) {
            a[k++] = back[i++];
        }
        while (j <= end) {
            a[k++] = back[j++];
        }
    }

    public static void main(String[] args) {
        int[] a = { 1, 5, 3, 7, 9, 4, 8523, 12, 124, 24};
        log.debug("{}", new MergeSort().sort(a));
    }
}
