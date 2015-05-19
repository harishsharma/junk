package array;

import lombok.extern.slf4j.Slf4j;

/**
 * Given an array which is sorted, but after sorting some elements are moved to either of the adjacent positions, i.e.,
 * arr[i] may be present at arr[i+1] or arr[i-1]. Write an efficient function to search an element in this array.
 * Basically the element arr[i] can only be swapped with either arr[i+1] or arr[i-1].
 * 
 * @author harish.sharma
 *
 */
@Slf4j
public class BinarySearchModified {

    public boolean solve(int[] a, int k) {
        int start = 0;
        int end = a.length - 1;
        return search(a, start, end, k);
    }

    private boolean search(int[] a, int start, int end, int k) {
        if (start <= end) {
            int mid = start + (end - start) / 2;
            if (a[mid] < k) {
                if (mid - 1 >= start && a[mid - 1] == k) return true;
                return search(a, mid + 1, end, k);
            } else if (a[mid] > k) {
                if (mid + 1 <= end && a[mid + 1] == k) return true;
                return search(a, start, mid - 1, k);
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = { 10, 3, 40, 20, 50, 80, 70};
        log.debug("{}", new BinarySearchModified().solve(a, 10));
        log.debug("{}", new BinarySearchModified().solve(a, 20));
        log.debug("{}", new BinarySearchModified().solve(a, 3));
        log.debug("{}", new BinarySearchModified().solve(a, 40));
        log.debug("{}", new BinarySearchModified().solve(a, 50));
        log.debug("{}", new BinarySearchModified().solve(a, 940));
        log.debug("{}", new BinarySearchModified().solve(a, 90));
        log.debug("{}", new BinarySearchModified().solve(a, 00));
        log.debug("{}", new BinarySearchModified().solve(a, 9090));
    }
}
