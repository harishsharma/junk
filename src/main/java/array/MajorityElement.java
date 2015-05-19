package array;

/**
 * A majority element in an array A[] of size n is an element that appears more than n/2 times (and hence there is at
 * most one such element).
 * 
 * @author harish.sharma
 *
 */
public class MajorityElement {

    public Integer solve(int[] a) {
        int len = a.length;
        int maj = a[0];
        int majCount = 1;
        for (int i = 1; i < len; i++) {
            if (maj != a[i])
                majCount--;
            else
                majCount++;

            if (majCount == 0) {
                maj = a[i];
                majCount = 1;
            }
        }

        majCount = 0;
        for (int i = 0; i < len; i++) {
            if (a[i] == maj) majCount++;
        }
        if (majCount >= len / 2 + 1) return maj;
        return null;
    }

    public static void main(String[] args) {
        int[] a = { 1, 1, 1, 1, 2, 2, 2, 2, 2};
        System.out.println(new MajorityElement().solve(a));
    }
}
