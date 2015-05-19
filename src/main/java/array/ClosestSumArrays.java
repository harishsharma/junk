package array;

/**
 * Given two sorted arrays and a number x, find the pair whose sum is closest to x and the pair has an element from each
 * array.
 * 
 * @author harish.sharma
 *
 */
public class ClosestSumArrays {

    public Pair<Integer, Integer> solve(int[] a, int[] b, int k) {

        int aStart = 0, aEnd = a.length - 1;

        int bStart = 0, bEnd = b.length - 1;
        int currMin = Integer.MAX_VALUE;
        int minI = 0, minJ = 0;
        int i = aStart, j = bEnd;
        for (; i <= aEnd && j >= bStart;) {
            int sum = a[i] + b[j];
            int diff = Math.abs(sum - k);
            if (sum == k) {
                minI = i;
                minJ = j;
                break;
            }
            if (diff < currMin) {
                currMin = diff;
                minI = i;
                minJ = j;
            }

            if (sum > k) {
                j--;
            } else {
                i++;
            }
        }
        return Pair.of(a[minI], b[minJ]);
    }

    public static void main(String[] args) {
        int[] a = { 1, 4, 5, 7};
        int[] b = { 10, 20, 30, 40};
        System.out.println(new ClosestSumArrays().solve(a, b, 23));
        System.out.println(new ClosestSumArrays().solve(a, b, 11));
        System.out.println(new ClosestSumArrays().solve(a, b, 22));
        System.out.println(new ClosestSumArrays().solve(a, b, 47));
        System.out.println(new ClosestSumArrays().solve(a, b, 57));
        System.out.println(new ClosestSumArrays().solve(a, b, 25));
        System.out.println(new ClosestSumArrays().solve(a, b, 35));
        System.out.println(new ClosestSumArrays().solve(a, b, 33));
    }
}
