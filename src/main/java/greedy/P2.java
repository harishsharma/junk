package greedy;

import java.util.Collections;
import java.util.List;

import com.google.common.collect.Lists;

import lombok.AllArgsConstructor;
import lombok.ToString;

/**
 * Given an array of jobs where every job has a deadline and associated profit if the job is finished before the
 * deadline. It is also given that every job takes single unit of time, so the minimum possible deadline for any job is
 * 1. How to maximize total profit if only one job can be scheduled at a time.
 * 
 * @author harish.sharma
 *
 */
public class P2 {

    public static List<Job> solve(int[] deadLine, int[] profit) {

        int size = deadLine.length;
        List<Job> jobs = Lists.newArrayList();
        for (int i = 0; i < size; i++) {
            jobs.add(new Job(deadLine[i], profit[i]));
        }
        Collections.sort(jobs);
        List<Job> result = Lists.newArrayList();
        boolean[] notAvailable = new boolean[size];
        for (int i = 0; i < size; i++) {
            for (int j = Math.min(jobs.get(i).deadLine - 1, size - 1); j >= 0; j--) {
                if (notAvailable[j] == false) {
                    result.add(jobs.get(i));
                    notAvailable[j] = true;
                    break;
                }
            }
        }
        return result;
    }

    @AllArgsConstructor
    @ToString
    private static class Job implements Comparable<Job> {
        int deadLine;
        int profit;

        @Override
        public int compareTo(Job o) {
            return -(this.profit - o.profit);
        }
    }

    public static void main(String[] args) {
        int[] profit = { 100, 19, 27, 25, 15};
        int[] deadline = { 2, 1, 2, 1, 3};
        System.out.println(solve(deadline, profit));
    }
}
