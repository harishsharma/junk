package array;

import lombok.extern.slf4j.Slf4j;

/**
 * Count Inversions in an array.
 * 
 * @author harish.sharma
 *
 */
@Slf4j
public class P21 {

    int[] back;

    public int solve(int[] a) {
        back = new int[a.length];
        return mergeSort(a, 0, a.length - 1);
    }

    private int mergeSort(int[] a, int start, int end) {
        int inv = 0;
        if (start < end) {
            int mid = start + (end - start) / 2;
            inv = mergeSort(a, start, mid);
            inv += mergeSort(a, mid + 1, end);
            inv += merge(a, start, mid, end);
        }
        return inv;
    }

    private int merge(int[] a, int start, int mid, int end) {
        int inv = 0;
        for (int i = start; i <= end; i++) {
            back[i] = a[i];
        }

        int i = start, j = mid + 1, k = start;
        while (i <= mid && j <= end) {
            if (back[i] <= back[j]) {
                a[k++] = back[i++];
            } else {
                a[k++] = back[j++];
                inv += mid - i + 1;
            }
        }

        while (i <= mid) {
            a[k++] = back[i++];
        }
        while (j <= end) {
            a[k++] = back[j++];
        }
        return inv;
    }

    public static void main(String[] args) {
        int[] a = { 4, 1, 7, 2, 5, 8};
        log.debug("{}", new P21().solve(a));
    }
}
