package array;

/**
 * 
 Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has properties:
 * 
 * 1) Integers in each row are sorted from left to right. 2) The first integer of each row is greater than the last
 * integer of the previous row.
 * 
 * For example, consider the following matrix:
 * 
 * [ [1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 50] ] Given target = 3, return true.
 * 
 * @author harish.sharma
 *
 */
public class MatrixSearch {

    public boolean solve(final int[][] a, final int element) {
        int rows = a.length;
        if (rows == 0) {
            return false;
        }
        int col = a[0].length;
        if (element < a[0][0] || element > a[rows - 1][col - 1]) return false;

        int index = verticalBinarySearch(a, element, rows);

        // you can save this array
        int[] aa = new int[col];
        for (int i = 0; i < col; i++) {
            aa[i] = a[index][i];
        }
        return BinarySearch.search(aa, element);
    }

    /*
     * return the index of the row which contains this element.
     */
    private int verticalBinarySearch(final int[][] a, final int k, int rows) {
        int begin = 0;
        int end = rows - 1;
        int mid;
        while (begin <= end) {
            mid = begin + (end - begin) / 2;
            if (a[mid][0] < k) {
                begin = mid + 1;
            } else if (a[mid][0] > k) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return end;
    }

    public static void main(String[] args) {
        int[][] a = { { 1, 3, 5, 7}, { 10, 11, 16, 20}, { 23, 30, 34, 50}};
        System.out.println(new MatrixSearch().solve(a, 30));
        System.out.println(new MatrixSearch().solve(a, 3));
        System.out.println(new MatrixSearch().solve(a, 0));
        System.out.println(new MatrixSearch().solve(a, 11));
        System.out.println(new MatrixSearch().solve(a, 20));
        System.out.println(new MatrixSearch().solve(a, 440));
        System.out.println(new MatrixSearch().solve(a, 23));
    }
}
