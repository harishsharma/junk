package array;

import java.util.function.Function;

/**
 * https://www.topcoder.com/community/data-science/data-science-tutorials/binary-search/
 * 
 * @author harish.sharma
 *
 */
public class AbstractBinarySearch {


    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(search(a, x -> x >= 3));
    }

    public static int search(int[] array, Function<Integer, Boolean> predicate) {
        return searchInternal(array, 0, array.length - 1, predicate);
    }

    private static int searchInternal(int[] array, int low, int high, Function<Integer, Boolean> predicate) {
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (predicate.apply(array[mid])) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        if (predicate.apply(array[low]) == false) return -1;
        return low;
    }
}
