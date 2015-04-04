package array;

import java.util.Set;

import com.google.common.collect.Sets;

/**
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * 
 * For example, given [100, 4, 200, 1, 3, 2], the longest consecutive elements sequence should be [1, 2, 3, 4]. Its
 * length is 4.
 * 
 * Your algorithm should run in O(n) complexity.
 * 
 * @author harish.sharma
 *
 */
public class P12 {

    public int solve(final Integer[] a) {
        Set<Integer> set = Sets.newHashSet();
        for (Integer i : a) {
            set.add(i);
        }
        int max = 1;
        int size = a.length;
        for (int i = 0; i < size; i++) {
            int mid = a[i];
            int left = mid - 1;
            int right = mid + 1;
            int count = 1;
            while (set.contains(left)) {
                count++;
                set.remove(left);
                left--;
            }
            while (set.contains(right)) {
                count++;
                set.remove(right);
                right++;
            }
            max = Math.max(max, count);
        }
        return max;
    }

    public static void main(String[] args) {
        Integer[] a = { 1, 7, 3, 5};
        System.out.println(new P12().solve(a));
    }
}
