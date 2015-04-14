package array;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Median in a stream of integers
 * 
 * @author harish.sharma
 *
 */
public class P27 {

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x, y) -> (y - x));

    public void solve(Scanner in) {
        int i = 0;
        while ((i = in.nextInt()) != -1) {
            System.out.println(calculateMedian(i));
        }
    }

    private double calculateMedian(int i) {

        if (minHeap.size() == 0 && maxHeap.size() == 0) {
            minHeap.add(i);
            return i + 0.0;
        } else if (minHeap.size() == 1 && maxHeap.size() == 0) {
            if (i > minHeap.peek()) {
                maxHeap.add(minHeap.remove());
                minHeap.add(i);
            } else {
                maxHeap.add(i);
            }
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else if (minHeap.size() == 0 && maxHeap.size() == 1) {
            if (i < maxHeap.peek()) {
                minHeap.add(maxHeap.remove());
                maxHeap.add(i);
            } else {
                minHeap.add(i);
            }
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
        int minTop = minHeap.peek();
        int maxTop = maxHeap.peek();
        int minSize = minHeap.size();
        int maxSize = maxHeap.size();

        if (i > minTop && minSize > maxSize) {
            maxHeap.add(minHeap.remove());
            minHeap.add(i);
        } else if (i < maxTop && maxSize > minSize) {
            minHeap.add(maxHeap.remove());
            maxHeap.add(i);
        } else if (i >= minTop) {
            minHeap.add(i);
        } else {
            maxHeap.add(i);
        }

        if (minHeap.size() == maxHeap.size()) {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        } else if (minHeap.size() > maxHeap.size()) {
            return minHeap.peek() + 0.0;
        } else {
            return maxHeap.peek() + 0.0;
        }
    }

    public static void main(String[] args) {
        new P27().solve(new Scanner(System.in));
    }
}
