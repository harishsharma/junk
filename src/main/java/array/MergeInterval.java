package array;

import java.util.Collections;
import java.util.List;

import com.google.common.collect.Lists;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * For example, Given [1,3],[2,6],[8,10],[15,18], return [1,6],[8,10],[15,18].
 * 
 * @author harish.sharma
 *
 */
public class MergeInterval {

    public List<Interval> sovle(final List<Interval> input) {
        if (input.size() == 0 || input.size() == 1) return input;

        List<Interval> result = Lists.newArrayList();
        List<Interval> copy = Lists.newArrayList(input);
        Collections.sort(copy);
        Interval prev = copy.get(0);
        for (int i = 1; i < copy.size(); i++) {
            Interval curr = copy.get(i);
            if (prev.end > curr.start) {
                prev = new Interval(prev.start, curr.end);
            } else {
                result.add(prev);
                prev = curr;
            }
        }
        result.add(prev);
        return result;
    }

    @Getter
    @ToString
    @RequiredArgsConstructor
    public static class Interval implements Comparable<Interval> {
        private final int start;
        private final int end;

        public boolean isOverlapping(final Interval a) {
            int aStart = a.getStart();
            int aEnd = a.getEnd();
            if (end >= aStart && start <= aEnd) {
                return true;
            }
            return false;
        }

        /*
         * Return null when not overlapped.
         */
        public Interval getOverlappedInterval(final Interval a) {
            if (!this.isOverlapping(a)) return null;
            int aStart = a.getStart();
            int aEnd = a.getEnd();
            int fStart = start < aStart ? start : aStart;
            int fEnd = end > aEnd ? end : aEnd;
            return new Interval(fStart, fEnd);
        }

        @Override
        public int compareTo(Interval o) {
            return start - o.start;
        }
    }

    public static void main(String[] args) {
        Interval a = new Interval(1, 3);
        Interval b = new Interval(2, 6);
        Interval c = new Interval(8, 10);
        Interval d = new Interval(15, 18);
        List<Interval> list = Lists.newArrayList(a, b, c, d);
        System.out.println(new MergeInterval().sovle(list));
    }
}
