package AlgoManual;

/**
 * Created by harish.sharma on 2/27/16.
 */
public class BinarySearch {

    public static int search(int[] arr, int key) {
        int len = arr.length - 1;
        if (key < arr[0] || key > arr[len]) {
            return -1;
        }
        int start = 0, end = len;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == key) {
                if (mid > 0 && arr[mid - 1] != key)
                    return mid;
                end = mid - 1;
            } else if (arr[mid] > key) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] arf) {
        int[] a = {1, 2, 2, 2, 3, 3, 3, 3, 4, 5, 6, 7};
        System.out.println(search(a, 7));
        System.out.println(search(a, 2));
        System.out.println(search(a, 3));
        System.out.println(search(a, -1));
    }
}
