package array;

import java.util.Map;

import com.google.common.collect.Maps;

/**
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 * 
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must
 * be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 * 
 * For example:
 * 
 * Input: numbers={2, 7, 11, 15}, target=9 Output: index1=1, index2=2
 * 
 * @author harish.sharma
 *
 */
public class SumOfTwoEqualK {

    /*
     * 
     * return indexes of elements or null if there is no pair.
     */
    public Pair<Integer, Integer> solve(final int[] array, int target) {
        Map<Integer, Integer> map = Maps.newHashMap();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                return Pair.of(map.get(array[i]), i);
            } else {
                map.put(target - array[i], i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] a = { 2, 7, 11, 13};
        System.out.println(new SumOfTwoEqualK().solve(a, 15));
    }
}
