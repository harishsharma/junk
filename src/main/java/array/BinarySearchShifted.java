package array;

import java.util.Arrays;

/**
 * An element in a sorted array can be found in O(log n) time via binary search. But suppose I rotate the sorted array
 * at some pivot unknown to you beforehand. So for instance, 1 2 3 4 5 might become 3 4 5 1 2. Devise a way to find an
 * element in the rotated array in O(log n) time.
 * 
 * @author harish.sharma
 *
 */
public class BinarySearchShifted {

    public boolean solve(int[] a, int k) {
        int pivot = findPivot(a);
        if (pivot == -1)
            return BinarySearch.search(a, k);
        else {
            return BinarySearch.search(Arrays.copyOfRange(a, 0, pivot + 1), k)
                    || BinarySearch.search(Arrays.copyOfRange(a, pivot + 1, a.length), k);
        }
    }

    private int findPivot(int[] a) {
        int start = 0, end = a.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid < end && a[mid] > a[mid + 1]) {
                return mid;
            } else if (a[start] > a[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = { 3, 4, 5, 6, 7, 8, 1, 2};
        System.out.println(new BinarySearchShifted().solve(a, 10));
    }
}
