package greedy;

import java.util.Collections;
import java.util.List;

import com.google.common.collect.Lists;

import lombok.AllArgsConstructor;
import lombok.ToString;

/**
 * You are given n activities with their start and finish times. Select the maximum number of activities that can be
 * performed by a single person, assuming that a person can only work on a single activity at a time.
 * 
 * @author harish.sharma
 *
 */
public class P1 {
    public static List<Activity> solve(int[] start, int[] finish) {
        int len = start.length;
        List<Activity> activities = Lists.newArrayList();
        for (int i = 0; i < len; i++) {
            activities.add(new Activity(start[i], finish[i]));
        }
        Collections.sort(activities);
        List<Activity> result = Lists.newArrayList();
        result.add(activities.get(0));
        Activity prev = activities.get(0);
        for (int i = 1; i < len; i++) {
            if (prev.finish <= activities.get(i).start) {
                prev = activities.get(i);
                result.add(activities.get(i));
            }
        }
        return result;
    }

    @ToString
    @AllArgsConstructor
    private static class Activity implements Comparable<Activity> {
        int start;
        int finish;

        @Override
        public int compareTo(Activity o) {
            return this.finish - o.finish;
        }
    }


    public static void main(String[] args) {
        int s[] = { 1, 3, 0, 5, 8, 5};
        int f[] = { 2, 4, 6, 7, 9, 9};
        System.out.println(solve(s, f));
    }
}
