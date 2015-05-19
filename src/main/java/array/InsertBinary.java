package array;

/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it
 * would be if it were inserted in order. You may assume no duplicates in the array.
 * 
 * Here are few examples.
 * 
 * [1,3,5,6], 5 -> 2 [1,3,5,6], 2 -> 1 [1,3,5,6], 7 -> 4 [1,3,5,6], 0 -> 0
 * 
 * @author harish.sharma
 *
 */
public class InsertBinary {
    public int sovle(final int[] a, final int k) {
        int start = 0, end = a.length - 1;
        int mid = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (a[mid] > k) {
                end = mid - 1;
            } else if (a[mid] < k) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        int[] a = { 1, 3, 5, 6};
        System.out.println(new InsertBinary().sovle(a, 5));
        System.out.println(new InsertBinary().sovle(a, 2));
        System.out.println(new InsertBinary().sovle(a, 7));
        System.out.println(new InsertBinary().sovle(a, 0));
        int[] aa = { 1, 3, 5, 6, 12, 14, 56};
        System.out.println(new InsertBinary().sovle(aa, 12));
        System.out.println(new InsertBinary().sovle(aa, 13));
        System.out.println(new InsertBinary().sovle(aa, 14));
    }
}
