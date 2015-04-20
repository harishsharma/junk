package dp;

import java.util.Arrays;
import java.util.Comparator;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Weighted interval scheduling problem. Job j starts at sj, finishes at fj, and has weight or value vj . Two jobs
 * compatible if they don't overlap. Goal: find maximum weight subset of mutually compatible jobs.
 * 
 * @author harish.sharma
 *
 */
public class WeightedIntervalScheduling {

    public int solve(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>() {

            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.finish - o2.finish;
            }
        });
        int len = intervals.length;
        int[] stops = new int[len];
        for (int i = 0; i < len; i++) {
            stops[i] = intervals[i].finish;
        }
        int[] p = new int[intervals.length];
        p[0] = 0;

        for (int i = 1; i < len; i++) {

        }
        return 0;
    }

    public static void main(String[] args) {
        Interval i1 = new Interval(0, 2, 5);
        Interval i2 = new Interval(1, 5, 3);
        Interval i3 = new Interval(3, 8, 4);
        Interval i4 = new Interval(4, 7, 6);
        Interval i5 = new Interval(6, 9, 1);

        Interval[] intervals = { i1, i2, i3, i4, i5};

        new WeightedIntervalScheduling().solve(intervals);
    }

    @AllArgsConstructor
    @Data
    private static class Interval {
        int start;
        int finish;
        int weight;
    }
}
