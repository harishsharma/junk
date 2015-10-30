package interviewbit;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author harish.sharma
 *
 */
public class MaxSum {
    public int maxSubArray(final List<Integer> a) {
        int curMax = 0, maxTillNow = a.get(0);
        for (int i : a) {
            curMax = Math.max(i, curMax + i);
            maxTillNow = Math.max(maxTillNow, curMax);
        }
        return maxTillNow;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(-2);
        list.add(-1);
        System.out.println(new MaxSum().maxSubArray(list));
    }
}
