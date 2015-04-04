package array;

/**
 * 
 * @author harish.sharma
 *
 */
public class BinarySearch {

    public static boolean search(final int[] a, final int item) {
        int begin = 0;
        int end = a.length - 1;
        int mid;
        while (begin <= end) {
            mid = begin + (end - begin) / 2;
            if (a[mid] > item) {
                end = mid - 1;
            } else if (a[mid] < item) {
                begin = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4, 5};
        System.out.println(BinarySearch.search(a, 1));
        System.out.println(BinarySearch.search(a, 2));
        System.out.println(BinarySearch.search(a, 3));
        System.out.println(BinarySearch.search(a, 5));
        System.out.println(BinarySearch.search(a, 4));
        System.out.println(BinarySearch.search(a, 11));
    }
}
