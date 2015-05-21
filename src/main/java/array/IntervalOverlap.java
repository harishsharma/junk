package array;

import java.util.Arrays;
import java.util.List;

import com.google.common.collect.Lists;

import trees.interval.Interval;

/**
 * Given intervals collapse them into non overlapping ones.
 * 
 * @author harish.sharma
 *
 */
public class IntervalOverlap {
    public static List<Interval> solve(Interval[] input) {
        int len = input.length;
        Arrays.sort(input, (x, y) -> x.getEnd() - y.getEnd());
        int start = 0, end = 0;
        List<Interval> res = Lists.newArrayList();
        Interval prev = input[0];
        for (int i = 1; i < len; i++) {
            if (prev.getEnd() > input[i].getStart()) {
                end++;
            } else {
                res.add(new Interval(input[start].getStart(), input[end].getEnd()));
                prev = input[i];
                start = i;
                end = start;
            }
        }
        res.add(new Interval(input[start].getStart(), input[end].getEnd()));
        return res;
    }

    public static void main(String[] args) {
        Interval[] input = { new Interval(9, 12), new Interval(10, 13), new Interval(14, 16), new Interval(15, 18)};
        System.out.println(solve(input));
    }
}
