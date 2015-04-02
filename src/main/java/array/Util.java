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


    /*
     * Return if the array segment between start and end is palindrom.
     */
    public static boolean isPalindrom(final char[] array, int start, int end) {
        int mid = start + (end - start) / 2;
        boolean isPalindrom = true;
        for (int i = 0; start + i <= mid; i++) {
            if (array[start + i] != array[end - i]) {
                isPalindrom = false;
                break;
            }
        }
        return isPalindrom;
    }

}
