package array;

/**
 * K’th Smallest/Largest Element in Unsorted Array. Or quick select.
 * 
 * @author harish.sharma
 *
 */
public class QuickSelect {
    public int solve(int[] a, int k) {
        int start = 0;
        int end = a.length - 1;
        return quickSelect(a, start, end, k);
    }

    private int quickSelect(int[] a, int start, int end, int k) {
        int partition = partition(a, start, end, k);
        if (partition == k)
            return a[k];
        else if (partition < k) {
            return quickSelect(a, partition + 1, end, k - partition);
        } else {
            return quickSelect(a, start, partition - 1, k);
        }
    }

    private int partition(int[] a, int start, int end, int k) {
        int pivot = a[end];
        int i = start, j = end;
        for (; i < j;) {
            while (a[i] <= pivot) {
                if (i >= j) break;
                i++;
            }
            while (a[j] > pivot) {
                if (i >= j) break;
                j--;
            }
            if (i < j) Util.swap(a, i, j);
        }
        if (a[i] > a[end]) Util.swap(a, i, end);
        return i;
    }

    public static void main(String[] args) {
        int[] a = { 1, 5, 4, 2, 9, 3, 11};
        System.out.println(new QuickSelect().solve(a, 3));
    }
}
