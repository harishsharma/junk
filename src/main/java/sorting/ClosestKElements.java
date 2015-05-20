package sorting;

import lombok.extern.slf4j.Slf4j;

/**
 * Given a sorted array arr[] and a value X, find the k closest elements to X in arr[]. Examples:
 * 
 * Input: K = 4, X = 35 arr[] = {12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56} Output: 30 39 42 45
 * 
 * @author harish.sharma
 *
 */
@Slf4j
public class ClosestKElements {
    public int[] solve(int[] a, int k, int x) {
        int counter = k;
        int size = a.length;
        int startMarker = 0;
        int endMarker = 0;
        for (int i = 0; i < size; i++) {
            if (counter > 0) {
                endMarker = i;
                counter--;
                continue;
            }
            int diff = Math.abs(a[i] - x);
            int stDiff = Math.abs(a[startMarker] - x);
            if (stDiff > diff) {
                startMarker++;
                endMarker++;
            } else {
                break;
            }

        }
        int[] res = new int[endMarker - startMarker + 1];
        for (int i = startMarker, k1 = 0; i <= endMarker; i++, k1++) {
            res[k1] = a[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = { 12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56};
        log.debug("{}", new ClosestKElements().solve(a, 3, 47));
    }
}
