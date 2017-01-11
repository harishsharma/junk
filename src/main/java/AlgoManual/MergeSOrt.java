package AlgoManual;

/**
 * Created by harish.sharma on 3/2/16.
 */
public class MergeSort {

    private static int[] back;

    public static int[] sort(int[] input) {
        int start = 0, end = input.length - 1;
        back = new int[input.length];
        sort(input, start, end);
        return input;
    }

    private static void sort(int[] input, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            sort(input, start, mid);
            sort(input, mid + 1, end);
            merge(input, start, mid, end);
        }
    }

    private static void merge(int[] input, int start, int mid, int end) {
        for (int i = start; i <= end; i++) {
            back[i] = input[i];
        }

        int i = start;
        int j = mid + 1;
        int k = start;
        while (i <= mid && j <= end) {
            if (back[i] > back[j]) {
                input[k] = back[j];
                k++;
                j++;
            } else {
                input[k] = back[i];
                k++;
                i++;
            }
        }

        while (i <= mid) {
            input[k] = back[i];
            k++;
            i++;
        }

        while (j <= end) {
            input[k] = back[j];
            k++;
            j++;
        }
    }

    public static void main(String[] arg) {
        int[] a = {3, 4, 5, 4, 4, 4, 4, 7, 2, 1, 8};
        sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(" " + a[i]);
        }
    }
}
