package array;

import lombok.extern.slf4j.Slf4j;

/**
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * 
 * @author harish.sharma
 *
 */
@Slf4j
public class MergeSorted {

    public int[] solve(final int[] a, final int[] b) {

        int aLen = a.length;
        int bLen = b.length;
        int[] res = new int[aLen + bLen];
        int i = 0, ap = 0, bp = 0;
        for (; ap < aLen && bp < bLen; i++) {
            if (a[ap] < b[bp]) {
                res[i] = a[ap];
                ap++;
            } else {
                res[i] = b[bp];
                bp++;
            }
        }

        if (ap < aLen) {
            while (ap < aLen)
                res[i++] = a[ap++];
        }
        if (bp < bLen) {
            while (bp < bLen)
                res[i++] = b[bp++];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] a = { 1, 2, 5, 9, 11};
        int[] b = { 3, 7, 8};
        log.debug("{}", (new MergeSorted().solve(a, b)));
    }
}
