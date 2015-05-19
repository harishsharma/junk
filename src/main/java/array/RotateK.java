package array;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


/**
 * Problem: Rotate an array of n elements to the right by k steps. For example, with n = 7 and k = 3, the array
 * [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 * 
 * Assume the erroneous inputs are not given.
 * 
 * Time : O(n) Space: O(1)
 * 
 * @author harish.sharma
 *
 */
@Slf4j
@RequiredArgsConstructor
public class RotateK {

    private final int[] array;
    private final int   k;

    public int[] solve() {
        int len = array.length;
        Util.reverse(array, 0, len - 1 - k);
        Util.reverse(array, len - k, len - 1);
        Util.reverse(array, 0, len - 1);
        return array;
    }

    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4, 5, 6, 7};
        RotateK p0 = new RotateK(a, 3);
        log.info("{} ", p0.solve());
    }
}
