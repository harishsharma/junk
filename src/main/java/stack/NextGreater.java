package stack;

import java.util.Stack;

import lombok.extern.slf4j.Slf4j;

/**
 * Given an array, print the Next Greater Element (NGE) for every element. The Next greater Element for an element x is
 * the first greater element on the right side of x in array. Elements for which no greater element exist, consider next
 * greater element as -1.
 * 
 * @author harish.sharma
 *
 */
@Slf4j
public class NextGreater {
    public int[] solve(int[] a) {
        int len = a.length;
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            while (!stack.isEmpty()) {
                int top = stack.peek();
                if (a[i] < top) {
                    res[i] = top;
                    stack.push(a[i]);
                    break;
                } else {
                    stack.pop();
                }
            }
            if (stack.isEmpty()) {
                res[i] = -1;
                stack.push(a[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = { 100, 80, 60, 70, 60, 75, 85};
        log.debug("{}", new NextGreater().solve(a));
    }
}
