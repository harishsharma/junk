package AlgoManual;

/**
 * Created by harish.sharma on 2/28/16.
 */
public class Sorted {

    public static void sorted(int[] arr) {

        int redPos = 0, blackPos = arr.length - 1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                swap(arr, redPos, i);
                redPos++;

            } else if (arr[i] == 2) {
                swap(arr, blackPos, i);
                blackPos--;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] arg) {
        int[] a = {1, 2, 0, 0, 2, 1, 2};
        sorted(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(" " + a[i]);
        }
    }
}
