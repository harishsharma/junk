package stack;

import java.util.Stack;

public class SortStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(3);
        stack.push(9);
        stack.push(2);
        stack.push(6);
        sort(stack);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    static void sort(Stack<Integer> stack) {
        if (stack.isEmpty()) return;
        Integer top = stack.pop();
        sort(stack);
        insertSorted(top, stack);
        return;
    }

    static void insertSorted(Integer top, Stack<Integer> stack) {
        if (stack.isEmpty() || stack.peek() > top) {
            stack.push(top);
            return;
        }
        Integer smaller = stack.pop();
        insertSorted(top, stack);
        stack.push(smaller);
    }
}
