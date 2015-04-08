package stack;

import java.util.Stack;

import lombok.extern.slf4j.Slf4j;

import array.Pair;

/**
 * The stock span problem is a financial problem where we have a series of n daily price quotes for a stock and we need
 * to calculate span of stock’s price for all n days. The span Si of the stock’s price on a given day i is defined as
 * the maximum number of consecutive days just before the given day, for which the price of the stock on the current day
 * is less than or equal to its price on the given day. For example, if an array of 7 days prices is given as {100, 80,
 * 60, 70, 60, 75, 85}, then the span values for corresponding 7 days are {1, 1, 1, 2, 1, 4, 6}
 * 
 * @author harish.sharma
 *
 */
@Slf4j
public class P1 {
    public int[] solve(int[] a) {
        Stack<Pair<Integer, Integer>> data = new Stack<>();
        int aLen = a.length;
        int[] result = new int[aLen];
        int sum = 1;
        for (int i = 0; i < aLen; i++) {
            while (!data.isEmpty()) {
                Pair<Integer, Integer> pair = data.peek();
                if (pair.getFirst() > a[i]) {
                    break;
                } else {
                    pair = data.pop();
                    sum += pair.getSecond();
                }
            }
            data.add(Pair.of(a[i], sum));
            result[i] = sum;
            sum = 1;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] a = { 100, 80, 60, 70, 60, 75, 85};
        log.debug("{}", new P1().solve(a));
    }
}
