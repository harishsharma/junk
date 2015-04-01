package array;

public class Util {

    /*
     * reverse array between these indexes inclusive.
     */
    public static void reverse(final int[] a, final int begin, final int end) {
        int mid = begin + (end - begin) / 2;
        for (int i = 0; begin + i <= mid; i++) {
            swap(a, begin + i, end - i);
        }
    }

    /*
     * swap the items at input indexes. Indexes should be in bound.
     */
    public static void swap(final int[] array, final int indexA, final int indexB) {
        int t = array[indexA];
        array[indexA] = array[indexB];
        array[indexB] = t;
    }

}
