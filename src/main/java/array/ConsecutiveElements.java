package array;

import java.util.Set;

import com.google.common.collect.Sets;

/**
 * Check if array elements are consecutive
 * 
 * @author harish.sharma
 *
 */
public class ConsecutiveElements {
    public boolean solve(int[] a) {
        if (a.length == 0) return false;
        int min = a[0], max = a[0], len = a.length;
        Set<Integer> set = Sets.newHashSet();
        for (int i = 0; i < len; i++) {
            min = Math.min(min, a[i]);
            max = Math.max(max, a[i]);
            set.add(a[i]);
        }

        for (int i = min; i <= max; i++) {
            if (!set.contains(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] a = { 34, 23, 52, 12, 3};

        System.out.println(new ConsecutiveElements().solve(a));
    }
}
